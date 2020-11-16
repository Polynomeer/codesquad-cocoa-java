package prgms;

public class prgms_12928 {
    public static void main(String[] args) {
        Solution_12928 sol = new Solution_12928();
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(5));
    }
}

class Solution_12928 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer += i;
        }
        return answer;
    }

}