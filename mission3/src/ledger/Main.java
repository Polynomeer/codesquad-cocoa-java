package ledger;

import java.util.Scanner;

public class Main {
    private static final int MAX_LEDGER = 31;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ledger[] ledgers = new Ledger[MAX_LEDGER];
        User user = new User("");
        int index = 0;
        boolean exitCode = false;

        while (!exitCode) {
            if (user.isEmpty()) {
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
                System.out.println("                    Your Financial ledger.Ledger");
                System.out.println("Please register your account.");
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

                System.out.print("user name : ");
                String username = sc.next();
                System.out.print("user password : ");
                String password = sc.next();

                user.setUsername(username);
                user.setPassword(password);
                continue;
            }

            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("\t\t" + user.getUsername() + "'s Financial ledger.Ledger");
            System.out.println("1 : input data, 2 : delete data, 3 : modify data, 4 : print data");
            System.out.println("5 : user registration 0: exit");
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

            int input = sc.nextInt();
            switch (input) {
                case 0:
                    exitCode = true;
                    break;
                case 1:
                    inputData(ledgers, index++);
                    break;
                case 2:
                    deleteData(ledgers);
                    break;
                case 3:
                    modifyData(ledgers);
                    break;
                case 4:
                    printData(ledgers);
                    break;
            }
        }
        sc.close();
    }

    private static void inputData(Ledger[] ledgers, int id) {
        Scanner sc = new Scanner(System.in);
        System.out.print("date : ");
        String date = sc.next();
        System.out.print("summary : ");
        String summary = sc.next();
        System.out.print("revenue : ");
        int revenue = sc.nextInt();
        System.out.print("expenditure : ");
        int expenditure = sc.nextInt();
        ledgers[id] = new Ledger(id, date, summary, revenue, expenditure);
    }

    private static void deleteData(Ledger[] ledgers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("index to delete : ");
        int index = sc.nextInt();
        ledgers[index].delete();
    }

    private static void modifyData(Ledger[] ledgers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("index to modify : ");
        int index = sc.nextInt();
        System.out.print("date : ");
        String date = sc.next();
        System.out.print("summary : ");
        String summary = sc.next();
        System.out.print("revenue : ");
        int revenue = sc.nextInt();
        System.out.print("expenditure : ");
        int expenditure = sc.nextInt();
        ledgers[index].modify(date, summary, revenue, expenditure);
    }

    private static void printData(Ledger[] ledgers) {
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("id \t\t date \t\t summary \t revenue \t expenditure \t balance");
        int balance = 0;
        for (Ledger l : ledgers) {
            if (l == null) break;
            balance = l.print(balance);
        }

    }

}
