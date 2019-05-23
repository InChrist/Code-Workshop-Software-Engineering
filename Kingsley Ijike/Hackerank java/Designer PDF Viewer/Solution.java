import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        
        //find the numerical value of each word
        char[] ch  = word.toCharArray();
        List<Integer> list = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        //Get alphabetical indeces of each character and put in an arraylist (list)
        for(char c : ch) {
            int temp = (int)c;
            int temp_integer = 96; //for lower case

            if(temp<=122 && temp>=97)
                list.add(temp-temp_integer); 
                //System.out.print(temp-temp_integer);
        }

        //Store the value of index in given array into another arraylist (valueList)
        for(int i:list) {
            valueList.add(h[i-1]);
        }

        //Get maximum value of the new arraylist
        int maxNumber = valueList.stream().max(Comparator.comparing(i -> i)).get();

        return maxNumber*word.length();


    //char[] charArray = IntStream.rangeClosed('a', 'z')
//        .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
