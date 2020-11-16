package prgms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class prgms_42748 {
    public static void main(String[] args) {
        Solution_42748 sol = new Solution_42748();
        System.out.println(
                sol.solution(
                        new int[]{1, 5, 2, 6, 3, 7, 4},
                        new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
                )
        );

    }
}

class Solution_42748 {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
        ArrayList<Integer> answer = new ArrayList<>();
        for (int[] cmd : commands) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>(arr.subList(cmd[0] - 1, cmd[1]));
            Collections.sort(arrayList);
            answer.add(arrayList.get(cmd[2] - 1));
        }
        return answer;
    }
}