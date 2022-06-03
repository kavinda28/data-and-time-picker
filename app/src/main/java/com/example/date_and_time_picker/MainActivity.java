package com.example.date_and_time_picker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText dates,time,dateandtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dates=findViewById(R.id.editText);
        time=findViewById(R.id.editText3);
        dateandtime=findViewById(R.id.editText4);


        dates.setInputType(InputType.TYPE_NULL);
  dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(dates);
            }
        });


       time.setInputType(InputType.TYPE_NULL);

time.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        showTimeDialog(time);
    }
});


        dateandtime.setInputType(InputType.TYPE_NULL);
dateandtime.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        showDateandTime(dateandtime);
    }
});
    }




    //date
    private void showDateDialog(EditText dates) {
       final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
                dates.setText(simpleDateFormat.format(calendar.getTime()));


            }
        };
        new  DatePickerDialog(MainActivity.this,dateSetListener,calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH)).show();
    }

//time
    private void showTimeDialog(EditText time) {
        Calendar calendar=Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
      calendar.set(Calendar.HOUR_OF_DAY,i);
      calendar.set(Calendar.MONTH,i1);
      SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
      time.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new TimePickerDialog(MainActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

    }

//date and time
    private void showDateandTime(EditText dateandtime) {
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.set(Calendar.HOUR_OF_DAY,i);
                        calendar.set(Calendar.MONTH,i1);
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        dateandtime.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(MainActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

            }
        };
        new  DatePickerDialog(MainActivity.this,dateSetListener,calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH)).show();


    }

}
