package prgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class prgms_68644 {
    public static void main(String[] args) {
        Solution_68644 sol = new Solution_68644();
        System.out.println(sol.solution(new int[]{2, 1, 3, 4, 1}));
        System.out.println(sol.solution(new int[]{5, 0, 2, 7}));
    }
}

class Solution_68644 {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) break;
                int sum = numbers[i] + numbers[j];
                map.put(sum, 0);
            }
        }

        for(Map.Entry <Integer, Integer> entry : map.entrySet()){
            answer.add(entry.getKey());
        }

        Collections.sort(answer);

        return answer;
    }
}