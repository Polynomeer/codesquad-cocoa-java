/**
 * BOJ 2443번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.2443
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j < N; j++) {
                System.out.print("*");
            }
            for (int j = i; j < N - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
