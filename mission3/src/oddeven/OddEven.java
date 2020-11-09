package oddeven;

import java.util.Random;
import java.util.Scanner;

public class OddEven {

    private static final int MAX_RIVAL = 8;

    public static void main(String[] args) {
        Player user = new Player("", 100);
        Player[] rivals = new Player[MAX_RIVAL];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.next();
        user.setName(name);

        Random rd = new Random();
        rd.setSeed(System.currentTimeMillis());

        int round = 0;
        int turn = 1;
        boolean isExit = false;
        while (!isExit && round < 8) {
            if (rivals[round] == null) {
                makeRival(round, user.getMoney(), rivals);
            }
            System.out.println("\n⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("• Round " + (round + 1) + "\t\t\t\t\t Turn " + turn);
            System.out.println("• Odd or Even? ");
            System.out.println("• " + user.getName() + "'s money : " + user.getMoney());
            System.out.println("• " + rivals[round].getName() + "'s money : " + rivals[round].getMoney());
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");


            int number = rd.nextInt(20) + 1;
            System.out.println("number is " + number);

            turn++;
            betMoney(user, rivals[round], number);

            if (user.getMoney() == 0) {
                printGameOver(turn, user, rivals);
                isExit = true;
                continue;
            }
            if (rivals[round].getMoney() == 0) {
                round++;
                continue;
            }

        }
        sc.close();
    }

    private static void betMoney(Player user, Player rival, int number) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Your choice? (O/o : odd, E/e : even) : ");
        char choice = sc.next().charAt(0);
        choice = Character.toLowerCase(choice);

        int betting = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("How much bet you want? ");
            betting = sc.nextInt();
            if (betting > Math.min(user.getMoney(), rival.getMoney())) {
                System.out.println("Your betting money exceed maximum value.");
            } else {
                valid = true;
            }
        }

        boolean isOdd = number % 2 == 1 ? true : false;

        if (choice == 'o' && isOdd == true) {
            System.out.println("Correct!! It's odd number!!");
            user.addMoney(betting);
            rival.subMoney(betting);
        } else if (choice == 'e' && isOdd == false) {
            System.out.println("Correct!! It's even number!!");
            user.addMoney(betting);
            rival.subMoney(betting);
        } else {
            System.out.println("Wrong!! You lost money..");
            user.subMoney(betting);
            rival.addMoney(betting);
        }

    }

    private static void printGameOver(int turn, Player user, Player[] rivals) {
        System.out.println("\n[Game Over]");
        System.out.println("✓ Turn " + turn);
        System.out.println("✓ " + user.getName() + "'s money is " + user.getMoney());
    }

    private static void makeRival(int round, int userMoney, Player[] rivals) {
        if (round == 0) {
            rivals[0] = new Player("player1", 120);
            return;
        }
        rivals[round] = new Player("player" + round, userMoney * (int) Math.pow(1.5, (double) round));
    }

}
