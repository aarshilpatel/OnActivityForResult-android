package com.example.aarshil.onactivityforresult;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class DatePickerTimePickerActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_date,btn_time;
    TextView tv_date,tv_time;
    int year,month,dayofmonth,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_time_picker);
        btn_date = (Button)findViewById(R.id.btn_date);
        tv_date = (TextView) findViewById(R.id.tv_date);

        btn_time = (Button)findViewById(R.id.btn_time);
        tv_time = (TextView)findViewById(R.id.tv_time);

        btn_date.setOnClickListener(this);
        btn_time.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayofmonth = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
           case R.id.btn_date:

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    tv_date.setText(dayofmonth + "-" + (month+1) +  "-"+ year);
                }
            },year,month,dayofmonth);

            datePickerDialog.show();
            break;

            case R.id.btn_time:

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        tv_time.setText(hour + ":" +minute);
                    }
                },hour,minute,false);

                timePickerDialog.show();
                break;


        }
    }
}
