package ledger;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LedgerDAO {

    private ArrayList<LedgerVO> ledgerList;
    private File file;
    private Scanner sc;
    private SimpleDateFormat format;
    private String username;

    public LedgerDAO(String username) throws FileNotFoundException, ParseException {
        this.username = username;
        file = new File("./" + username + ".csv"); // create File instance
        sc = new Scanner(file); // read file by Scanner
        format = new SimpleDateFormat("yyyy-mm-dd");

        ledgerList = loadData();
    }

    public ArrayList<LedgerVO> loadData() throws ParseException { // access and load data from file
        ledgerList = new ArrayList<>();

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

    public void insert(LedgerVO ledgerVO) throws ParseException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./" + username + ".csv"));
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

        if (sortBy == 1) { // sort by date
            if (sortType == 'a') {
                Collections.sort(ledgerList, Comparator.comparing((LedgerVO ledger) -> ledger).thenComparing(LedgerVO::getDate));
            } else if (sortType == 'd') {
                Collections.sort(ledgerList, Comparator.reverseOrder());
            }
            select();
        }
        if (sortBy == 2) { // sort by revenue
            if (sortType == 'a') {
                Collections.sort(ledgerList, Comparator.comparingInt(LedgerVO::getRevenue));
            } else if (sortType == 'd') {
                Collections.sort(ledgerList, (LedgerVO l1, LedgerVO l2) -> l2.getRevenue() - l1.getRevenue());
            }
            select();
        }
        if (sortBy == 3) { // sort by expenditure
            if (sortType == 'a') {
                Collections.sort(ledgerList, Comparator.comparingInt(LedgerVO::getExpenditure));
            } else if (sortType == 'd') {
                Collections.sort(ledgerList, (LedgerVO l1, LedgerVO l2) -> l2.getExpenditure() - l1.getExpenditure());
            }
            select();
        }
    }

    public void select() {
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
        BufferedWriter bw = new BufferedWriter(new FileWriter("./" + username + ".csv"));
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
        BufferedWriter bw = new BufferedWriter(new FileWriter("./" + username + ".csv"));
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

    private void calcBalance() {
        int balance = 0;

        for (LedgerVO ledger : ledgerList) {
            if (ledger == null) continue;

            balance += ledger.getRevenue() - ledger.getExpenditure();
            ledger.setBalance(balance);
        }
    }

}
