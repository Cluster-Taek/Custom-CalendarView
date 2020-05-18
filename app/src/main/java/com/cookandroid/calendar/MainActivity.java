package com.cookandroid.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    public void setCalendarList() {
        GregorianCalendar cal = new GregorianCalendar();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
