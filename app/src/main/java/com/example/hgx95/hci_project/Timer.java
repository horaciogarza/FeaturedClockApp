package com.example.hgx95.hci_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Timer extends Activity {

    int hour=0, minutes=0, seconds=0;
    boolean checkIt = true;
    int maxTime = 200000;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        hour = getIntent().getExtras().getInt("hour");
        minutes = getIntent().getExtras().getInt("minutes");
        seconds = 0;


        final TextView chronometer = (TextView) findViewById(R.id.chronometer);

        Typeface fontello_icon_font= Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");
        Typeface roboto_thin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        TextView start_ch, pause_ch, reset_ch;

        // Buttons
        //Start
        start_ch = (TextView) findViewById(R.id.start);
        start_ch.setTypeface(fontello_icon_font);


        TextView set_ch = (TextView) findViewById(R.id.setTime);


        chronometer.setTypeface(roboto_thin);
        set_ch.setTypeface(fontello_icon_font);

        set_ch.setOnClickListener(set);
        chronometer.setText(hour + ":" + minutes + ":" + seconds);

        start_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIt = true;
                maxTime = 200000;
                final CountDownTimer start = new CountDownTimer(maxTime, 1000) {

                    public void onTick(long millisUntilFinished) {
                        if (!clicked){


                            if (checkIt ==  true) {

                                if (seconds == 0) {
                                    if (minutes == 0) {
                                        if (hour != 0) {
                                            hour--;
                                            minutes = 59;
                                            seconds = 0;

                                        } else {
                                            //FINISH
                                        }
                                    } else {
                                        minutes--;
                                        seconds = 59;
                                    }
                                } else {

                                    seconds--;
                                }
                                chronometer.setText(hour + ":" + minutes + ":" + seconds);
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
        //Pause
        pause_ch = (TextView) findViewById(R.id.pause);
        pause_ch.setTypeface(fontello_icon_font);
        pause_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIt = false;
            }
        });


    }



    View.OnClickListener set = new View.OnClickListener() {
        public void onClick(View v) {

            Timer.this.startActivity(new Intent(Timer.this, Set.class));

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timer, menu);
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
