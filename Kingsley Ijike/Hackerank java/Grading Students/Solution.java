import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int [] finalGrade = new int[grades.length];
        int mod;
        for(int i=0; i<grades.length; i++) {
            mod = grades[i]%10;
            if(grades[i]<38) {
                finalGrade[i] = grades[i];
            }
            else if(mod<5 && 5-mod<3 && grades[i]>37) {
                finalGrade[i] = ((grades[i]/10)*10) + 5;
            }
            else if (mod>5 && 10-mod<3 && grades[i]>37) {
                finalGrade[i] = ((grades[i]/10)*10) + 10;
            }
            else finalGrade[i] = grades[i];
            
            System.out.println(grades[i]);
        }
        return finalGrade;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
