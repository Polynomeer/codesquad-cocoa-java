package boj;

import java.util.Scanner;

public class BOJ_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[9];
        int maxNum = 0;
        for (int i = 0; i < 9; i++) {
            num[i] = sc.nextInt();
            maxNum = Math.max(maxNum, num[i]);
        }
        for (int i = 0; i < 9; i++) {
            if (num[i] == maxNum) {
                System.out.println(maxNum);
                System.out.println(i + 1);
            }
        }
    }
}
