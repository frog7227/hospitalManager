/**
 * 4/18/2021
 * This method will model the date and time so I schedule of events can be kept
 *
 * @author Cameron Hoss
 */
public class Date {
    /**
    Instance Variables
    */
    private int hour;
    private int min;
    private int month;
    private int day;
    private int year;

    /**
     Contructors
    */
    public Date() {
        hour = 0;
        min = 0;
        month = 0;
        day = 0;
        year = 0;
    }

    public Date(int hour, int min) {
        this.hour = hour;
        this.min = min;
        month = 0;
        day = 0;
        year = 0;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        hour = 0;
        min = 0;
    }

    public Date(int month, int day, int year, int hour, int min) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }

    /**
    Getters
    */
    public String getDate() {
        return month + "/" + day + "/" + year;
    }

    public String getTime() {
        return hour + ":" + min;

    }
}