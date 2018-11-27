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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.bcit.android_project.model.Crime;

public class FilterService {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private List<Crime> crimes;

    public FilterService(Context context) {
        crimes = CsvProcess.convertCsvToListOfCrimes(context);
    }

    public List<Crime> search(String input) {
        List<Crime> temp = new ArrayList<>();

        List<Crime> searchedList = crimesGetByOffence(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        searchedList = crimesGetByYear(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        searchedList = crimesGetByCity(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        searchedList = crimesGetByWeekDay(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        searchedList = crimesGetByStreetName(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        searchedList = crimesGetByMonth(input);
        if (!searchedList.isEmpty()) {
            temp.addAll(searchedList);
            return temp;
        }

        return temp;
    }

    public List<Crime> crimesFilterByDateTime() {
        Collections.sort(crimes, new DateComparator());
        return crimes;
    }

    public List<Crime> crimesGetByYear(String year) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getOccuranceYear().equals(year)) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesFilterByWeekDay() {
        Collections.sort(crimes, new WeekDayComparator());
        return crimes;
    }

    public List<Crime> crimesGetByWeekDay(String weekDay) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getReportedWeekday().toLowerCase().contains(weekDay.toLowerCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByMonth(String month) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getMonth().toLowerCase().contains(month.toLowerCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByOffence(String offence) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getOffense().contains(offence.toUpperCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByOffenceCategory(String offenceCategory) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getOffenseCategory().contains(offenceCategory.toUpperCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByStreetName(String streetName) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getStreetName().contains(streetName.toUpperCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
    }

    public List<Crime> crimesGetByCity(String city) {
        List<Crime> tempList = new ArrayList<>();
        for (Crime crime : crimes) {
            if (crime.getCity().contains(city.toUpperCase())) {
                tempList.add(crime);
            }
        }
        return tempList;
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