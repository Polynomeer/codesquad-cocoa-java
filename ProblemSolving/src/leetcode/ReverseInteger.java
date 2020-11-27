package leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            answer *= 10;
            answer += x % 10;
            x /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

}
