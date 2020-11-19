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
    private Date date;
    private boolean isDateChosen = true;

    public MyCalendar() {
        this.calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
        date = new Date(); // need to fix, cannot get date from Calendar

        // get day of week for 1st of the month
        this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        this.daysInMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    }

    void printCalendar() {
        printColumn();
        printSpace();
        printDays();
    }

    void printCalendar(int year, int month) {
        this.isDateChosen = false;
        this.calendar.set(year, month - 1, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
        this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
        this.daysInMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
        printCalendar();
    }

    void printCalendar(int year) {
        this.isDateChosen = false;
        for (int m = 0; m < 12; m++) {
            this.calendar.set(year, m, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
            this.dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
            this.daysInMonth = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
            printCalendar();
            System.out.println();
        }
    }

    // print columns (month, year, week)
    private void printColumn() {
        System.out.println(new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
        System.out.println(" Sun  Mon  Tue  Wed  Thu  Fri  Sat");
    }

    // print initial spaces
    private void printSpace() {
        String initSpace = "";
        for (int i = 0; i < dayOfWeek - 1; i++) {
            initSpace += "     ";
        }
        System.out.print(initSpace);
    }

    // print the days of the month starting from 1
    private void printDays() {
        for (int dayOfMonth = 1; dayOfMonth <= daysInMonth; ) {
            for (int j = ((dayOfMonth == 1) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                if (this.isDateChosen == true && date.getDate() == dayOfMonth) {
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
