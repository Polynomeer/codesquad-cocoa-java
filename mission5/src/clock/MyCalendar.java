package clock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyCalendar {
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[32m";
    private Calendar calendar;
    private int dayOfWeek;
    private int daysInMonth;
    Date date;

    public MyCalendar() {
        this.calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
        date = new Date(); // need to fix, cannot get date from Calendar

        // get day of week for 1st of the month
        this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        this.daysInMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    }

    public void printCalendar() {
        printColumn();
        printSpace();
        printDays();
    }

    public void printCalendar(int year, int month) {
        this.calendar.set(year, month, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
        this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        this.daysInMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);

        printColumn();
        printSpace();
        printDays();
    }

    private void printColumn() {
        // print columns (month, year, week)
        System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
        System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat");
    }

    private void printSpace() {
        // print initial spaces
        String initSpace = "";
        for (int i = 0; i < dayOfWeek - 1; i++) {
            initSpace += "     ";
        }
        System.out.print(initSpace);
    }

    private void printDays() {
        // print the days of the month starting from 1
        for (int dayOfMonth = 1; dayOfMonth <= daysInMonth; ) {
            for (int j = ((dayOfMonth == 1) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                if (date.getDate() == dayOfMonth) {
                    String space = date.getDate() >= 10 ? "  " : "   ";
                    System.out.print(space + ANSI_GREEN + dayOfMonth + ANSI_RESET + " ");
                } else {
                    System.out.printf("%4d ", dayOfMonth);
                }
                dayOfMonth++;
            }
            System.out.println();
        }
    }

}
