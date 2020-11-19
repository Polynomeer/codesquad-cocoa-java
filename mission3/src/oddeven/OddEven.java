package oddeven;

import java.util.Random;
import java.util.Scanner;

public class OddEven {

    private static final int MAX_RIVAL = 8;
    private static Scanner sc;
    private static Random rd;
    public static boolean isExit = false;

    public OddEven() {
        sc = new Scanner(System.in);
        rd = new Random();
    }

    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        Player player = new Player("", 100);
        Player[] rivals = new Player[MAX_RIVAL];

        System.out.print("Enter your name : ");
        String name = sc.next();
        player.setName(name);
        oddEven.process(player, rivals);

        sc.close();
    }

    private void process(Player player, Player[] rivals) {
        rd.setSeed(System.currentTimeMillis());

        int round = 0;
        int turn = 1;

        while (!isExit && round < 8) {
            if (rivals[round] == null) {
                makeRival(round, player.getMoney(), rivals);
            }
            System.out.println("\n⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("• Round " + (round + 1) + "\t\t\t\t\t Turn " + turn);
            System.out.println("• Odd or Even? ");
            System.out.println("• " + player.getName() + "'s money : " + player.getMoney());
            System.out.println("• " + rivals[round].getName() + "'s money : " + rivals[round].getMoney());
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

            int number = rd.nextInt(20) + 1;
            System.out.println("number is " + number);

            turn++;
            betMoney(player, rivals[round], number);

            if (number == 0) { // exit code 0
                isExit = true;
            }
            if (player.getMoney() == 0) {
                printGameOver(turn, player, rivals);
                isExit = true;
            }
            if (rivals[round].getMoney() == 0) {
                round++;
            }
        }
    }

    private void betMoney(Player player, Player rival, int number) {
        System.out.print("Your choice? (O/o : odd, E/e : even) : ");
        char choice = sc.next().charAt(0);
        choice = Character.toLowerCase(choice);

        boolean valid = false;

        while (!valid) {
            System.out.print("How much bet you want? ");
            int betting = sc.nextInt();
            if (betting > Math.min(player.getMoney(), rival.getMoney())) {
                System.out.println("Your betting money exceed maximum value.");
            } else {
                player.setBetting(betting);
                valid = true;
            }
        }
        checkWinner(player, rival, number, choice);
    }

    private void checkWinner(Player player, Player rival, int number, char choice) {
        boolean isOdd = number % 2 == 1;
        int betting = player.getBetting();

        if (choice == 'o' && isOdd == true) {
            System.out.println("Correct!! It's odd number!!");
            player.winMoney(rival.loseMoney(betting));
        } else if (choice == 'e' && isOdd == false) {
            System.out.println("Correct!! It's even number!!");
            player.winMoney(rival.loseMoney(betting));
        } else {
            System.out.println("Wrong!! You lost money..");
            rival.winMoney(player.loseMoney(betting));
        }
    }

    private void printGameOver(int turn, Player player, Player[] rivals) {
        System.out.println("\n[Game Over]");
        System.out.println("✓ Turn " + turn);
        System.out.println("✓ " + player.getName() + "'s money is " + player.getMoney());
    }

    private void makeRival(int round, int playerMoney, Player[] rivals) {
        if (round == 0) {
            rivals[0] = new Player("player1", 120);
            return;
        }
        rivals[round] = new Player("player" + round, playerMoney * (int) Math.pow(1.5, (double) round));
    }

}
