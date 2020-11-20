package hackerrank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    static String timeConversion(String s) {
        String answer = s.substring(0, 8);
        String noon = s.substring(8);
        int hour = Integer.parseInt(s.substring(0, 2));

        if (hour == 12 && noon.equals("PM")) {
            return answer;
        }
        if (hour == 12 && noon.equals("AM")) {
            hour -= 12;
        }
        if (noon.equals("PM")) {
            hour += 12;
        }

        StringBuffer sb = new StringBuffer(answer);

        if (hour < 10) {
            sb.replace(0, 2, "0" + Integer.toString(hour));
        } else {
            sb.replace(0, 2, Integer.toString(hour));
        }
        answer = sb.toString();

        return answer;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
