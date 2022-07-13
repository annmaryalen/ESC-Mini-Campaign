import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CSVReader {
    public static void main(String[] args) throws Exception {

        // An ArrayList named compare contaning string is created
        ArrayList<String> compare = new ArrayList<String>();
        //The result is stored in compare.csv file in " " format
        String output = "";
        // scanner is created for sample_file_1.csv
        Scanner csv1 = new Scanner(new File("./csv_files/sample_file_1.csv"));
        // scanner is created for sample_file_31.csv
        Scanner csv3 = new Scanner(new File("./csv_files/sample_file_3.csv"));
        //use comma to slice the csv file
        csv1.useDelimiter(",");
        csv3.useDelimiter(",");
        //check if sample_file_1.csv has the next line
        while (csv1.hasNextLine()) {
            //if sample_file_1.csv has next line, store next line of sample_file_1.csv in a String
            String first_line_csv1 = csv1.nextLine();
            //if sample_file_1.csv has next line,store next line of sample_file_2.csv in a String
            String Second_line_csv3= csv3.nextLine();
            //if both lines are not same
            if (!first_line_csv1.equals(Second_line_csv3)) {
                //add the first line of sample_file_1.csv in the output
                compare.add(first_line_csv1);
                //add the first line of sample_file_3.csv in the output
                compare.add(first_line_csv1);
            }
        }
        //close sample_file_1.csv and sample_file_3.csv
        csv1.close();
        csv3.close();

        // Write to the new File compare.csv
        FileWriter file = new FileWriter("./csv_files/output_file.csv");
        //iterate through the size of compare.csv and add the lines to it
        try{
            for (int i = 0; i < compare.size(); i++) {
                output = output + compare.get(i) + "\n";
            }
        //get exception to prevent exceptions from occuring
        } catch (Exception ex) {
            System.out.println("cannot write to compare.csv file");
        }
        // write output to the new file compare.csv
        file.write(output);
        //close compare.csv file
        file.close();
    }
}