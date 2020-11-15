package boj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_10952 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> answer = new ArrayList<>();

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            answer.add(a + b);
        }

        for (int i : answer) {
            System.out.println(i);
        }

        sc.close();
    }
}
