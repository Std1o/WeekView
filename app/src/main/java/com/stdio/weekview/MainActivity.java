package com.stdio.weekview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements DatePickerListener {

    TextView tvDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = findViewById(R.id.tvDate);
        HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.datePicker);

        // initialize it and attach a listener
        picker
                .setDateSelectedColor(Color.BLACK)
                .setDays(20)
                .setListener(this)
                .init();
        picker.setDate(new DateTime());
    }

    @Override
    public void onDateSelected(@NonNull final DateTime dateSelected) {
        String dateStr = sdf.format(dateSelected.getMillis());
        tvDate.setText(dateStr);
        Toast.makeText(this, dateSelected.toString(), Toast.LENGTH_SHORT).show();
        // log it for demo
    }
}
