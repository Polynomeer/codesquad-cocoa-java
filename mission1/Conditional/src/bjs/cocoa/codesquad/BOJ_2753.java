/**
 * BOJ 2753번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.2753
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean isLeap = false;

        isLeap = checkLeap(year);

        if (isLeap == true)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static boolean checkLeap(int year) {
        if ( (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ) {
            return true;
        }
        return false;
    }

}