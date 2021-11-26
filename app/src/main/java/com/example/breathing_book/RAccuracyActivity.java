package com.example.breathing_book;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class RAccuracyActivity extends AppCompatActivity {

    LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raccuracy);


        lineChart = findViewById(R.id.Raccuracychart);
        LineDataSet lineDataSet = new LineDataSet(lineChartDataSet(),"data set");
        ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(lineDataSet);

        LineData lineData = new LineData(iLineDataSets);
        lineChart.setData(lineData);
        lineChart.invalidate();


        //if you want set background color use below method
        //lineChart.setBackgroundColor(Color.RED);

        // set text if data are are not available
        lineChart.setNoDataText("Data not Available");

        //you can modify your line chart graph according to your requirement there are lots of method available in this library

        //now customize line chart

        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setCircleColor(Color.RED);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setLineWidth(5);
        lineDataSet.setCircleRadius(10);
        lineDataSet.setCircleHoleRadius(10);
        lineDataSet.setValueTextSize(10);
        lineDataSet.setValueTextColor(Color.BLACK);



    }


    private ArrayList<Entry> lineChartDataSet(){
        ArrayList<Entry> dataSet = new ArrayList<Entry>();

        dataSet.add(new Entry(0,40));
        dataSet.add(new Entry(1,78));
        dataSet.add(new Entry(2,80));
        dataSet.add(new Entry(3,65));
        dataSet.add(new Entry(4,92));
        dataSet.add(new Entry(5,87));
        dataSet.add(new Entry(6,68));
        dataSet.add(new Entry(7,72));
        dataSet.add(new Entry(8,60));
        return  dataSet;
    }
}