package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Double> scores = new ArrayList<Double>();
        double maxScore = 0;

        for (int i = 0; i < N; i++) {
            double input = sc.nextDouble();
            scores.add(input);
            maxScore = Math.max(maxScore, scores.get(i));
        }
        sc.close();

        double sum = 0;

        for (int i = 0; i < N; i++) {
            double newScore = scores.get(i) / maxScore * 100;
            scores.set(i, newScore);
            sum += scores.get(i);
        }

        double average = sum / N;
        System.out.println(average);
    }
}
