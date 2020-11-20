package oddeven;

import java.util.Random;
import java.util.Scanner;

public class OddEvenMain {

    public static final int MAX_RIVAL = 8;
    public static boolean isExit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        OddEvenMain oddEvenMain = new OddEvenMain();
        Game game = new Game(sc, rd);
        game.play();

        sc.close();
    }


}
