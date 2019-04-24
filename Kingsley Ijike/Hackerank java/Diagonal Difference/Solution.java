import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int downSum, upSum;

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        downSum = upSum = 0;
        for (int i=1; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i==j) {
                    downSum += arr[i][j];
                }
                if (i+j==arr.length-1) {
                    upSum += arr[i][j];
                }
            }
        }
        int difference = downSum-upSum;
        if (difference<0 ) {
            difference *= -1; 
        }
        System.out.println(difference);
        return difference;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
