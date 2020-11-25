package ledger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    private Scanner sc;
    private List<UserVO> userList;

    public UserService() throws FileNotFoundException {
        userList = new ArrayList<>();
        initUserList();
        sc = new Scanner(System.in);
    }

    private void initUserList() throws FileNotFoundException {
        File file = new File("./user.csv"); // create File instance
        sc = new Scanner(file); // read file by Scanner

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(",");
            String username = line[0];
            String password = line[1];

            UserVO userVO = new UserVO(username,password);
            System.out.println(userVO);
            userList.add(userVO);
        }
        sc.close();

    }

    private void process() {

        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        System.out.println("                    Your Financial Ledger");
        System.out.println("1. sign up / 2. sign in / 3. exit");
        System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
        int option = sc.nextInt();

        if (option == 1){
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("                    Your Financial Ledger");
            System.out.println("Please register your account.");
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

            System.out.print("user name : ");
            String username = sc.next();
            System.out.print("user password : ");
            String password = sc.next();
            UserVO userVO = new UserVO(username, password);
            userList.add(userVO);
        }
        if (option == 2){
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");
            System.out.println("                    Your Financial Ledger");
            System.out.println("Please input your account.");
            System.out.println("⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤⏤");

            System.out.print("user name : ");
            String username = sc.next();
            System.out.print("user password : ");
            String password = sc.next();
            UserVO userVO = new UserVO(username, password);
            boolean isValidUser = checkLogin(userVO);
        }
        if (option == 3){
            Main.isExit = true;
        }


        sc.close();
    }

    private boolean checkLogin(UserVO userVO) {
//        TODO: checking login process is to be implemented
        return false;
    }


}
