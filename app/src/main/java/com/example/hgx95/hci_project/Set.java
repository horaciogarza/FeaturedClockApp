package com.example.hgx95.hci_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Set extends Activity {

    NumberPicker h, m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);


        Typeface fontello_icon_font= Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");

        final NumberPicker h = (NumberPicker) findViewById(R.id.h);
        final NumberPicker m = (NumberPicker) findViewById(R.id.m);

        int hour = 0;
        int minutes = 0;

        h.setMaxValue(24);
        h.setMinValue(0);
        m.setMaxValue(59);
        m.setMinValue(0);

        h.setWrapSelectorWheel(true);
        m.setWrapSelectorWheel(true);

       TextView submit = (TextView) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                Intent i = new Intent(Set.this, Timer.class);
                i.putExtra("hour", h.getValue());
                i.putExtra("minutes", m.getValue());

                startActivity(i);

            }
        });
        submit.setTypeface(fontello_icon_font);





    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set, menu);
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
