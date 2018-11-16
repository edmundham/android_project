package ca.bcit.android_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvProcess {
    public double userLat;
    public double userLong;
    String csvFileSuggestedAddress = "./res/values/Property_Crimes.csv";

    public CsvProcess() {

    }

    public ArrayList<String[]> csvProcessing(String fileAddress) {
        ArrayList<String[]> stringlist = new ArrayList<String[]>();
        String csvFile = fileAddress;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        /**
         * Return ArrayList of String array.
         * use country[number] to refer to certain attribute inside the arraylist.
         * Number reference list
         * [0]X,
         * [1]Y,
         * [2]OBJECTID,
         * [3]FileNumber,
         * [4]OccuranceYear,
         * [5]ReportedDate,
         * [6]ReportedTime,
         * [7]ReportedWeekday,
         * [8]Offense,
         * [9]OffenseCategory,
         * [10]HouseNumber,
         * [11]StreetName,
         * [12]City,
         * [13]ReportedDateText,
         * [14]ReportedTimeText
         */
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                stringlist.add(country);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringlist;
    }

}
