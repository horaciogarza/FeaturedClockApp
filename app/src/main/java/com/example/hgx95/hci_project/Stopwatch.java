package com.example.hgx95.hci_project;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


/**
 * This Class represents the Stopwatch activity
 * @author horacio_garza
 *
 */
public class Stopwatch extends Activity{

    TextView mChronometer;
    int hour=0, minutes=0, seconds=0;
    boolean checkIt = true;
    int maxTime = 200000;
    boolean clicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        Typeface fontello_icon_font= Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");


        mChronometer = (TextView) findViewById(R.id.chronometer);
        mChronometer.setTypeface(roboto_thin);

        TextView start_ch, pause_ch, reset_ch;

        // Watch for button clicks.
        start_ch = (TextView) findViewById(R.id.start);

        start_ch.setTypeface(fontello_icon_font);

        pause_ch = (TextView) findViewById(R.id.pause);
        pause_ch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                checkIt = false;
            }
        });
        pause_ch.setTypeface(fontello_icon_font);

        reset_ch = (TextView) findViewById(R.id.reset);
        reset_ch.setTypeface(fontello_icon_font);
        reset_ch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                hour=0;
                minutes=0;
                seconds=0;
                checkIt = false;
                mChronometer.setText(hour + ":" + minutes + ":" + seconds);
            }
        });

        start_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIt = true;
                maxTime = 200000;
                final CountDownTimer start = new CountDownTimer(maxTime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        if (!clicked){


                            if (checkIt ==  true) {

                                if (seconds == 59) {
                                    if (minutes == 59) {

                                        hour++;
                                        seconds = 0;
                                        minutes = 0;

                                    } else {
                                        minutes++;
                                        seconds = 0;
                                    }
                                } else {
                                    seconds++;
                                }
                                mChronometer.setText(hour + ":" + minutes + ":" + seconds);
                            }
                            else
                            {
                                this.cancel();
                            }
                        }
                    }

                    public void onFinish() {
                        // mTextField.setText("done!");
                    }
                }.start();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stopwatch, menu);
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
