package com.example.helloworld;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//Week 8 testing campaign
public class CSVMismatchReader {

    public static void compare_csv(Scanner csv1, Scanner csv2) throws IOException {

        // An ArrayList named compare contaning string is created
        ArrayList<String> compare = new ArrayList<String>();
        //The result is stored in compare.csv file in " " format
        String result = "";

        //use comma to slice the csv file
        csv1.useDelimiter(",");
        csv2.useDelimiter(",");

        while (csv1.hasNextLine() && csv2.hasNextLine()) {

            String first_line_csv1 = csv1.nextLine();

            String first_line_csv3= csv2.nextLine();

            if (!first_line_csv1.equals(first_line_csv3)) {

                compare.add(first_line_csv1);
                compare.add(first_line_csv3);
            }
        }

        csv1.close();
        csv2.close();

        // Write to the new File output_file.csv
        FileWriter file = new FileWriter("./src/result.csv");
        //iterate through the size of result_file.csv and add the lines to it
        try{
            for (int i = 0; i < compare.size(); i++) {
                result = result + compare.get(i) + "\n";
            }
            //get exception to prevent exceptions from occuring
        } catch (Exception ex) {
            System.out.println("cannot write to compare.csv file");
        }
        // write output to the new file result_file.csv
        file.write(result);
        //close output_file.csv file
        file.close();
    }
    public static void main(String[] args) throws Exception{
        // scanner is created for sample_file_1.csv
        Scanner csv1 = new Scanner(new File("./src/sample_file_1.csv"));
        // scanner is created for sample_file_3.csv
        Scanner csv2 = new Scanner(new File("./src/sample_file_3.csv"));
        compare_csv(csv1, csv2);
    }




}
