import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        
        int[] arr1 = new int[n];
        List<Integer> numberList = new ArrayList<>();
        //Purpose of the hashset is to avoid repeated values)
        Set<Integer> checkSet = new HashSet<>();
        int[] error = {-1};

        //List that will be iterated
        for(int i=1; i<=(n-k); i++) {
            numberList.add(i);
        }
        
        //Actual permutation and error control
        for(int i:numberList) {
            if(arr1[i-1]==0 && checkSet.add(k+i)) arr1[i-1]=k+i;
            if(arr1[k+i-1]==0 && checkSet.add(i)) arr1[k+i-1]=i;
        }
        
        checkSet.clear();

        for(int i:arr1){
            if(i==0) return error;
        }
        return arr1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
