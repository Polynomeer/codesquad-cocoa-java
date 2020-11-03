/**
 * BOJ 10996번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.10996
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_10996 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N * 2; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < N; j++) {
                    if (j % 2 == 0) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            else {
                for (int j = 0; j < N; j++) {
                    if (j % 2 != 0) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
