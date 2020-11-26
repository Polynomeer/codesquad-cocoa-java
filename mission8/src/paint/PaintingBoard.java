package paint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import java.util.stream.Collectors;

enum DRAW_TYPE {
    PEN, LINE, CURVE, RECTANGLE, OVAL
}

class PaintingBoard extends Frame implements MouseMotionListener, MouseListener, ActionListener {
    private final int COLOR_TYPE = 4;
    private final int SHAPE_TYPE = 5;
    private DRAW_TYPE drawType = DRAW_TYPE.PEN;

    Point curPoint;
    Point startPoint;
    Point endPoint;
    private boolean isClear = false;

    Vector<Point> sv = new Vector<Point>(); // 시작
    Vector<Point> se = new Vector<Point>(); // 끝점

    private Image img = null;
    private Graphics gImg = null;

    private CheckboxGroup colorGroup, shapeGroup;
    private Checkbox cb_color[] = new Checkbox[COLOR_TYPE];
    private Checkbox cb_shape[] = new Checkbox[SHAPE_TYPE];

    private Label location;
    private Button bt_clear;

    public static void main(String[] args) {
        new PaintingBoard("Painting Board");
    }

    public PaintingBoard(String title) {
        super(title);

        initCheckbox();
        initLocation();
        initButton();
        initMenuBar();

        addListeners();
        // Frame을 (100, 100)의 위치에 width 500, height 500 크기로 보이게 한다.
        setBounds(100, 100, 500, 500);
        setVisible(true);

        img = createImage(500, 500);
        gImg = img.getGraphics();
        repaint();
    }

    private void addListeners() {
        addMouseMotionListener(this); // 자기자신의 인스턴스를 Frame의 Listener로 등록한다.
        addMouseListener(this); // 자기자신의 인스턴스를 Frame의 MouseListener로 등록한다.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        bt_clear.addActionListener(this);
    }

    private void initMenuBar() {
        MenuBar mb = new MenuBar();
        Menu mFile = new Menu("File");
        MenuItem miNew = new MenuItem("New");
        MenuItem miOpen = new MenuItem("Open");
        MenuItem miSave = new MenuItem("Save");
        miSave.setActionCommand("Save");
        miSave.addActionListener(this);
        Menu mOthers = new Menu("Others");  // MenuItem이 아니라 Menu임에 주의
        MenuItem miExit = new MenuItem("Exit");

        mFile.add(miNew);           // Menu에 MenuItem들을 추가한다.
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.add(mOthers);         // Menu에 Menu를 추가한다.
        mFile.addSeparator();       // 메뉴 분리선을 넣는다.
        mFile.add(miExit);

        MenuItem miPrint = new MenuItem("Print ...");
        MenuItem miPreview = new MenuItem("Print Preview");
        MenuItem miSetup = new MenuItem("Print Setup ...");
        mOthers.add(miPrint);
        mOthers.add(miPreview);
        mOthers.add(miSetup);

        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");
        Menu mHelp = new Menu("Help");
        CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
        mView.add(miStatusbar);

        mb.add(mFile);          // MenuBar에 Menu를 추가한다.
        mb.add(mEdit);
        mb.add(mView);
        mb.setHelpMenu(mHelp);  // mHelp를 HelpMenu로 지정한다.

        this.setMenuBar(mb);    // Frame에 MenuBar를 포함시킨다.
    }

    private void initButton() {
        bt_clear = new Button("Clear");
        add(bt_clear);
    }

    private void initLocation() {
        location = new Label("Mouse Pointer Location : ");
        location.setSize(300, 15);
        location.setLocation(5, 30);
        location.setBackground(Color.lightGray);
        add(location);
    }

    private void initCheckbox() {
        colorGroup = new CheckboxGroup();
        shapeGroup = new CheckboxGroup();
        cb_color[0] = new Checkbox("black", colorGroup, true);
        cb_color[1] = new Checkbox("red", colorGroup, false);
        cb_color[2] = new Checkbox("green", colorGroup, false);
        cb_color[3] = new Checkbox("blue", colorGroup, false);

        cb_shape[0] = new Checkbox("pen", shapeGroup, true);
        cb_shape[1] = new Checkbox("line", shapeGroup, false);
        cb_shape[2] = new Checkbox("curve", shapeGroup, false);
        cb_shape[3] = new Checkbox("rectangle", shapeGroup, false);
        cb_shape[4] = new Checkbox("oval", shapeGroup, false);

        for (int i = 0; i < COLOR_TYPE; i++) {
            cb_color[i].addItemListener(new EventHandler());
            add(cb_color[i]);
        }

        for (int i = 0; i < SHAPE_TYPE; i++) {
            cb_shape[i].addItemListener(new EventHandler());
            add(cb_shape[i]);
        }
        setLayout(new FlowLayout());
    }


