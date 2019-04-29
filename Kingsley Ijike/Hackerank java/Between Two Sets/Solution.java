import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for (int i=a[a.length -1]; i<=b[0]; i+= a[a.length -1]) {
            arr1.add(i);
        }

        int temp;
        for (Iterator<Integer> iterator = arr1.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            temp = 0;
            while (temp <a.length) {
                if (integer%a[temp]!=0) {
                    iterator.remove();
                    break;
                }
                temp++;
            }
        }

        for (Iterator<Integer> iterator = arr1.iterator(); iterator.hasNext();) {
            Integer integer = iterator.next();
            temp = 0;
            while (temp <b.length) {
                if (b[temp]%integer!=0) {
                    iterator.remove();
                    break;
                }
                temp++;
            }
        }
        return arr1.size();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
