package clock;

public class ClockExample {
    public static void main(String[] args) {
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
