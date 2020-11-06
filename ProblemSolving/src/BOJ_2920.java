import java.util.Scanner;

public class BOJ_2920 {

    static boolean isAscending(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] >= s[i+1]) {
                return false;
            }
        }
        return true;
    }

    static boolean isDescending(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] <= s[i+1]) {
                return false;
            }
        }
        return true;
    }

    static void checkSorted(int[] s) {
        if (isAscending(s) == true) {
            System.out.println("ascending");
            return;
        }
        if (isDescending(s) == true) {
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scale = new int[8];
        for (int i = 0; i < 8; i++) {
            scale[i] = sc.nextInt();
        }
        checkSorted(scale);
    }
}

