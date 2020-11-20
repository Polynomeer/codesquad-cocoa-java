package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        double positives = 0;   // proportion of positive values
        double negatives = 0;  // proportion of negative values
        double zeros = 0; // proportion of zeros

        for (int num : arr) {
            if (num > 0) positives++;
            else if (num < 0) negatives++;
            else zeros++;
        }

        positives /= arr.length;
        negatives /= arr.length;
        zeros /= arr.length;

        System.out.println(String.format("%.6f", positives));
        System.out.println(String.format("%.6f", negatives));
        System.out.println(String.format("%.6f", zeros));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
