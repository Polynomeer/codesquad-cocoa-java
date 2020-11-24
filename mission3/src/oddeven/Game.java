package oddeven;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner sc;
    private final Random rd;

    public Game(Scanner sc, Random rd) {
        this.sc = sc;
        this.rd = rd;
    }

    public void play() {
        Player player = new Player("", 100);
        Player[] rivals = new Player[OddEvenMain.MAX_RIVAL];

        System.out.print("Enter your name : ");
        String name = sc.next();
        player.setName(name);

        process(player, rivals);
    }

    private void process(Player player, Player[] rivals) {
        rd.setSeed(System.currentTimeMillis());
        int round = 0;
        int turn = 1;

        while (!OddEvenMain.isExit && round < 8) {
            int number = initRound(player, rivals, round, turn);
            turn++;

            betMoney(player, rivals[round], number);
            checkGameOver(turn, player, rivals[round]);

            if (rivals[round].getMoney() == 0) {
                round++;
            }
        }
    }

    private int initRound(Player player, Player[] rivals, int round, int turn) {
        if (rivals[round] == null) {
            makeRival(round, player.getMoney(), rivals);
        }
        System.out.println("\n⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("• Round " + (round + 1) + "\t\t\t\t\t Turn " + turn);
        System.out.println("• Odd or Even? ");
        System.out.println("• " + player.getPlayer());
        System.out.println("• " + rivals[round].getPlayer());
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

        int number = rd.nextInt(20) + 1;
        System.out.println("number is " + number);
        return number;
    }

    private void betMoney(Player player, Player rival, int number) {
        System.out.print("Your choice? (O/o : odd, E/e : even) : ");
        char choice = sc.next().charAt(0);
        choice = Character.toLowerCase(choice);

        boolean valid = false;
        int betting = 0;

        while (!valid) {
            System.out.print("How much bet do you want? ");
            betting = sc.nextInt();

            if (betting > Math.min(player.getMoney(), rival.getMoney())) {
                System.out.println("Your betting money exceed maximum value.");
            } else {
                valid = true;
            }
        }
        checkWinner(player, rival, number, choice, betting);
    }

    private void checkWinner(Player player, Player rival, int number, char choice, int betting) {
        boolean isOdd = number % 2 == 1;

        if ((choice == 'o' && isOdd == true) || (choice == 'e' && isOdd == false)) {
            System.out.println("Correct!! It's " + (isOdd == true ? "odd" : "even") + " number!!");
            player.winMoney(rival, betting);
        } else {
            System.out.println("Wrong!! You lost money..");
            rival.winMoney(player, betting);
        }
    }

    private void checkGameOver(int turn, Player player, Player rival) {
        if (player.getMoney() == 0) {
            System.out.println("\n[Game Over]");
            System.out.println("✓ Turn " + turn);
            System.out.println("✓ " + player.getPlayer());
            System.out.println("✓ " + rival.getPlayer());
            OddEvenMain.isExit = true;
        }
    }

    private void makeRival(int round, int playerMoney, Player[] rivals) {
        if (round == 0) {
            rivals[0] = new Player("player 1", 120);
            return;
        }
        rivals[round] = new Player("player " + round, playerMoney * (int) Math.pow(1.5, (double) round));
    }

}
