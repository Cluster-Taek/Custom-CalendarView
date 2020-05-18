package com.cookandroid.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


//https://namget.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BB%A4%EC%8A%A4%ED%85%80-%EB%8B%AC%EB%A0%A5-%EC%98%88%EC%A0%9C-Android-Custom-CalendarView-Example

public class MainActivity extends AppCompatActivity {

    MutableLiveData<ArrayList<Object>> mCalendarList= new MutableLiveData<>();

    public void setCalendarList() {
        GregorianCalendar cal = new GregorianCalendar();

        ArrayList<Object> calendarList = new ArrayList<>();

        for(int i = -300; i < 300; i++) {
            try {
                GregorianCalendar calendar = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + i, 1, 0, 0, 0);
                calendarList.add(calendar.getTimeInMillis());

                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                for (int j = 0; j < dayOfWeek; j++) {
                    calendar.add(Keys.EMPTY);
                }

                for (int j = 0; j <= max; j++) {
                    calendar.add(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), j));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mCalendarList.setValue(calendarList);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