    class EventHandler implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            Checkbox cb = (Checkbox) e.getSource();
            String checked = cb.getLabel();

            if (checked.equals("black")) {
                gImg.setColor(Color.black);
            } else if (checked.equals("red")) {
                gImg.setColor(Color.red);
            } else if (checked.equals("green")) {
                gImg.setColor(Color.green);
            } else if (checked.equals("blue")) {
                gImg.setColor(Color.blue);
            } else if (checked.equals("pen")) {
                drawType = DRAW_TYPE.PEN;
            } else if (checked.equals("line")) {
                drawType = DRAW_TYPE.LINE;
            } else if (checked.equals("curve")) {
                drawType = DRAW_TYPE.CURVE;
            } else if (checked.equals("rectangle")) {
                drawType = DRAW_TYPE.RECTANGLE;
            } else if (checked.equals("oval")) {
                drawType = DRAW_TYPE.OVAL;
            }
        }

    }

    public void paint(Graphics g) {
        if (img == null) return;
        if (isClear == true) {
//            g = img.getGraphics();
            Color tempColor = g.getColor();
            g.setColor(SystemColor.window);
            g.fillRect(0, 0, 500, 500);
            g.setColor(tempColor);  // get back to selected color

            repaint();
            isClear = false;
        }
        if (drawType == DRAW_TYPE.LINE){
            if (sv.size() != 0) {
                for (int i = 0; i < se.size(); i++) { //벡터크기만큼
                    Point sp = sv.get(i); // 벡터값을꺼내다
                    Point ep = se.get(i);
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);
                }
            }
            if (startPoint != null){
                g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
            }
        }

        g.drawImage(img, 0, 0, this); // 가상화면에 그려진 그림을 Frame에 복사
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        sv.add(e.getPoint());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        se.add(e.getPoint());
        int width = e.getX() - startPoint.x > 0 ? e.getX() - startPoint.x : startPoint.x - e.getX();
        int height = e.getY() - startPoint.y > 0 ? e.getY() - startPoint.y : startPoint.y - e.getY();

        if (drawType == DRAW_TYPE.LINE) {
            gImg.drawLine(startPoint.x, startPoint.y, e.getX(), e.getY());
            repaint();
        } else if (drawType == DRAW_TYPE.OVAL) {
            if (startPoint.x < endPoint.x || startPoint.y < endPoint.y)
                gImg.drawOval(startPoint.x, startPoint.y, width, height);
            else if (startPoint.x > endPoint.x || startPoint.y > endPoint.y)
                gImg.drawOval(endPoint.x, endPoint.y, width, height);
            repaint();
        } else if (drawType == DRAW_TYPE.RECTANGLE) {
            if (startPoint.x < endPoint.x || startPoint.y < endPoint.y)
                gImg.drawRect(startPoint.x, startPoint.y, width, height);
            else if (startPoint.x > endPoint.x || startPoint.y > endPoint.y)
                gImg.drawRect(endPoint.x, endPoint.y, width, height);
            repaint();
        } else if (drawType == DRAW_TYPE.CURVE) {
            gImg.drawArc(startPoint.x, startPoint.y, e.getX(), e.getY(), 0, 120);
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        curPoint = e.getPoint();
        location.setText(" Location : [" + curPoint.x + ", " + curPoint.y + "]");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;

        if (drawType == DRAW_TYPE.PEN) {
            gImg.drawLine(curPoint.x, curPoint.y, e.getX(), e.getY()); // this statement must be precede before e.getPoint()
            curPoint = e.getPoint();
            repaint();
        } else if (drawType == DRAW_TYPE.LINE) {
//            TODO: erase all afterimage after mouseReleased()
            endPoint = e.getPoint();
            repaint();
        } else if (drawType == DRAW_TYPE.RECTANGLE) {
//            gImg.drawRect(startPoint.x,startPoint.y,e.getX(),e.getY());
        } else if (drawType == DRAW_TYPE.OVAL) {
//            gImg.drawOval(startPoint.x,startPoint.y,e.getX(),e.getY());
        } else if (drawType == DRAW_TYPE.CURVE) {
//            gImg.drawArc(startPoint.x, startPoint.y, e.getX(), e.getY(), 0,120);
        }

    }

    public void saveImage() {
        try {
            BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            this.paint(graphics2D);
            ImageIO.write(image, "jpeg", new File("./image.jpeg"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void actionPerformed(ActionEvent e) {
//        TODO: how can I separate actionHandlers?
        if (e.getActionCommand().equals("Clear")) {
            isClear = true;
        } else if (e.getActionCommand().equals("Save")) {
            saveImage();
        }
        paint(gImg);
    }
}