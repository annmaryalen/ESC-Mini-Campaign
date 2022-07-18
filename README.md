## ESC-Mini-Campaign

CSVReader is a software program that reads two CSV files (that stores a list of records like records of bank accounts etc.), compares the records stored in these CSV files row by row against a unique combination and records all mismatches as exceptions. Finally, the CSVReader program generates another csv file called output_file that contains a list of all the exceptions.

For example, given customer files that contain customer id, customer account number, currency, account type (e.g., savings/current) and available balance, CSVReader can be used to compare available balance against a unique combination of customer id, customer account number, account type and currency and generate a CSV file with records from both the files corresponding to the mismatched amount (i.e., balance) for the unique combination.

<h4><i>To run the following CSVReader program:<i></h4>

<ol>
<li> Add your necessary CSV files containing records to be compared in the csv_files folder. </li>
<li> Modify pathname of your CSV files in lines 13 and 15 in CSVMismatchReader.java </li>
<li> Run CSVReader.java and view results in output_file.csv </li>
</ol>
