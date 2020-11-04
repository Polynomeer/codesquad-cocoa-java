package SimpleRPG.cocoa.codesquad;

import java.util.Random;

public class Map {
    int[][] map;
    public static final int MAP_SIZE = 11;

    public void initMap(Character c, Monster m, Bomb b) {
        Random rd = new Random();
        this.map = new int[11][11];

        int c_x = c.getX();
        int c_y = c.getY();
        int m_x = m.getX();
        int m_y = m.getY();
        int b_x = b.getX();
        int b_y = b.getY();

        this.map[c_x][c_y] = 1; // 1 : character
        this.map[m_x][m_y] = 2; // 2 : monster
        this.map[b_x][b_y] = -1; // -1 : bomb
    }

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -1) { // hide bomb to user
                    System.out.print(0 + "\t");
                }
                else {
                    System.out.print(map[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
