package com.example.hgx95.hci_project;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.Calendar;

/// @author HoracioGarza


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * The <b>stopwatch</b> variable represents the button that sends you to the Stop Watch activity
         */
        TextView stopwatch=(TextView)findViewById(R.id.stopwatch);
        /**
         * The <b>timer</b> variable represents the button that sends you to the Timer activity
         */

        TextView timer = (TextView) findViewById(R.id.timer);

        /**
         * The <b>alarm</b> variable represents the button that sends you to the Alarm activity
         */
        TextView alarm = (TextView) findViewById(R.id.alarm);

        /**
         * The <b>worldclock</b> variable represents the button that sends you to the World Clock activity
         */
        TextView worldclock = (TextView) findViewById(R.id.worldClock);

        /**
         * The <b>fontello_icon_font</b> snd the <b>roboto</b>andvariable represents the custom font, customized in <i>fontello.com</i>
         */
        Typeface fontello_icon_font= Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        /**
         * The <b>date</b> variable represents the date TextView in the principal Activity (MainActivity)
         */
                TextView date = (TextView) findViewById(R.id.date);

        //Setting
        stopwatch.setTypeface(fontello_icon_font);
        alarm.setTypeface(fontello_icon_font);
        timer.setTypeface(fontello_icon_font);
        worldclock.setTypeface(fontello_icon_font);
        date.setTypeface(roboto_thin);



        Calendar calendar = Calendar.getInstance();

        date.setText(getTodaysDate(calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));







    }

    /***
     * It returns the day of the week, the day of the Month, the month and the year as strings and it returns a complete date<br>
     * for example  Monday January 11, 2015
     * @param dayOfWeek
     * @param dayOfMonth
     * @param month
     * @param year
     * @return date
     */
    private String getTodaysDate(int dayOfWeek, int dayOfMonth, int month, int year) {

        String date="";

        switch(dayOfWeek){



            case 1: date += "Sunday";
                break;

            case 2: date += "Monday";
                    break;

            case 3: date += "Tuesday";
                break;

            case 4: date += "Wednesday";
                break;

            case 5: date += "Thursday";
                break;

            case 6: date += "Friday";
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
