package leetcode;

public class RomanToInteger {
    static final int num[] = {1, 5, 10, 50, 100, 500, 1000};

    public static int getNumFromTable(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public static int romanToInt(String s) {
        int answer = 0;
        int n = s.length() - 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int num = getNumFromTable(chars[i]);
            int nextNum = getNumFromTable(chars[i + 1]);
            int result = num;

            if ((num == 1 && nextNum == 5) || (num == 1 && nextNum == 10) || (num == 10 && nextNum == 50) ||
                    (num == 10 && nextNum == 100) || (num == 100 && nextNum == 500) || (num == 100 && nextNum == 1000)) {
                result = nextNum - num;
                i++;
                if (i == chars.length - 1) return answer + result;
            }
            answer += result;

        }
        answer += getNumFromTable(chars[n]);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("MMCDXXV"));
    }
}
