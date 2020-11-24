package ledger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LedgerService {

    private static LedgerDAO ledgerDAO;
    private static Scanner sc;

    public LedgerService() throws FileNotFoundException, ParseException {
        ledgerDAO = new LedgerDAO();
        File file = new File("./data.txt"); // create File instance
        sc = new Scanner(file); // read file by Scanner
    }

    public void process() throws IOException, ParseException {
        int index = 0;
        // get index from last line
        while (sc.hasNextLine()) {
            index = sc.nextLine().charAt(0) - '0';
        }

        sc = new Scanner(System.in);
        while (!Main.isExit) {
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("\t\t" + "'s Financial ledger.Ledger");
            System.out.println("1 : input data, 2 : delete data, 3 : modify data, 4 : print data");
            System.out.println("0: exit");
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

            int input = sc.nextInt();
            switch (input) {
                case 0:
                    Main.isExit = true;
                    break;
                case 1:
                    inputData(++index);
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

    }

    private static LedgerDTO getInputByKeyboard(int id) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        System.out.print("date : ");
        Date date = format.parse(sc.next());
        System.out.print("type : ");
        String type = sc.next();
        System.out.print("summary : ");
        String summary = sc.next();
        System.out.print("revenue : ");
        int revenue = sc.nextInt();
        System.out.print("expenditure : ");
        int expenditure = sc.nextInt();

        return new LedgerDTO(id, date, type, summary, revenue, expenditure, 0);
    }

    private static void inputData(int id) throws FileNotFoundException, ParseException {
        LedgerDTO ledgerDTO = getInputByKeyboard(id);
        ledgerDAO.insert(ledgerDTO);
    }

    private static void printData() {
        System.out.print("Do you want to sort data? (Y/N)");
        char choice = sc.next().charAt(0);
        choice = Character.toLowerCase(choice);
        int sortBy = 0;
        char sortType = 0;
        if (choice == 'y') {
            System.out.print("Sort by 1. date 2. revenue 3. expenditure ? ");
            sortBy = sc.nextInt();
            System.out.print("Ascending (A/a)? or Descending (D/d)? ");
            sortType = sc.next().charAt(0);
            sortType = Character.toLowerCase(sortType);
        }
        ledgerDAO.select(sortBy, sortType);
    }

    private static void modifyData() throws IOException, ParseException {
        sc = new Scanner(System.in);
        System.out.print("id to modify : ");
        int id = sc.nextInt();
        LedgerDTO ledgerDTO = getInputByKeyboard(id);
        ledgerDAO.update(ledgerDTO);
    }

    private static void deleteData() throws IOException {
        System.out.print("id to delete : ");
        int id = sc.nextInt();
        ledgerDAO.delete(id);
    }

}
