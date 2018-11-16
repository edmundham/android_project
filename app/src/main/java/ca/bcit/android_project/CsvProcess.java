package ca.bcit.android_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvProcess {

    public double userLat;
    public double userLong;
    String csvFile = "Property_Crimes.csv";
    InputStream input;
    public CsvProcess(InputStream file) {
        this.input = file;

    }
    public List read(){
        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");

int id = row[2];
String ReportWeekDday =
                /**

                 * [2]OBJECTID,


                 * [7]ReportedTime,
                 * [8]ReportedWeekday,
                 * [9]Offense,
                 * [10]OffenseCategory,
                 * [11]HouseNumber,
                 * [12]StreetName,
                 * [13]City,

                 */
                System.out.print(csvLine + "\n\n\n\n");
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                input.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }



}
