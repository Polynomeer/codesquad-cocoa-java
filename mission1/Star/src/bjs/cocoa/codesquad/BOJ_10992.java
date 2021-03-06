/**
 * BOJ 10992번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.10992
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_10992 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0) System.out.print("*");
                else System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                if (j == i) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < N * 2 - 1; i++) {
            System.out.print("*");
        }
        sc.close();
    }
}
