import java.util.ArrayList;
import java.util.Collections;

public class prgms_12910 {
    public static void main(String[] args) {
        Solution_12910 sol = new Solution_12910();
        System.out.println(sol.solution(new int[]{5, 9, 7, 10}, 5));
        System.out.println(sol.solution(new int[]{2, 36, 1, 3}, 1));
        System.out.println(sol.solution(new int[]{3, 2, 6}, 10));
    }
}

class Solution_12910 {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            if (i % divisor == 0) {
                answer.add(i);
            }
        }
        Collections.sort(answer);
        if (answer.size() == 0) {
            answer.add(-1);
        }

        return answer;
    }
}
