package clock;

import java.util.Scanner;

public class ClockExample {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("What do you want to print? (clock: Hangul clock, cal: Calendar, q: quit)");
            System.out.print(">> ");
            String command = sc.nextLine();
            String[] commands = command.split(" ");

            if (command.equals("q")) break;
            if (commands[0].equals("clock")) {
                runClock();
            } else if (commands[0].equals("cal")) {
                runCalendar(commands);
            }
        }
        sc.close();
    }

    private static void runCalendar(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        if (args.length == 1) {
            myCalendar.printCalendar();
            return;
        }
        if (args.length >= 3){
            int year = Integer.parseInt(args[1]);
            int month = Integer.parseInt(args[2]);
            myCalendar.printCalendar(year, month);
            return;
        }
    }

    public static void runClock() {
        HangulClock hangulClock = new HangulClock();
        while (true) {
            try {
                hangulClock.clearScreen();
                hangulClock.printScreen(hangulClock.getCalendar());
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
