package com.example.aarshil.onactivityforresult;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RatingbarSeekbar extends AppCompatActivity {

    RatingBar ratingBar;

    TextView tvrating,tvseekbar;

    SeekBar seekBar;

    Spinner spinner;

    String lang[] = {"Selected Language","Android","IOS","java","C","C++","Php",".net"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar_seekbar);

        ratingBar = (RatingBar)findViewById(R.id.ratingbar);
        tvrating = (TextView)findViewById(R.id.tv_rating);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        tvseekbar = (TextView)findViewById(R.id.tv_seekbar);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lang){

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

              TextView tv = (TextView)super.getDropDownView(position,convertView,parent);

              tv.setTextColor(Color.BLACK);

              if (position == 0){

                  tv.setTextColor(Color.GRAY);
              }


                return tv;
            }
        };
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String data = adapterView.getItemAtPosition(i).toString();

                if (i!=0)
                {
                    Toast.makeText(RatingbarSeekbar.this, "Item is " + data, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                tvrating.setText(String.valueOf(v));
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                tvseekbar.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

}
