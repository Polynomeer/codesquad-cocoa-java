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
                if (line == null) break; // last enter line has no contents
                int id = Integer.parseInt(line[0]);
                String date = line[1];
                String summary = line[2];
                int revenue = Integer.parseInt(line[3]);
                int expenditure = Integer.parseInt(line[4]);

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

    public void insert(LedgerDTO ledgerDTO) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", true));
            bw.write(ledgerDTO.toString());
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        ledgerList = this.loadData(); // maybe memory loss
    }

    public void select() {
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

    public void update(LedgerDTO ledgerDTO) {
        try { // update in ArrayList, and rewrite to data file
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", false));
            int idx = 0;
            for (LedgerDTO l : ledgerList){ // find ledger which matches id
                if (l.getId() == ledgerDTO.getId()) { // if id matches, update data
                    ledgerList.set(idx, ledgerDTO);
                    break;
                }
                idx++;
            }
            for (LedgerDTO l : ledgerList) { // rewrite updated ledger list
                bw.write(l.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ledgerList = this.loadData();
    }

    public void delete(int id) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", false));
            int idx = 0;
            for (LedgerDTO l : ledgerList){ // find ledger which matches id
                if (l.getId() == id) { // if id matches, update data
                    ledgerList.remove(id);
                    break;
                }
                idx++;
            }
            for (LedgerDTO l : ledgerList) { // rewrite updated ledger list
                bw.write(l.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ledgerList = this.loadData();
    }
}
