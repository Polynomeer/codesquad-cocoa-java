package ledger;

import java.io.IOException;

public class Main {
    public static boolean isExit = false;

    public static void main(String[] args) throws IOException {
        LedgerService ledgerService = new LedgerService();
        ledgerService.process();
    }

}
