package com.example.hgx95.hci_project;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by hgx95 on 23/11/2015.
 */
public class City {

    private int different_time;
    private String message;
    private String name;
    private double coordx, coordy;
    private String timeZoneString;
    Calendar calendar = new GregorianCalendar();
    TimeZone timeZone = calendar.getTimeZone();

    public City(){

        this.different_time = 0;
        this.message = "";
        this.name = "";
    }

    public double getCoordx() {
        return coordx;
    }

    public double getCoordy() {
        return coordy;
    }

    public City(String timeZoneString, String name, double coordx, double coordy) {
        this.name = name;
        this.coordx = coordx;
        this.coordy = coordy;

       timeZone = TimeZone.getTimeZone(timeZoneString);

    }

    public int getDifferent_time() {
        return different_time;
    }

    public void setDifferent_time(int different_time) {
        this.different_time = different_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeZone(){

        calendar.setTimeZone(timeZone);
        return this.name + ": " + getTodaysDate(calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)) + "\n"+
                calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
    }

    private String getTodaysDate(int dayOfWeek, int dayOfMonth, int month, int year) {


            String date="";

            switch(dayOfWeek){



                case 1: date += "Sunday,";
                    break;

                case 2: date += "Monday,";
                    break;

                case 3: date += "Tuesday,";
                    break;

                case 4: date += "Wednesday,";
                    break;

                case 5: date += "Thursday,";
                    break;

                case 6: date += "Friday,";
                    break;

                case 7: date += "Saturday";
                    break;



                default: date="ERROR";
                    break;
            }

            switch (month){

                case 0: date += " January";
                    break;
                case 1: date += " February";
                    break;
                case 2: date += " March";
                    break;
                case 3: date += " April";
                    break;
                case 4: date += " May";
                    break;
                case 5: date += " June";
                    break;
                case 6: date += " July";
                    break;
                case 7: date += " August";
                    break;
                case 8: date += " September";
                    break;
                case 9: date += " October";
                    break;
                case 10: date += " November";
                    break;
                case 11: date += " December";
                    break;

                default: date += " Erruary";
            }


            date += " " + dayOfMonth;

            if(dayOfMonth == 1 || dayOfMonth == 21 || dayOfMonth == 31){
                date += "st";
            }
            else{
                if(dayOfMonth == 2 || dayOfMonth == 22){
                    date += "nd";
                }
                else{
                    if (dayOfMonth == 3 || dayOfMonth == 23){
                        date += "rd";
                    }
                    else{
                        date += "th";
                    }
                }
            }


            date += " " + year;



            return date;

    }
}
