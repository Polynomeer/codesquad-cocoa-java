//3,6,9 게임을 만들어야 합니다.
//input 으로 integer type 의 숫자가 주어지며, 3,6,9 숫자의 개수만큼 "짝"을 출력하세요.
//단, input 값을 String 으로 변환 할 수 없습니다.

import java.util.Scanner;

public class ThreeSixNine {
//
//    public static int checkNum(int input){
//        int even = 0;
//        while(true){
//            if(input == 0) break;
//            int rest = input % 10;
//            if(rest == 3 || rest == 6 || rest == 9) even++;
//            input /= 10;
//        }
//        return even;
//    }

    public static int checkNum(int even, int input){
        if(input == 0) return even;
        int rest = input % 10;
        if(rest == 3 || rest == 6 || rest == 9) even++;
        input /= 10;
        return checkNum(even,input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int numOfEven = checkNum(0, input);
        System.out.println(numOfEven);
        for (int i=0;i<numOfEven;i++){
            System.out.print("짝");
        }
        System.out.println();
    }
}
