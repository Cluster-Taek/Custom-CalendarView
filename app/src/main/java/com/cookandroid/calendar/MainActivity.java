package com.cookandroid.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    static int a = 17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCalendarView materialCalendarView;
        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.addDecorators(
                new SaturdayDecorator(),
                new SundayDecorator(),
                new MyAmountDecorator0(this),
                new MyAmountDecorator1(this),
                new MyAmountDecorator2(this),
                new MyAmountDecorator3(this),
                new MyAmountDecorator4(this)
        );
    }


}


//a에 따라 색깔 변화 0
class MyAmountDecorator0 implements DayViewDecorator {
    private final Drawable drawable;
    private final Calendar calendar = Calendar.getInstance();

    MyAmountDecorator0(Activity context) {
        drawable = context.getResources().getDrawable(R.color.colorAmount0);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return  MainActivity.a == 0;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}

//a에 따라 색깔 변화 1
class MyAmountDecorator1 implements DayViewDecorator {
    private final Drawable drawable;
    private final Calendar calendar = Calendar.getInstance();

    MyAmountDecorator1(Activity context) {
            drawable = context.getResources().getDrawable(R.color.colorAmount1);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return  MainActivity.a > 0 && MainActivity.a <= 25;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}

//a에 따라 색깔 변화 2
class MyAmountDecorator2 implements DayViewDecorator {
    private final Drawable drawable;
    private final Calendar calendar = Calendar.getInstance();

    MyAmountDecorator2(Activity context) {
        drawable = context.getResources().getDrawable(R.color.colorAmount2);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return  MainActivity.a > 25 && MainActivity.a <= 50;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}

//a에 따라 색깔 변화 3
class MyAmountDecorator3 implements DayViewDecorator {
    private final Drawable drawable;
    private final Calendar calendar = Calendar.getInstance();

    MyAmountDecorator3(Activity context) {
        drawable = context.getResources().getDrawable(R.color.colorAmount3);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return  MainActivity.a > 50 && MainActivity.a <= 75;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}

//a에 따라 색깔 변화 4
class MyAmountDecorator4 implements DayViewDecorator {
    private final Drawable drawable;
    private final Calendar calendar = Calendar.getInstance();

    MyAmountDecorator4(Activity context) {
        drawable = context.getResources().getDrawable(R.color.colorAmount4);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return  MainActivity.a > 75 && MainActivity.a <= 100;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
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