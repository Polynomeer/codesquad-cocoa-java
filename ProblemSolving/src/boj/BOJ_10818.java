package boj;

import java.util.Scanner;

public class BOJ_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        int maxNum = -987654321, minNum = 987654321;

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            maxNum = Math.max(maxNum, num[i]);
            minNum = Math.min(minNum, num[i]);
        }

        System.out.println(minNum + " " + maxNum);
        sc.close();
    }
}
