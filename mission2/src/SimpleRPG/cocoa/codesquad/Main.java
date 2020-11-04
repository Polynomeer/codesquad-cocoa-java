package SimpleRPG.cocoa.codesquad;

import java.util.Scanner;

public class Main {
    static Character character;
    static Monster monster;
    static Bomb bomb;
    static Map map;

    static void initialize() {
        // set character position on center
        character.setX(5);
        character.setY(5);

        // set monster position randomly
        monster.initMonster();

        // initialize the map with each position
        map.initMap(character, monster, bomb);
        map.printMap();
    }

    static void moveProcess(char cmd) {
        if (cmd == 'w') {
            character.moveUp();
        }
        else if (cmd == 'a') {
            character.moveLeft();
        }
        else if (cmd == 's') {
            character.moveDown();
        }
        else if (cmd == 'd') {
            character.moveRight();
        }
    }

    static int checkPosition() {
        int c_x = character.getX();
        int c_y = character.getY();
        int m_x = monster.getX();
        int m_y = monster.getY();
        int b_x = bomb.getX();
        int b_y = bomb.getY();

        if (c_x == m_x && c_y == m_y) {
            character.addScore(monster.getScore());
            return 1; // character is at monster
        }
        else if (c_x == b_x && c_y == b_y) {
            return -1; // character is at bomb
        }
        return 0;
    }

    static void printState(int state) {
        if (state == 1) {
            System.out.println("Congratulations!!! You got score " + monster.getScore() + "!!!");
        }
        if (state == -1) {
            System.out.println("Game Over : You stepped on bomb!! ");
            System.out.println("Do you want to retry? (Y: yes, N: no)");
            System.out.print("> ");

            Scanner sc = new Scanner(System.in);
            char cmd = sc.next().charAt(0);
            cmd = java.lang.Character.toLowerCase(cmd);

            if (cmd == 'n') {
                System.out.println("Exit game...");
                System.exit(0);
            }
        }
    }
    static void process(char cmd) {
        // move process by command
        moveProcess(cmd);
        // check position if character is at bomb or monster
        int stateCode = checkPosition();
        printState(stateCode);
        map.initMap(character, monster, bomb);
        map.printMap();
    }

    public static void main(String[] args) {
        character = new Character();
        monster = new Monster();
        bomb = new Bomb();
        map = new Map();

        Scanner sc = new Scanner(System.in);

        initialize();

        while (true) {
            System.out.println(" ⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("| This round monster score is " + monster.getScore() + "\t              |");
            System.out.println("| W : up, A : left, S : down, D : right, 0 : exit |");
            System.out.println("| Your score is " + character.getScore() + "\t                              |");
            System.out.println(" ⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.print("> ");
            char command = sc.next().charAt(0);
            command = java.lang.Character.toLowerCase(command);

            if (command == 'w' || command == 'a' || command == 's' || command == 'd') {
                process(command);
            }
            else if (command == '0') {
                sc.close();
                return;
            }
            else {
                System.out.println("Wrong command!!! Put in 'W/A/S/D' to move character");
            }

        }


    }
}
