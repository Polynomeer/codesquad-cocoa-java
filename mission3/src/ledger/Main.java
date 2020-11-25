package ledger;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static boolean isExit = false;

    public static void main(String[] args) throws IOException, ParseException {
        LedgerService ledgerService = new LedgerService();
        ledgerService.process();
    }

}
