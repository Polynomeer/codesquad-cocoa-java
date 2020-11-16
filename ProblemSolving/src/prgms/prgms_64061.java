package prgms;

import java.util.Stack;

public class prgms_64061 {
    public static void main(String[] args) {
        Solution_64061 sol = new Solution_64061();
        System.out.println(sol.solution(
                new int[][]{{0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})
        );
    }
}

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> s = new Stack<>();

        for (int m : moves) {
            for (int i = 0; i < n; i++) {

                if (board[i][m - 1] != 0) {
                    int doll = board[i][m - 1];
                    board[i][m - 1] = 0;

                    if (s.isEmpty()) {
                        s.push(doll);
                        break;
                    }

                    int top = s.peek();
                    if (top == doll) { // if the doll on top is same, pop from stack
                        s.pop();
                        answer += 2;
                    } else { // if not same, just push into stack
                        s.push(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}