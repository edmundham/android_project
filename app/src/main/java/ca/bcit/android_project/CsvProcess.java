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
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvProcess {
    public double userLat;
    public double userLong;
    public static final String csvFileSuggestedAddress = "../res/raw/data.csv";

    public CsvProcess() {

    }

    public final static ArrayList<Crime> convertCsvToListOfCrimes(Context context) {
        Reader in;
        ArrayList<Crime> crimes = new ArrayList<>();
        try {

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



}