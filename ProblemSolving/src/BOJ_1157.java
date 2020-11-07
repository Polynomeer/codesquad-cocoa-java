import java.util.*;

public class BOJ_1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        sc.close();

        int[] alphaTable = new int[26];
        int maxHit = 0;
        ArrayList<Character> maxAlpha = new ArrayList<>();

        for (char alpha : str.toCharArray()) {
            alphaTable[alpha - 'a']++;
        }

        for (int i : alphaTable) {
            maxHit = Math.max(maxHit, i);
        }

        for (int i = 0; i < alphaTable.length; i++) {
            if (alphaTable[i] == maxHit) maxAlpha.add((char) (i + 'A'));
        }

        if (maxAlpha.size() >= 2) {
            System.out.println("?");
        } else {
            for (char c : maxAlpha) {
                System.out.println(c);
            }
        }

    }
}
