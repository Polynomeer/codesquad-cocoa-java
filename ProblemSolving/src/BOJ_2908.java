import java.util.Scanner;

public class BOJ_2908 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        a = reverse(a);
        b = reverse(b);

        int integerA = Integer.parseInt(a);
        int integerB = Integer.parseInt(b);

        int answer = Math.max(integerA, integerB);
        System.out.println(answer);
    }

    private static String reverse(String s) {
        String result = "";

        for (int i = 0; i < s.length() / 2; i++) {
            result = swap(s, i, s.length() - i - 1);
        }
        return result;
    }

    private static String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        String str = String.valueOf(charArray);
        return str;
    }
}
