package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input < x) answer.add(input);
        }

        for (int ans : answer) {
            System.out.print(ans + " ");
        }

        sc.close();
    }
}
