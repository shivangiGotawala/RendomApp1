package com.rendomapp.rendomapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MyChartActivity extends AppCompatActivity {

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_chart);

        lineChart = findViewById(R.id.chart);

        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setMaxHighlightDistance(150);
        lineChart.setViewPortOffsets(20, 10, 20, 10);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);

        customizeXAxis(lineChart);
        customizeYAxis(lineChart);
        drawChart();

    }
    private void customizeXAxis(LineChart mChart) {
        final String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; // Your List / array with String Values For X-axis Labels

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.DKGRAY);
        xAxis.setTextSize(5f);
//        xAxis.setLabelRotationAngle(45);
        xAxis.setLabelRotationAngle(-45);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(10);

//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
////        xAxis.setDrawGridLines(true);
//        xAxis.setGranularity(1f);
//        xAxis.setGranularityEnabled(true);
//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return weekdays[(int) value-1]; // xVal is a string array
//            }
//
//        });

//        final ArrayList<String> xAxes = new ArrayList<>();
//        for (int i=0; i < 7; i++) {
//            xAxes.add(i, weekdays[i]); //Dynamic x-axis labels
//        }

//        lineChart.getAxisLeft().setValueFormatter(new IndexAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                int index = Math.round(value);
//                Log.e("value",""+index);
////                return xAxes.get((int) value-1);
//                return String.format("%.2f $",value);
//            }
//        });

//        lineChart.getAxisLeft().setValueFormatter(new IndexAxisValueFormatter(weekdays));
    }

    private void customizeYAxis(LineChart mChart) {
        mChart.getAxisRight().setEnabled(false);
        YAxis yAxis = mChart.getAxisLeft();
        yAxis.setTextColor(Color.BLACK);
        // set y axis max to 101 instead of 100 so the full line width is displayed
        yAxis.setAxisMaximum(101);
        yAxis.setAxisMinimum(0);
        yAxis.setDrawAxisLine(true);
        yAxis.setDrawGridLines(false);
    }

    public void drawChart(){
        LineData lineData = new LineData();
        ArrayList<Entry> entryArrayList = new ArrayList<>();
        Set<Integer> generated = new LinkedHashSet<Integer>();
        Random random = new Random();
        while (generated.size() < 30) {
            generated.add(random.nextInt(30));
        }
        List<Integer> list = new ArrayList<Integer>(generated);
        Log.e("list", "" + list.size());

        for (int i = 0; i < 30; i++) {
            entryArrayList.add(new Entry(i, list.get(i)));
        }


        LineDataSet lineDataSet = new LineDataSet(entryArrayList, "This is y bill");
        lineData.addDataSet(lineDataSet);

        lineDataSet.setLineWidth(3f);
        lineDataSet.setColor(Color.YELLOW);
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setHighLightColor(Color.RED);
//        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawValues(true);
        lineDataSet.setCircleRadius(10f);
        lineDataSet.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.YELLOW);
        //set the transparency
        lineDataSet.setFillAlpha(80);

        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        //to remove the cricle from the graph
        lineDataSet.setDrawCircles(false);

        lineChart.setData(lineData);
        lineChart.invalidate();

    }
}
