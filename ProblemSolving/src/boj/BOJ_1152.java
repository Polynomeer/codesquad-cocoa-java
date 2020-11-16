package boj;

import java.util.Scanner;

public class BOJ_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        str = str.trim();   // trim first and end space
        if (str.isEmpty()) {
            System.out.println(0);
        }
        else {
            String[] strArr = str.split("\\s"); // split string by space
            System.out.println(strArr.length);
        }
    }
}
