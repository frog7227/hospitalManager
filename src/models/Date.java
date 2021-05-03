package models;
import java.io.Serializable;


/**
 * 4/18/2021
 * This method will model the date and time so I schedule of events can be kept
 *
 * @author Cameron Hoss
 */
public class Date implements Serializable {
    /**
    Instance Variables
    */
    private int hour;
    private int min;
    private int month;
    private int day;
    private int year;


    /**
     * no args constructor for date
     */
    public Date() {
        hour = 0;
        min = 0;
        month = 0;
        day = 0;
        year = 0;
    }

    /**
     * constructor for date
     * @param hour of the time
     * @param min of the time
     */
    public Date(int hour, int min) {
        this.hour = hour;
        this.min = min;
        month = 0;
        day = 0;
        year = 0;
    }

    /**
     * constructor for date
     * @param month of the date
     * @param day of the date
     * @param year of the date
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        hour = 0;
        min = 0;
    }

    /**
     * constructor for date
     * @param month of the date
     * @param day of the date
     * @param year of the date
     * @param hour of the time
     * @param min of the time
     */
    public Date(int month, int day, int year, int hour, int min) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }


    /**
     * getter
     * @return The date as a string
     */
    public String getDate() {
        return month + "/" + day + "/" + year;
    }

    /**
     * getter
     * @return The date as a string
     */
    @Override
    public String toString(){ return month + "/" + day + "/" + year; }

    /**
     *
     * @return the time
     */
    public String getTime() {
        return hour + ":" + min;

    }

    /**
     * compares two dates
     * @param date date to be compared to
     * @return the difference between the largest time intervals between the dates
     */
    public int compareTo(Date date){
        if(date.year != this.year) return date.year - this.year;
        else if (date.month != this.month) return date.month - this.month;
        else if (date.day != this.day) return date.day - this.day;
        else if (date.hour != this.hour) return date.hour - this.hour;
        else if (date.min != this.min) return date.min - this.min;
        else return 0;


    }

}