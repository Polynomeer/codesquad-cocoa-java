package leetcode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0, j = s.length() - 1;
        while (i != j && i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(11));
    }
}
