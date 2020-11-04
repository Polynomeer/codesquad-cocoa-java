package SimpleRPG.cocoa.codesquad;

public class Character {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp() {
        if (this.x - 1 < 0) {
            System.out.println("Unable to move up");
            return;
        }
        this.x--;
    }

    public void moveLeft() {
        if (this.y - 1 < 0) {
            System.out.println("Unable to move left");
            return;
        }
        this.y--;
    }

    public void moveDown() {
        if (this.x + 1 > 11) {
            System.out.println("Unable to move down");
            return;
        }
        this.x++;
    }

    public void moveRight() {
        if (y + 1 > 11) {
            System.out.println("Unable to move right");
            return;
        }
        y++;
    }
}
