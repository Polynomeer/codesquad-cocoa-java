package ledger;

import java.io.IOException;
import java.text.ParseException;

public class LedgerMain {
    public static boolean isExit = false;

    public static void main(String[] args) throws IOException, ParseException {
        UserService userService = new UserService();
        String username = userService.process();
        LedgerService ledgerService = new LedgerService(username);
        ledgerService.process();
    }

}
