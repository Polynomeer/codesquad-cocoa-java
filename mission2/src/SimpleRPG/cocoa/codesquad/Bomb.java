package SimpleRPG.cocoa.codesquad;

import java.util.Random;

public class Bomb {
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
            // get random bomb position
            int bomb_x = rd.nextInt(Map.MAP_SIZE);
            int bomb_y = rd.nextInt(Map.MAP_SIZE);
            if (this.x != 5 && this.y != 5) break;
        }

    }

}
