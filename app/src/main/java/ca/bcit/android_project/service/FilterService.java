package ca.bcit.android_project.service;

import android.annotation.SuppressLint;
import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ca.bcit.android_project.model.Crime;

public class FilterService {

    private static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private List<Crime> crimes;

    public FilterService(Context context) {
        crimes = CsvProcess.convertCsvToListOfCrimes(context);
    }

    public List<Crime> crimesFilterByDateTime() {
        Collections.sort(crimes, new DateComparator());
        return crimes;
    }

    public List<Crime> crimesGetByDateTime(Date date) {
        List<Crime> tempList = new ArrayList<>();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Date d1 = null;
        Date d2 = null;
        for (Crime crime : crimes) {
            try {
                d1 = format.parse(crime.getReportedDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (d1 != null && d1.compareTo(date) == 0) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByYear(int year) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getOccuranceYear().equals(Integer.toString(year))) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesFilterByWeekDay() {
        Collections.sort(crimes, new WeekDayComparator());
        return crimes;
    }

    private class DateComparator implements Comparator<Crime> {
        @Override
        public int compare(Crime c1, Crime c2) {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            Date d1 = null;
            Date d2 = null;
            try {
                d1 = format.parse(c1.getReportedTime());
                d2 = format.parse(c2.getReportedTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return d1.compareTo(d2);
        }
    }

    private class WeekDayComparator implements Comparator<Crime> {
        @Override
        public int compare(Crime c1, Crime c2) {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("EEEEE");
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            try {
                Date d1 = format.parse(c1.getReportedWeekday());
                Date d2 = format.parse(c2.getReportedWeekday());
                cal1.setTime(d1);
                cal2.setTime(d2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return cal1.get(Calendar.DAY_OF_WEEK) - cal2.get(Calendar.DAY_OF_WEEK);
        }
    }
}