package ledger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private UserDAO userDAO;
    private Scanner sc;
    private List<UserVO> userList;

    public UserService() {
        userDAO = new UserDAO();
        sc = new Scanner(System.in);
        userList = new ArrayList<>();
    }

    private void process(){

        while (!Main.isExit) {
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
                System.out.println("                    Your Financial ledger.Ledger");
                System.out.println("Please register your account.");
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

                System.out.print("user name : ");
                String username = sc.next();
                System.out.print("user password : ");
                String password = sc.next();
                UserVO userVO = new UserVO(username, password);

                continue;
        }
        sc.close();
    }


}
