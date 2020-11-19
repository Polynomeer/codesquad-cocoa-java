package ledger;

import java.io.FileNotFoundException;

public class Main {
    public static boolean isExit = false;

    public static void main(String[] args) throws FileNotFoundException {
        LedgerService ledgerService = new LedgerService();
        ledgerService.process();
    }

}
