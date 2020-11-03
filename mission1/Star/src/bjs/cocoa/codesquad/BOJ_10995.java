/**
 * BOJ 10995번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.10995
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_10995 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < N * 2 - 1; j++) {
                    if (j % 2 == 0) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            else {
                for (int j = 0; j < N * 2; j++) {
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
