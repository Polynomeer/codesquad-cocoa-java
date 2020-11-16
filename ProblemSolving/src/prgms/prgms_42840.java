package prgms;

import java.util.ArrayList;

public class prgms_42840 {
    public static void main(String[] args) {
        Solution_42840 sol = new Solution_42840();
        System.out.println(sol.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sol.solution(new int[]{1, 3, 2, 4, 2}));
    }
}

class Solution_42840 {

    private static int[] student1 = {1, 2, 3, 4, 5};
    private static int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] students = new int[3];
        int idx = 0;
        int score = 0;
        int maxScore = 0;
        
        for (int a : answers) {
            if (idx >= 5) idx %= 5;
            if (a == student1[idx++]) score++;
        }
        maxScore = score;
        students[0] = score;
        
        idx = score = 0;
        for (int a : answers) {
            if (idx >= 8) idx %= 8;
            if (a == student2[idx++]) score++;
        }
        maxScore = Math.max(score, maxScore);
        students[1] = score;
        
        idx = score = 0;
        for (int a : answers) {
            if (idx >= 10) idx %= 10;
            if (a == student3[idx++]) score++;
        }
        maxScore = Math.max(score, maxScore);
        students[2] = score;

        idx = 1;
        for (int s : students) {
            if (s == maxScore) answer.add(idx);
            idx++;
        }

        return answer;
    }
}