package ca.bcit.android_project;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
<<<<<<< HEAD
import java.io.InputStream;
=======
>>>>>>> 963281a7bee174d7225053d9d538decadd04cf9b
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvProcess {
    public double userLat;
    public double userLong;
<<<<<<< HEAD
    String csvFile = "Property_Crimes.csv";
    InputStream input;
    public CsvProcess(InputStream file) {
        this.input = file;
=======
    public static final String csvFileSuggestedAddress = "../res/raw/data.csv";

    public CsvProcess() {
>>>>>>> 963281a7bee174d7225053d9d538decadd04cf9b

    }

    public final static ArrayList<Crime> convertCsvToListOfCrimes(Context context) {
        Reader in;
        ArrayList<Crime> crimes = new ArrayList<>();
        try {
<<<<<<< HEAD
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");

int id = row[2];
String ReportWeekDday =
                /**

                 * [2]OBJECTID,
=======

            final Reader reader = new InputStreamReader(context.getResources().openRawResource(R.raw.data));
            final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader("X", "Y",
                    "OBJECTID", "FileNumber", "OccuranceYear", "ReportedDate", "ReportedTime",
                    "ReportedWeekday", "Offense", "OffenseCategory", "HouseNumber", "StreetName",
                    "City", "ReportedDateText", "ReportedTimeText"));

            for (CSVRecord record : parser) {
                if (record.get("City").equalsIgnoreCase("City")) {
                    continue;
                }
                if (!record.get("OccuranceYear").equalsIgnoreCase("2018")) {
                    continue;
                }
                if (!record.get("ReportedWeekday").equalsIgnoreCase("Sunday")) {
                    continue;
                }
                crimes.add(new Crime(record.get("X"), record.get("Y"), record.get("OBJECTID"),
                        record.get("FileNumber"), record.get("OccuranceYear"), record.get("ReportedDate"),
                        record.get("ReportedTime"), record.get("ReportedWeekday"), record.get("Offense"),
                        record.get("OffenseCategory"), record.get("HouseNumber"), record.get("StreetName"),
                        record.get("City"), record.get("ReportedDateText"), record.get("ReportedTimeText")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crimes;
    }
>>>>>>> 963281a7bee174d7225053d9d538decadd04cf9b


                 * [7]ReportedTime,
                 * [8]ReportedWeekday,
                 * [9]Offense,
                 * [10]OffenseCategory,
                 * [11]HouseNumber,
                 * [12]StreetName,
                 * [13]City,

<<<<<<< HEAD
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
=======
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                stringlist.add(country);
>>>>>>> 963281a7bee174d7225053d9d538decadd04cf9b
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
<<<<<<< HEAD
        return resultList;
    }



=======
        return stringlist;
    }

>>>>>>> 963281a7bee174d7225053d9d538decadd04cf9b
}
