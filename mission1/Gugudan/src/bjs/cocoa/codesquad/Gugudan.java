package bjs.cocoa.codesquad;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {

        int start, end;
        Scanner scan = new Scanner(System.in);

        System.out.print("첫 단을 입력해주세요 : ");
        start = scan.nextInt();
        System.out.print("끝 단을 입력해 주세요 : ");
        end = scan.nextInt();

        printGugudan(start, end);
    }

    static void printGugudan(int start, int end) {
        for ( int i = start; i <= end; i++ ) {
            for ( int j = 2; j <= 9; j++ ) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
            System.out.println("----------------------------");
        }
    }

}
