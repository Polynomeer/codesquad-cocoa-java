/**
 * BOJ 9498번 문제풀이
 *
 * @author Polynomeer
 * @version 1.0, 1st solved BOJ.9498
 * @caution 클래스 이름을 Main으로 변경 후 채점 가능
 */
package bjs.cocoa.codesquad;

import java.util.Scanner;

public class BOJ_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        score /= 10;

        printScore(score);
    }

    static void printScore(int score) {
        switch (score) {
            case 9: case 10:
                System.out.println("A");
                break;
            case 8 :
                System.out.println("B");
                break;
            case 7 :
                System.out.println("C");
                break;
            case 6 :
                System.out.println("D");
                break;
            default :
                System.out.println("F");
        }
    }

}