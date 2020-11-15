package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] position = new int[26];

        Arrays.fill(position, -1); // initialize all value in position as -1

        int index = 0;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (position[i] == -1) {
                position[i] = index;
            }
            index++;
        }

        for (int i : position) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
