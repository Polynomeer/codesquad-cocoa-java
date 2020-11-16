package ledger;

public class Main {
    public static boolean exitCode = false;
    public static String token = "";

    public static void main(String[] args) {

        LedgerService ledgerService = new LedgerService();

        ledgerService.process();

    }

}
