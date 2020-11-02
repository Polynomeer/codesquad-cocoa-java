/**
 * BOJ 1330번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.1330
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_1330 {
    public static void main(String[] args) {
        int A, B;
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        if ( A > B ) System.out.println(">");
        else if ( A < B ) System.out.println("<");
        else System.out.println("==");
    }
}
