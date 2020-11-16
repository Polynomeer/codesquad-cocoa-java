package ledger;

import java.util.Scanner;

public class UserService {

    UserDAO userDAO = new UserDAO();

    private void process(){
        Scanner sc = new Scanner(System.in);
        UserDTO userDTO = new UserDTO("user");
        while (!Main.exitCode) {
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
                System.out.println("                    Your Financial ledger.Ledger");
                System.out.println("Please register your account.");
                System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

                System.out.print("user name : ");
                String username = sc.next();
                System.out.print("user password : ");
                String password = sc.next();

                userDTO.setUsername(username);
                userDTO.setPassword(password);
                continue;
        }
        sc.close();
    }


}
