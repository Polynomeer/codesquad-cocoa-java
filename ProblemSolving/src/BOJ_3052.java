import java.util.Scanner;

public class BOJ_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        int[] remains = new int[42];
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
            int r = num[i] % 42;
            remains[r]++;
        }

        for (int i = 0; i < 42; i++) {
            if (remains[i] > 0) answer++;
        }

        System.out.println(answer);
        sc.close();
    }
}
