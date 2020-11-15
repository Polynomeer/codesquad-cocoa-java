package boj;

import java.util.Scanner;

public class BOJ_2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] id = new int[5];

        int verificationNumber = 0;
        for (int i = 0; i < 5; i++) {
            id[i] = sc.nextInt();
            verificationNumber += id[i] * id[i];
        }
        verificationNumber %= 10;
        System.out.println(verificationNumber);
    }
}
