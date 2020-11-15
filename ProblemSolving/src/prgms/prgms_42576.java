package prgms;

import java.util.HashMap;
import java.util.Map;

public class prgms_42576 {
    public static void main(String[] args) {
        Solution_42576 sol = new Solution_42576();
        System.out.println(sol.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(sol.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(sol.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}

class Solution_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            if (map.containsKey(p)) {
                int count = (int) map.get(p);
                map.put(p, count + 1);
            } else {
                map.put(p, 1);
            }
        }
        for (String c : completion) {
            if (map.containsKey(c)) {
                int count = (int) map.get(c);
                if (count <= 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }
        }
        for (String key : map.keySet()) {
            answer = key;
        }
        return answer;
    }
}
