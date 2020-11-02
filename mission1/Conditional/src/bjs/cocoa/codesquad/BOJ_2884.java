/**
 * BOJ 2884번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.2884
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        getTime(H, M);
    }

    static int getTime(int h, int m) {
        if ( m - 45 < 0 ) {
            h -= 1;
            m = (60 + m) - 45;
        }
        else {
            m -= 45;
        }
        if ( h < 0 ) {
            h = 24 + h;
        }
        System.out.println(h + " " + m);
        return 0;
    }

}