import java.util.Scanner;

public class BOJ_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        // split string by space
        String[] strArr = str.split(" ");

        for (String s : strArr) {
            System.out.println(s);
        }
        System.out.println(strArr.length);
    }
}
