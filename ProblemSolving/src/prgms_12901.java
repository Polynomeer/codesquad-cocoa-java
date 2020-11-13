import java.util.ArrayList;

public class prgms_12901 {
    public static void main(String[] args) {
        Solution_12901 sol = new Solution_12901();
        System.out.println(sol.solution(5, 24));
    }
}



class Solution_12901 {
    // 2016.1.1 is Friday, THU 0 FRI 1 SAT 2 SUN 3 MON 4 TUE 5 WED 6
    private static String[] Week = {
            "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"
    };

    public String solution(int month, int day) {
        String answer = "";
        int days = 0; // total days including month
        int months[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < month - 1; i++) {
            days += months[i];
        }
        days += day;
        answer = Week[(days % 7)]; // decide the day of the week by dividing by 7

        return answer;
    }

}