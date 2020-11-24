package paint;

import java.awt.*;
import java.awt.event.*;

class PaintingBoard extends Frame implements MouseMotionListener {
    private final int COLOR_TYPE = 4;
    int x = 0;
    int y = 0;

    Image img = null;
    Graphics gImg = null;

    CheckboxGroup group;
    Checkbox cb[] = new Checkbox[COLOR_TYPE];

    public static void main(String[] args) {
        new PaintingBoard("Painting Board");
    }

    public PaintingBoard(String title) {
        super(title);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        initCheckbox();

        // Frame을 (100, 100)의 위치에 width 500, height 500 크기로 보이게 한다.
        setBounds(100, 100, 500, 500);
        setVisible(true);

        img = createImage(500, 500);
        gImg = img.getGraphics();
        repaint();
    }

    private void initCheckbox() {
        group = new CheckboxGroup();
        cb[0] = new Checkbox("black", group, true);
        cb[1] = new Checkbox("red", group, false);
        cb[2] = new Checkbox("green", group, false);
        cb[3] = new Checkbox("blue", group, false);

        for (int i = 0; i < COLOR_TYPE; i++) {
            cb[i].addItemListener(new EventHandler());
            add(cb[i]);
        }

        setLayout(new FlowLayout());
    }

    class EventHandler implements ItemListener {

        public void itemStateChanged(ItemEvent e) {

            Checkbox cb = (Checkbox) e.getSource();
            String color = cb.getLabel();

            if (color.equals("black")) {
                gImg.setColor(Color.black);
            } else if (color.equals("red")) {
                gImg.setColor(Color.red);
            } else if (color.equals("green")) {
                gImg.setColor(Color.green);
            } else {
                gImg.setColor(Color.blue);
            }
        }

    }

    public void paint(Graphics g) {
        if (img == null) return;
        g.drawImage(img, 0, 0, this); // 가상화면에 그려진 그림을 Frame에 복사
    }

    public void mouseMoved(MouseEvent me) {
        x = me.getX();
        y = me.getY();
    }

    public void mouseDragged(MouseEvent me) {
        if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
        gImg.drawLine(x, y, me.getX(), me.getY());
        x = me.getX();
        y = me.getY();
        repaint();
    }

}
