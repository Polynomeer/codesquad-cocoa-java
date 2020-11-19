package oddeven;

import java.util.Random;
import java.util.Scanner;

public class OddEven {

    public static final int MAX_RIVAL = 8;
    public static boolean isExit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OddEven oddEven = new OddEven();
        Handler handler = new Handler(sc);
        handler.handle();

        sc.close();
    }


}
