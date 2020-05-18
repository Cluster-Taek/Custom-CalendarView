package com.cookandroid.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCalendarView materialCalendarView;
        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.addDecorators(
                new SaturdayDecorator(),
                new SundayDecorator(),
                new MySelectorDecorator(this)
        );
    }


}

class MySelectorDecorator implements  DayViewDecorator {
    private final Drawable drawable;

    MySelectorDecorator(Activity context) {
        drawable = context.getResources().getDrawable(R.drawable.my_selector);
    }


    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }
}

//토요일 색깔 설정
class SaturdayDecorator implements DayViewDecorator {
    private final Calendar calendar = Calendar.getInstance();

    public SaturdayDecorator() {}

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return  weekDay == Calendar.SATURDAY;
    }

    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.BLUE));
    }
}
//일요일 색깔 설정
class SundayDecorator implements DayViewDecorator {
    private final Calendar calendar = Calendar.getInstance();

    public SundayDecorator() {}

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return  weekDay == Calendar.SUNDAY;
    }

    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.RED));
    }
}