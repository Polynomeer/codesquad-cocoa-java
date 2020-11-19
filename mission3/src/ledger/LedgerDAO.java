package ledger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LedgerDAO {

    private static ArrayList<LedgerDTO> ledgerList;

    public LedgerDAO() throws FileNotFoundException {
        ledgerList = loadData();
    }

    public ArrayList<LedgerDTO> loadData() throws FileNotFoundException { // access and load data from file
        ledgerList = new ArrayList<>();
        File file = new File("./data.txt"); // create File instance
        Scanner sc = new Scanner(file); // read file by Scanner

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            if (line == null) break; // last enter line has no contents
            int id = Integer.parseInt(line[0]);
            String date = line[1];
            String type = line[2];
            String summary = line[3];
            int revenue = Integer.parseInt(line[4]);
            int expenditure = Integer.parseInt(line[5]);
            int balance = Integer.parseInt(line[6]);

            LedgerDTO ledgerDTO = new LedgerDTO(id, date, type, summary, revenue, expenditure, balance);
            System.out.println(ledgerDTO);
            ledgerList.add(ledgerDTO);
        }
        sc.close();

        return ledgerList;
    }

    public void insert(LedgerDTO ledgerDTO) throws FileNotFoundException {
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

    public void select(int sortBy, char sortType) {
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("id \t\t date \t\t type \t\t summary \t revenue \t expenditure \t balance");

        if (sortBy == 0 && sortType == 0) {
            selectAll();
        }
        if (sortBy == 1) { // sort by date
            Collections.sort(ledgerList);
        }
        if (sortBy == 2) { // sort by revenue
            Collections.sort(ledgerList);
            selectAll();
        }
        if (sortBy == 3) { // sort by expenditure
            Collections.sort(ledgerList);
        }
    }

    public void selectAll() {
        for (LedgerDTO ledger : ledgerList) {
            int balance = 0;
            if (ledger == null) break;
            balance += ledger.getRevenue() - ledger.getExpenditure();
            System.out.println(ledger.getId() + "\t|\t" + ledger.getDate() + "\t|\t" + ledger.getType() + "\t|\t" +
                    ledger.getSummary() + "\t|\t" + ledger.getRevenue() + "\t|\t" + ledger.getExpenditure() + "\t|\t" + balance);
        }
    }

    public void update(LedgerDTO ledgerDTO) throws IOException {
        // update in ArrayList, and rewrite to data file
        BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", false));
        int idx = 0;
        for (LedgerDTO ledger : ledgerList) { // find ledger which matches id
            if (ledger.getId() == ledgerDTO.getId()) { // if id matches, update data
                ledgerList.set(idx, ledgerDTO);
                break;
            }
            idx++;
        }
        for (LedgerDTO ledger : ledgerList) { // rewrite updated ledger list
            bw.write(ledger.toString());
            bw.newLine();
        }
        bw.close();

        ledgerList = this.loadData();
    }

    public void delete(int id) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("./data.txt", false));
        int idx = 0;
        for (LedgerDTO ledger : ledgerList) { // find ledger which matches id
            if (ledger.getId() == id) { // if id matches, update data
                ledgerList.remove(id);
                break;
            }
            idx++;
        }
        for (LedgerDTO ledger : ledgerList) { // rewrite updated ledger list
            bw.write(ledger.toString());
            bw.newLine();
        }
        bw.close();

        ledgerList = this.loadData();
    }

}
