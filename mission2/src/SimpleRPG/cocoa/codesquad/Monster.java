package SimpleRPG.cocoa.codesquad;

import java.util.Random;

public class Monster {
    private static final int MAX_SCORE = 5000;
    private int x;
    private int y;
    private int score = 0;

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

    public int getScore() {
        return score;
    }

    public void initMonster() {
        Random rd = new Random();
        while (true){
            this.x = rd.nextInt(11);
            this.y = rd.nextInt(11);
            this.score = rd.nextInt(MAX_SCORE);
            if (this.x != 5 && this.y != 5) break;
        }

    }
}
