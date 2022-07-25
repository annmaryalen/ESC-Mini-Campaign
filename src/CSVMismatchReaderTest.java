import static com.example.helloworld.CSVMismatchReader.compare_csv;
import static org.junit.Assert.assertEquals;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class CSVMismatchReaderTest{

    // Unit Testing
    @Test
    //Test1 to check if current output is returned if both files are empty
    public void test1() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/test1_file1.csv"));
        Scanner csv2 = new Scanner(new File("./src/test1_file2.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test1_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }
    @Test
    //Test2 to check if current output is returned if the first file is empty but second file is not empty
    public void test2() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/test2,3_file1.csv"));
        Scanner csv2 = new Scanner(new File("./src/test2,3_file2.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test2,3_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }

    @Test
    //Test3 to check if current output is returned if the first file is not empty but second file is empty
    public void test3() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/test2,3_file2.csv"));
        Scanner csv2 = new Scanner(new File("./src/test2,3_file1.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test2,3_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }

    @Test
    //Test 4 to check if correct output is returned if both files are identical
    public void test4() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/test4_file1.csv"));
        Scanner csv2 = new Scanner(new File("./src/test4_file2.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test4_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),true);
    }

    // System Testing
    @Test
    // Equipartition Class 1: Valid path names given as inputs for the CSV files in scanner class
    // MIDDLE VALUE: The middle value is the shortened path of csv file which is truncated and starts with ./ to allow the file to be read.
    //Test 5 to check if correct output is returned if files contain mismatching records when middle value is given as input
    public void test5() throws IOException{
        Scanner csv1 = new Scanner(new File("./src/sample_file_1.csv"));
        Scanner csv2 = new Scanner(new File("./src/sample_file_3.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test5,6,7,8_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),false);
    }

    @Test
    // Equipartition Class 1: Valid path names given as inputs for the CSV files in scanner class
    // BOUNDARY VALUE: The boundary value is the maximum length of the path of the csv file and the actual full path of the csv file.
    // Test 6 to check if correct output is returned if boundary value condition is given as input
    public void test6() throws IOException{
        Scanner csv1 = new Scanner(new File("C:\\Users\\annma\\OneDrive\\Documents\\Ann SUTD Files\\Term 5\\ESC\\HelloWorld\\HelloWorld\\src\\sample_file_1.csv"));
        Scanner csv2 = new Scanner(new File("C:\\Users\\annma\\OneDrive\\Documents\\Ann SUTD Files\\Term 5\\ESC\\HelloWorld\\HelloWorld\\src\\sample_file_3.csv"));
        compare_csv(csv1, csv2);

        File file1 = new File("./src/result.csv");
        File file2 = new File("./src/test5,6,7,8_result.csv");
        assertEquals(FileUtils.contentEquals(file1, file2),false);
    }

    @Test
    // Equipartition Class 2: Invalid path names given as inputs for the CSV files in scanner class
    // MIDDLE VALUE: The middle value contains the wrong path with the wrong directory ‘.idea’ but still in the format of the path: ./.idea/sample_file_1.csv.
    // Test 7 to check if correct output is returned if files contain mismatching records when middle value is given as input
    public void test7() throws IOException{
        try {
            Scanner csv1 = new Scanner(new File("./.idea/sample_file_1.csv"));
            Scanner csv2 = new Scanner(new File("./.idea/sample_file_3.csv"));
            compare_csv(csv1, csv2);

            File file1 = new File("./src/result.csv");
            File file2 = new File("./src/test5,6,7,8_result.csv");
            assertEquals(FileUtils.contentEquals(file1, file2),false);

        }catch(FileNotFoundException e){
            System.out.println("Given input pathname is invalid: Wrong Directory");
        }
    }

    @Test
    // Equipartition Class 2: Invalid path names given as inputs for the CSV files in scanner class
    // BOUNDARY VALUE: The boundary value is which is the name of csv file sample_file_1.csv which is not even in the format of the path and the scanner class cannot accept the name of csv file
    // Test 8 to check if correct output is returned if boundary value condition is given as input
    public void test8() throws IOException{
        try {
            Scanner csv1 = new Scanner(new File("sample_file_1.csv"));
            Scanner csv2 = new Scanner(new File("sample_file_3.csv"));
            compare_csv(csv1, csv2);

            File file1 = new File("./src/result.csv");
            File file2 = new File("./src/test5,6,7,8_result.csv");
            assertEquals(FileUtils.contentEquals(file1, file2),false);

        }catch(FileNotFoundException e){
            System.out.println("Given input pathname is invalid: Incomplete pathname");
        }
    }

    @Test
    public void main() throws IOException {

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
}