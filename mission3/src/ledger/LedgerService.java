package ledger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LedgerService {

    private List<LedgerDTO> ledgers;
    private LedgerDAO ledgerDAO;
    private static Scanner sc;

    public LedgerService() {
        ledgerDAO = new LedgerDAO();
    }

    public void process() {

        sc = new Scanner(System.in);

        int index = 0;
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("\t\t" + "'s Financial ledger.Ledger");
        System.out.println("1 : input data, 2 : delete data, 3 : modify data, 4 : print data");
        System.out.println("5 : user registration 0: exit");
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

        int input = sc.nextInt();
        switch (input) {
            case 0:
                Main.exitCode = true;
                break;
            case 1:
                inputData(index++);
                break;
            case 2:
                    deleteData();
                break;
            case 3:
                modifyData();
                break;
            case 4:
                printData();
                break;
        }
    }

    private static LedgerDTO getInputByKeyboard(int id) {
        LedgerDTO ledgerDTO;
        System.out.print("date : ");
        String date = sc.next();
        System.out.print("summary : ");
        String summary = sc.next();
        System.out.print("revenue : ");
        int revenue = sc.nextInt();
        System.out.print("expenditure : ");
        int expenditure = sc.nextInt();
        ledgerDTO = new LedgerDTO(id, date, summary, revenue, expenditure);
        return ledgerDTO;
    }

    private static void inputData(int id) {
        LedgerDTO ledgerDTO = getInputByKeyboard(id);
        LedgerDAO.insert(ledgerDTO);
    }

    private static void printData() {
        LedgerDAO.select();
    }

    private static void modifyData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("id to modify : ");
        int id = sc.nextInt();
        LedgerDTO ledgerDTO = getInputByKeyboard(id);
        LedgerDAO.update(ledgerDTO);
    }

    private static void deleteData() {

    }


}
