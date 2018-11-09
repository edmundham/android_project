package ca.bcit.android_project;

public class Crime {
    int id;
    int year;
    String reportedTime;
    String day;
    String category;
    String house;
    String street;
    String city;

    public Crime(int id, int year, String reportedTime, String day, String category, String house, String street, String city) {
        this.id = id;
        this.year = year;
        this.reportedTime = reportedTime;
        this.day = day;
        this.category = category;
        this.house = house;
        this.street = street;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getReportedTime() {
        return reportedTime;
    }

    public String getDay() {
        return day;
    }

    public String getCategory() {
        return category;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getAddress(){

    }
}
