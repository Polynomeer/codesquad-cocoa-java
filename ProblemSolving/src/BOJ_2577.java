import java.util.Scanner;

public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        int result = a * b * c;
        int[] count = new int[10];
        String resultStr = Integer.toString(result);

        for (int i = 0; i < resultStr.length(); i++) {
            int index = (int)resultStr.charAt(i) - ('0' - 0);
            count[index]++;
        }
        for (int i=0;i<10;i++){
            System.out.println(count[i]);
        }

    }
}
