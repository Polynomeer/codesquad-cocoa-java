package boj;

import java.util.Scanner;

public class BOJ_2675 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] p = new String[T];

        for (int testcase = 0; testcase < T; testcase++) {
            int r = sc.nextInt();
            String s = sc.next();
            p[testcase] = makeString(r, s);
        }

        for (String s : p) {
            System.out.println(s);
        }

    }

    private static String makeString(int r, String s) {

        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < r; j++) {
                result += s.charAt(i);
            }
        }

        return result;
    }
}
