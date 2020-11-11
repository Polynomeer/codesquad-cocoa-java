package ledger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerDAO {

    private static ArrayList<LedgerDTO> ledgerList;

    public LedgerDAO() {
        ledgerList = loadData();
    }

    public ArrayList<LedgerDTO> loadData() { // access and load data from file
        ledgerList = new ArrayList<>();
        try {
            File file = new File("./data.txt"); // create File instance
            Scanner sc = new Scanner(file); // read file by Scanner

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(" ");

                int id = Integer.parseInt(line[0]);
                String summary = line[1];
                String date = line[2];
                int revenue = Integer.parseInt(line[3]);
                int expenditure = Integer.parseInt(line[4]);

//                int id = sc.nextInt();
//                String summary = sc.next();
//                String date = sc.next();
//                int revenue = sc.nextInt();
//                int expenditure = sc.nextInt();
//                sc.nextLine();

                LedgerDTO ledgerDTO = new LedgerDTO(id, date, summary, revenue, expenditure);
                System.out.println(ledgerDTO);
                ledgerList.add(ledgerDTO);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ledgerList;
    }

    public static void insert(LedgerDTO ledgerDTO) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", true));
            bw.newLine();
            bw.write(ledgerDTO.toString());
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void select() {
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("id \t\t date \t\t summary \t revenue \t expenditure \t balance");
        int balance = 0;
        for (LedgerDTO l : ledgerList) {
            if (l == null) break;
            balance += l.getRevenue() - l.getExpenditure();
            System.out.println(l.getId() + "\t|\t" + l.getDate() + "\t|\t" + l.getSummary() + "\t|\t" +
                    l.getRevenue() + "\t|\t" + l.getExpenditure() + "\t|\t" + balance);
        }
    }

    public static void update(LedgerDTO ledgerDTO) {
        try {
            File file = new File("./data.txt"); // create File instance
            Scanner sc = new Scanner(file); // read file by Scanner

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.charAt(0) - '0' == ledgerDTO.getId()) { // if id number is matched
                    System.out.println(line.charAt(0));
                    BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", false));
                    bw.write(ledgerDTO.toString());
                    bw.close();
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
