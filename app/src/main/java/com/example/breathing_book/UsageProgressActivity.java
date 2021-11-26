package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class UsageProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_progress);

        BarChart barChart = findViewById(R.id.usage);
        ArrayList<BarEntry> xAxisLabel = new ArrayList<>();
        //days vs minutes
        xAxisLabel.add(new BarEntry(1,60));
        xAxisLabel.add(new BarEntry(2,55));
        xAxisLabel.add(new BarEntry(3,95));
        xAxisLabel.add(new BarEntry(4,87));
        xAxisLabel.add(new BarEntry(5,75));
        xAxisLabel.add(new BarEntry(6,120));
        xAxisLabel.add(new BarEntry(7,100));

        BarDataSet barDataSet = new BarDataSet(xAxisLabel,"Usage");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData bardata = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(bardata);
        barChart.animateY(2000);
    }
}