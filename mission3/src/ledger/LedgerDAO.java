package ledger;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class LedgerDAO {

    private static ArrayList<LedgerVO> ledgerList;

    public LedgerDAO() throws FileNotFoundException, ParseException {
        ledgerList = loadData();
    }

    public ArrayList<LedgerVO> loadData() throws FileNotFoundException, ParseException { // access and load data from file
        ledgerList = new ArrayList<>();
        File file = new File("./august.csv"); // create File instance
        Scanner sc = new Scanner(file); // read file by Scanner
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            if (line == null) continue; // last enter line has no contents
            int id = Integer.parseInt(line[0]);
            Date date = format.parse(line[1]);
            String type = line[2];
            String summary = line[3];
            int revenue = Integer.parseInt(line[4]);
            int expenditure = Integer.parseInt(line[5]);
            int balance = Integer.parseInt(line[6]);

            LedgerVO ledgerVO = new LedgerVO(id, date, type, summary, revenue, expenditure, balance);
            System.out.println(ledgerVO);
            ledgerList.add(ledgerVO);
        }
        sc.close();

        return ledgerList;
    }

    public void insert(LedgerVO ledgerVO) throws FileNotFoundException, ParseException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./august.csv", true));
            bw.write(ledgerVO.toString());
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        int balance = 0;

        for (LedgerVO ledger : ledgerList) {
            if (ledger == null) continue;
            
            String date = simpleDateFormat.format(ledger.getDate());
            balance += ledger.getRevenue() - ledger.getExpenditure();

            System.out.println(ledger.getId() + "\t|\t" + date + "\t|\t" + ledger.getType() + "\t|\t" +
                    ledger.getSummary() + "\t|\t" + ledger.getRevenue() + "\t|\t" + ledger.getExpenditure() + "\t|\t" + balance);
        }
    }

    public void update(LedgerVO ledgerVO) throws IOException {
        // update in ArrayList, and rewrite to data file
        BufferedWriter bw = new BufferedWriter(new FileWriter("./august.csv", false));
        int idx = 0;
        for (LedgerVO ledger : ledgerList) { // find ledger which matches id
            if (ledger.getId() == ledgerVO.getId()) { // if id matches, update data
                ledgerList.set(idx, ledgerVO);
                break;
            }
            idx++;
        }
        for (LedgerVO ledger : ledgerList) { // rewrite updated ledger list
            bw.write(ledger.toString());
            bw.newLine();
        }
        calcBalance();
        bw.close();
    }

    public void delete(int id) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("./august.csv", false));
        int idx = 0;
        for (LedgerVO ledger : ledgerList) { // find ledger which matches id
            if (ledger.getId() == id) { // if id matches, update data
                ledgerList.remove(id);
                break;
            }
            idx++;
        }
        for (LedgerVO ledger : ledgerList) { // rewrite updated ledger list
            bw.write(ledger.toString());
            bw.newLine();
        }
        calcBalance();
        bw.close();
    }

    private void calcBalance(){
        int balance = 0;

        for (LedgerVO ledger : ledgerList) {
            if (ledger == null) continue;

            balance += ledger.getRevenue() - ledger.getExpenditure();
            ledger.setBalance(balance);
        }
    }

}
