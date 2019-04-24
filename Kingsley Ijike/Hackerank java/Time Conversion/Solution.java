import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        //String.format("%05d", yournumber)
        String convertedTime = "";
        int hh = Integer.parseInt(s.substring(0, 2));
        if (s.contains("PM")) {
            hh += 12;
            if (hh==24) {
                hh =12;
            }
        }
        else if (hh==12) {
            hh = 0;
        }
        convertedTime = String.format("%02d", hh) + s.substring(2, 8);
        return convertedTime;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
