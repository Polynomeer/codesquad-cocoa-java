import java.util.Scanner;

public class BOJ_1018 {

    private static int n;
    private static int m;
    private static char[][] chess;

    public static void getInputFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        chess = new char[n][m];

        for (int i = 0; i < n; i++) {
            String inputStr = sc.next();
            for (int j = 0; j < m; j++) {
                chess[i][j] = inputStr.charAt(j);
            }
        }
    }

    public static int mask(int x, int y, char color) {
        int paint = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (j % 2 == 0 && chess[i][j] != color) paint++;
                else if (j % 2 == 1 && chess[i][j] == color) paint++;
            }
            color = color == 'B' ? 'W' : 'B'; // put different color into next block
        }
        return paint;
    }

    public static void printChess() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getInputFromKeyboard();
        int answer = 987654321;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {

                answer = Math.min(answer, mask(i, j, 'W'));
                answer = Math.min(answer, mask(i, j, 'B'));
            }
        }
        System.out.println(answer);
    }
}
