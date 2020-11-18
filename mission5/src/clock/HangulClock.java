package clock;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class HangulClock {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String[][] hours = {{"열", "두2"}, {"한"}, {"두"}, {"세"}, {"네"}, {"다", "섯"}, {"여", "섯2"}, {"일", "곱"}, {"여2", "덟"}, {"아", "홉"}, {"열"}, {"열", "한2"}, {"열", "두2"}};
    private static final String[][] minutes = {
            {""}, {"일2"}, {"이2"}, {"삼2"}, {"사2"}, {"오3"}, {"육"}, {"칠"}, {"팔"}, {"구"}, {"십"}, {"십", "일2"}, {"십", "이2"},
            {"십", "삼2"}, {"십", "사2"}, {"십", "오3"}, {"십", "육"}, {"십", "칠"}, {"십", "팔"}, {"십", "구"}, {"이", "십"}, {"이", "십", "일2"},
            {"이", "십", "이2"}, {"이", "십", "삼2"}, {"이", "십", "사2"}, {"이", "십", "오3"}, {"이", "십", "육"}, {"이", "십", "칠"},
            {"이", "십", "팔"}, {"이", "십", "구"}, {"삼", "십"}, {"삼", "십", "일2"}, {"삼", "십", "이2"}, {"삼", "십", "삼2"}, {"삼", "십", "사2"},
            {"삼", "십", "오3"}, {"삼", "십", "육"}, {"삼", "십", "칠"}, {"삼", "십", "팔"}, {"삼", "십", "구"}, {"사", "십"}, {"사", "십", "일2"},
            {"사", "십", "이2"}, {"사", "십", "삼2"}, {"사", "십", "사2"}, {"사", "십", "오3"}, {"사", "십", "육"}, {"사", "십", "칠"},
            {"사", "십", "팔"}, {"사", "십", "구"}, {"오", "십"}, {"오", "십", "일2"}, {"오", "십", "이2"}, {"오", "십", "삼2"}, {"오", "십", "사2"},
            {"오", "십", "오3"}, {"오", "십", "육"}, {"오", "십", "칠"}, {"오", "십", "팔"}, {"오", "십", "구"}};
    private static final Calendar calendar = Calendar.getInstance();
    private static final Date date = new Date();
    private static final String[][] clock = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한2", "두2", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이2", "삼2", "사2", "육"},
            {"오2", "오3", "칠", "팔", "구", "분"}};
    private static boolean[][] clockSet = new boolean[6][6];

    public static Calendar getCalendar() {
        return calendar;
    }

    public static void printScreen(Calendar calendar) {
        date.setTime(System.currentTimeMillis());
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        initClockSet();
        setClock(hour, minute);

        for (int i = 0; i < clock.length; i++) {
            for (int j = 0; j < clock[i].length; j++) {
                String block = clock[i][j];

                if (clockSet[i][j] == true) {
                    System.out.print(ANSI_GREEN + block.charAt(0) + ANSI_RESET + " ");
                } else {
                    System.out.print(block.charAt(0) + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setClock(int hour, int minute) {
        String[] hourString = hours[hour];
        String[] minuteString = minutes[minute];

        if (hour == 12 && minute == 0) {
            clockSet[4][0] = true; // 정 on
            clockSet[5][0] = true; // 오 on
            clockSet[2][5] = false; // 시 off
            clockSet[5][5] = false; // 분 off
            return;
        }

        if (hour == 0 && minute == 0) {
            clockSet[3][0] = true; // 자 on
            clockSet[4][0] = true; // 정 on
            clockSet[2][5] = false; // 시 off
            clockSet[5][5] = false; // 분 off
            return;
        }

        for (int i = 0; i < clock.length; i++) {
            for (int j = 0; j < clock[i].length; j++) {
                for (int k = 0; k < hourString.length; k++) {
                    if (hourString[k].equals(clock[i][j])) {
                        clockSet[i][j] = true;
                    }
                }
                for (int k = 0; k < minuteString.length; k++) {
                    if (minuteString[k].equals(clock[i][j])) {
                        clockSet[i][j] = true;
                    }
                }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void initClockSet() {
        Arrays.stream(clockSet).forEach(a -> Arrays.fill(a, false));
        clockSet[2][5] = true; // 시 : default set is true
        clockSet[5][5] = true; // 분 : default set is true
    }

}
