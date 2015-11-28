package com.example.hgx95.hci_project;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.hgx95.hci_project.util.CheckBackground;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/// @author HoracioGarza


public class MainActivity extends Activity implements CheckBackground {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Calendar calendar = Calendar.getInstance();


        Typeface fontello_icon_font= Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");

        Typeface fontello2_icon_font = Typeface.createFromAsset(getAssets(), "fonts/fontello2.ttf");


        TextClock main_clock = (TextClock) findViewById(R.id.mainActivityClock);
        TextView date = (TextView) findViewById(R.id.date);
        TextView stopwatch_e = (TextView)findViewById(R.id.stopwatch);
        TextView timer_e = (TextView) findViewById(R.id.timer);
        TextView calendar_e = (TextView) findViewById(R.id.calendarText);
        TextView world_e = (TextView) findViewById(R.id.world_clock);

        stopwatch_e.setOnClickListener(stopwatch);
        timer_e.setOnClickListener(timer);
        calendar_e.setOnClickListener(calendar2);
        world_e.setOnClickListener(world);

        //Setting
        stopwatch_e.setTypeface(fontello_icon_font);
        calendar_e.setTypeface(fontello2_icon_font);
        timer_e.setTypeface(fontello2_icon_font);
        world_e.setTypeface(fontello_icon_font);



        date.setTypeface(roboto_thin);
        main_clock.setTypeface(roboto_thin);






        date.setText(getTodaysDate(calendar.get(Calendar.DAY_OF_WEEK), calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));

        checkHour();



    }



    View.OnClickListener world = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MainActivity.this.startActivity(new Intent(MainActivity.this, worldClockMap.class));
        }
    };
    View.OnClickListener stopwatch = new View.OnClickListener() {
        public void onClick(View v) {

         MainActivity.this.startActivity(new Intent(MainActivity.this, Stopwatch.class));

        }
    };

    View.OnClickListener timer = new View.OnClickListener() {
        public void onClick(View v) {

            MainActivity.this.startActivity(new Intent(MainActivity.this, Set.class));
        }
    };

    View.OnClickListener calendar2 = new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this , Prueba.class);
            startActivity(intent);

        }
    };





    /***
     * It returns the day of the week, the day of the Month, the month and the year as strings and it returns a complete date<br>
     * for example  Monday January 11, 2015
     * @param dayOfWeek
     * @param dayOfMonth
     * @param month
     * @param year
     * @return date
     */
    String getTodaysDate(int dayOfWeek, int dayOfMonth, int month, int year) {

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

    @Override
    public void checkHour() {


            ImageView background = (ImageView) findViewById(R.id.imageView) ;
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(Calendar.HOUR_OF_DAY) < 11 && calendar.get(Calendar.HOUR_OF_DAY) > 5){

                background.setImageResource(R.drawable.mad);
            }else {

                if (calendar.get(Calendar.HOUR_OF_DAY) < 17 && calendar.get(Calendar.HOUR_OF_DAY) > 12) {
                    background.setImageResource(R.drawable.day);
                } else {
                    if (calendar.get(Calendar.HOUR_OF_DAY) > 17 && calendar.get(Calendar.HOUR_OF_DAY) < 6) {
                        background.setImageResource(R.drawable.afternoon);


                        }else{
                            background.setImageResource(R.drawable.night);
                            TextView date = (TextView) findViewById(R.id.date);
                            TextClock main_clock = (TextClock) findViewById(R.id.mainActivityClock);
                            main_clock.setTextColor(getResources().getColor(R.color.white));
                            date.setTextColor(getResources().getColor(R.color.white));


                   }
               }
            }

    }
}
