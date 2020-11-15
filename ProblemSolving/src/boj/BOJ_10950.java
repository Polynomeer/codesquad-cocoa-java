package boj;

import java.util.Scanner;

public class BOJ_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];

        for (int testcase = 0; testcase < T; testcase++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            answer[testcase] = a + b;
        }

        for (int i : answer) {
            System.out.println(i);
        }

        sc.close();
    }
}
