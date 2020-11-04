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

    static void process(char cmd) {
        // move process by command
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
            System.out.println("W : up, A : left, S : down, D : right, 0 : exit");
            System.out.print("> ");
            char command = sc.next().charAt(0);
            command = java.lang.Character.toLowerCase(command);

            if (command == 'w' || command == 'a' || command == 's' || command == 'd') {
                process(command);
            }
            else if (command == '0') {
                return;
            }
            else {
                System.out.println("Wrong command!!! Put in 'W/A/S/D' to move character");
            }

        }


    }
}
