package com.example.breathing_book;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        BarChart barChart = findViewById(R.id.barchart);
        ArrayList<BarEntry> xAxisLabel = new ArrayList<>();
        //days vs minutes
        xAxisLabel.add(new BarEntry(1,45));
        xAxisLabel.add(new BarEntry(2,55));
        xAxisLabel.add(new BarEntry(3,155));
        xAxisLabel.add(new BarEntry(4,155));
        xAxisLabel.add(new BarEntry(5,100));
        xAxisLabel.add(new BarEntry(6,30));
        xAxisLabel.add(new BarEntry(7,20));

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



