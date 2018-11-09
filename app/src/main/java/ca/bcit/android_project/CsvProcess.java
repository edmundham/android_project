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
//
//        System.out.println(System.getProperty("user.dir"));
//        BufferedReader br = null;
//        String line = "";
//        String cvsSplitBy = ",";
//
//        try {
//
//            br = new BufferedReader(new FileReader(csvFile));
//            while ((line = br.readLine()) != null) {
//
//                // use comma as separator
//               System.out.println(line + "\n\n\n\n" );
//
//
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
    public List read(){
        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
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

