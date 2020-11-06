import java.util.Scanner;

public class BOJ_8958 {

    public static void checkScore(String result) {
        int totalScore = 0;

        for (int i = 0; i < result.length(); i++) {
            int sum = 0;

            boolean isCorrect = false;
            if (result.charAt(i) == 'O') {
                isCorrect = true;
            }

            while (isCorrect && i < result.length()) {
                if ( result.charAt(i) == 'X' ) {
                    isCorrect = false;
                }
                else {
                    sum++;
                    totalScore += sum;
                    i++;
                }
            }
        }
        System.out.println(totalScore);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] results = new String[N];

        for (int i = 0; i < N; i++) {
            results[i] = sc.next();
        }
        sc.close();

        for (String res : results) {
            checkScore(res);
        }
    }

}