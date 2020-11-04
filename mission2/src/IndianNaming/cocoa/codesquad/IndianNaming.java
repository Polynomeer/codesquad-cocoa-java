package IndianNaming.cocoa.codesquad;

import java.util.Scanner;

public class IndianNaming {
    public static void main(String[] args) {
        Indian indian = new Indian();
        Scanner sc = new Scanner(System.in);

        indian.setYear(sc.nextInt());
        indian.setMonth(sc.nextInt());
        indian.setDay(sc.nextInt());

        String name = indian.naming();
        System.out.println(name);

    }
}
