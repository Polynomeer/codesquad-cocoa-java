package SimpleRPG.cocoa.codesquad;

import java.util.Random;

public class Monster {
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

    public void initMonster() {
        Random rd = new Random();
        while (true){
            this.x = rd.nextInt(11);
            this.y = rd.nextInt(11);
            if (this.x != 5 && this.y != 5) break;
        }

    }
}
