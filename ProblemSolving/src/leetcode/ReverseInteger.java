package leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        long answer = 0;
        final int MAX_INT = 2147483647;

        while (x != 0) {
            answer *= 10;
            answer += x % 10;
            if (answer > MAX_INT || answer < -MAX_INT) return 0; // returns 0 when the reversed integer overflows
            x /= 10;
        }
        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(1463847412));
    }

}
