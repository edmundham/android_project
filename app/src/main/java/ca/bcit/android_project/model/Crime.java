package ca.bcit.android_project.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Crime implements Serializable {
    private String x;
    private String y;
    private String objectId;
    private String fileNumber;
    private String occuranceYear;
    private String reportedDate;
    private String reportedTime;
    private String reportedWeekday;
    private String offense;
    private String offenseCategory;
    private String houseNumber;
    private String streetName;
    private String city;
    private String reportedDateText;
    private String reportedTimeText;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getOccuranceYear() {
        return occuranceYear;
    }

    public void setOccuranceYear(String occuranceYear) {
        this.occuranceYear = occuranceYear;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(String reportedTime) {
        this.reportedTime = reportedTime;
    }

    public String getReportedWeekday() {
        return reportedWeekday;
    }

    public void setReportedWeekday(String reportedWeekday) {
        this.reportedWeekday = reportedWeekday;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getOffenseCategory() {
        return offenseCategory;
    }

    public void setOffenseCategory(String offenseCategory) {
        this.offenseCategory = offenseCategory;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReportedDateText() {
        return reportedDateText;
    }

    public void setReportedDateText(String reportedDateText) {
        this.reportedDateText = reportedDateText;
    }

    public String getReportedTimeText() {
        return reportedTimeText;
    }

    public void setReportedTimeText(String reportedTimeText) {
        this.reportedTimeText = reportedTimeText;
    }

    public Crime(String x, String y, String objectId, String fileNumber,
                 String occuranceYear, String reportedDate, String reportedTime,
                 String reportedWeekday, String offense, String offenseCategory,
                 String houseNumber, String streetName, String city, String reportedDateText,
                 String reportedTimeText) {
        this.x = x;
        this.y = y;
        this.objectId = objectId;
        this.fileNumber = fileNumber;
        this.occuranceYear = occuranceYear;
        this.reportedDate = reportedDate;
        this.reportedTime = reportedTime;
        this.reportedWeekday = reportedWeekday;
        this.offense = offense;
        this.offenseCategory = offenseCategory;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.reportedDateText = reportedDateText;
        this.reportedTimeText = reportedTimeText;
    }


}
