package com.rendomapp.rendomapp;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LineChartActivity extends AppCompatActivity {
    LineChart lineChart;
    Button btnAll, btnForhead, btnCheek, btnChin, btnNose;
    String days[] = {"Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        lineChart = findViewById(R.id.chart);
        btnAll = findViewById(R.id.all);
        btnForhead = findViewById(R.id.forhead);
        btnCheek = findViewById(R.id.cheek);
        btnChin = findViewById(R.id.chin);
        btnNose = findViewById(R.id.nose);

        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setMaxHighlightDistance(150);

        lineChart.setViewPortOffsets(0, 0, 0, 0);
//        for remove square checks in background from graph
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
//        lineChart.getDescription().setEnabled(false);
        customizeXAxis(lineChart);
        customizeYAxis(lineChart);
        lineChartDownFillWithData();

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineChartDownFillWithData();
            }
        });

        btnForhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewForheadChart();
            }
        });

        btnCheek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCheekChart();
            }
        });
    }

    private void lineChartDownFillWithData() {

//        Description description = new Description();
//        description.setText("Days Data");
//
//        lineChart.setDescription(description);

        LineData lineData = new LineData();

        ArrayList<Entry> entryArrayList = new ArrayList<>();
//        entryArrayList.add(new Entry(0, 60f, "1"));
//        entryArrayList.add(new Entry(1, 55f, "2"));
//        entryArrayList.add(new Entry(2, 60f, "3"));
//        entryArrayList.add(new Entry(3, 40f, "4"));
//        entryArrayList.add(new Entry(4, 45f, "5"));
//        entryArrayList.add(new Entry(5, 36f, "6"));
//        entryArrayList.add(new Entry(6, 30f, "7"));
//        entryArrayList.add(new Entry(7, 40f, "8"));
//        entryArrayList.add(new Entry(8, 45f, "9"));
//        entryArrayList.add(new Entry(9, 60f, "10"));
//        entryArrayList.add(new Entry(10, 45f, "10"));
//        entryArrayList.add(new Entry(11, 20f, "10"));

        entryArrayList.add(new Entry(0, 20f));
        entryArrayList.add(new Entry(1, 50f));
        entryArrayList.add(new Entry(2, 10f));
        entryArrayList.add(new Entry(3, 30f));
        entryArrayList.add(new Entry(4, 15f));
        entryArrayList.add(new Entry(5, 35f));

        ArrayList<Entry> entryArrayList2 = new ArrayList<>();
        entryArrayList2.add(new Entry(0, 50f, "1"));
        entryArrayList2.add(new Entry(1, 10f, "2"));
        entryArrayList2.add(new Entry(2, 20f, "3"));
        entryArrayList2.add(new Entry(3, 25f, "4"));
        entryArrayList2.add(new Entry(4, 15f, "5"));
        entryArrayList2.add(new Entry(5, 40f, "6"));

        ArrayList<Entry> entryArrayList3 = new ArrayList<>();
        entryArrayList3.add(new Entry(0, 0f, "1"));
        entryArrayList3.add(new Entry(1, 20f, "2"));
        entryArrayList3.add(new Entry(2, 10f, "3"));
        entryArrayList3.add(new Entry(3, 55f, "4"));
        entryArrayList3.add(new Entry(4, 35f, "5"));
        entryArrayList3.add(new Entry(5, 60f, "6"));

        LineDataSet lineDataSet = new LineDataSet(entryArrayList, "This is y bill");
        lineData.addDataSet(lineDataSet);

        lineDataSet.setLineWidth(3f);
        lineDataSet.setColor(Color.YELLOW);
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setDrawValues(false);
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

//     second array---------------------------

        LineDataSet lineDataSet2 = new LineDataSet(entryArrayList2, "This is z bill");
        lineData.addDataSet(lineDataSet2);

        lineDataSet2.setLineWidth(3f);
        lineDataSet2.setColor(Color.GREEN);
        lineDataSet2.setCircleColor(Color.WHITE);
        lineDataSet2.setHighLightColor(Color.RED);
        lineDataSet2.setDrawValues(false);
        lineDataSet2.setCircleRadius(10f);
        lineDataSet2.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet2.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        lineDataSet2.setDrawFilled(true);
        lineDataSet2.setFillColor(Color.GREEN);
        //set the transparency
        lineDataSet2.setFillAlpha(80);

        //set the gradiant then the above draw fill color will be replace
//        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradiant);
//        lineDataSet.setFillDrawable(drawable);

        //set legend disable or enable to hide {the left down corner name of graph}

        //to remove the cricle from the graph
        lineDataSet2.setDrawCircles(false);

//    third array---------------------------

        LineDataSet lineDataSet3 = new LineDataSet(entryArrayList3, "This is z bill");
        lineData.addDataSet(lineDataSet3);

        lineDataSet3.setLineWidth(3f);
        lineDataSet3.setColor(Color.GRAY);
        lineDataSet3.setCircleColor(Color.WHITE);
        lineDataSet3.setHighLightColor(Color.RED);
        lineDataSet3.setDrawValues(false);
        lineDataSet3.setCircleRadius(10f);
        lineDataSet3.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet3.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet3.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        lineDataSet3.setDrawFilled(true);
        lineDataSet3.setFillColor(Color.BLACK);
        //set the transparency
        lineDataSet3.setFillAlpha(80);

        //set the gradiant then the above draw fill color will be replace
//        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradiant);
//        lineDataSet.setFillDrawable(drawable);

        //set legend disable or enable to hide {the left down corner name of graph}

        //to remove the cricle from the graph
        lineDataSet3.setDrawCircles(false);


        //set the gradiant then the above draw fill color will be replace
//        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradiant);
//        lineDataSet.setFillDrawable(drawable);

        //set legend disable or enable to hide {the left down corner name of graph}
        Legend legend = lineChart.getLegend();
        legend.setEnabled(false);

        //to remove the cricle from the graph
        lineDataSet.setDrawCircles(false);
        lineDataSet2.setDrawCircles(false);
        lineDataSet3.setDrawCircles(false);

        //lineDataSet.setColor(ColorTemplate.COLORFUL_COLORS);

//        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
//        iLineDataSetArrayList.add(lineDataSet);


        //LineData is the data accord
//        LineData lineData = new LineData(iLineDataSetArrayList);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);

        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    private void customizeChart(LineChart mChart) {
        mChart.getLegend().setEnabled(false);
        mChart.getDescription().setEnabled(false);
        mChart.setVisibleXRangeMaximum(6f);
        mChart.setScaleEnabled(false);
        mChart.setExtraBottomOffset(5);
        mChart.moveViewToX((float) 10);
        mChart.setScaleYEnabled(true);
        customizeXAxis(mChart);
        customizeYAxis(mChart);
    }

    private void customizeXAxis(LineChart mChart) {
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.DKGRAY);
//        xAxis.setLabelRotationAngle(45);
        xAxis.setLabelRotationAngle(90);
//        xAxis.setValueFormatter(new DateValueFormatter());
//        IndexAxisValueFormatter
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(10);
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

//    private void customizeXAxis(LineChart mChart) {
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTextColor(Color.BLACK);
//        xAxis.setLabelRotationAngle(45);
//        xAxis.setValueFormatter(new DateValueFormatter());
//        xAxis.setDrawAxisLine(true);
//        xAxis.setAxisLineColor(Color.BLACK);
//        xAxis.setAxisLineWidth(3);
//        xAxis.setDrawGridLines(false);
//        xAxis.setLabelCount(10, true);
//    }
//
//    private void customizeYAxis(LineChart mChart) {
//        mChart.getAxisRight().setEnabled(false);
//        YAxis yAxis = mChart.getAxisLeft();
//        yAxis.setTextColor(Color.DKGRAY);
////        yAxis.setAxisLineColor(Color.BLACK);
////        yAxis.setAxisLineWidth(3);
//        // set y axis max to 101 instead of 100 so the full line width is displayed
//        yAxis.setAxisMaximum(101);
//        yAxis.setAxisMinimum(0);
//        yAxis.setDrawAxisLine(true);
//        yAxis.setDrawGridLines(false);
//
//    }

    public void viewForheadChart() {
        LineData lineData = new LineData();

        ArrayList<Entry> entryArrayList = new ArrayList<>();
//        entryArrayList.add(new Entry(0, 20f));
//        entryArrayList.add(new Entry(1, 50f));
//        entryArrayList.add(new Entry(2, 10f));
//        entryArrayList.add(new Entry(3, 30f));
//        entryArrayList.add(new Entry(4, 15f));
//        entryArrayList.add(new Entry(5, 35f));
//
//        entryArrayList.add(new Entry(0, 20f));
//        entryArrayList.add(new Entry(1, 50f));
//        entryArrayList.add(new Entry(2, 10f));
//        entryArrayList.add(new Entry(3, 30f));
//        entryArrayList.add(new Entry(4, 15f));
//        entryArrayList.add(new Entry(5, 35f));
//        entryArrayList.add(new Entry(6, 40f));

        Set<Integer> generated = new LinkedHashSet<Integer>();
        Random random = new Random();
        while (generated.size() < 100) {
            generated.add(random.nextInt(100));
        }
        List<Integer> list = new ArrayList<Integer>(generated);
        Log.e("list", "" + list.size());

//        for(int i=0;i<100;i++){
//            entryArrayList.add(new Entry(i, list.get(i)));
//        }

        for (int i = 0; i < 100; i++) {
            entryArrayList.add(new Entry(i, list.get(i)));
        }


//        entryArrayList.add(new Entry(0, 80f));
//        entryArrayList.add(new Entry(1, 70f));
//        entryArrayList.add(new Entry(2, 75f));
//        entryArrayList.add(new Entry(3, 90f));
//        entryArrayList.add(new Entry(4, 65f));
//        entryArrayList.add(new Entry(5, 76f));
//        entryArrayList.add(new Entry(6, 60f));

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

        //lineDataSet.setColor(ColorTemplate.COLORFUL_COLORS);

//        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
//        iLineDataSetArrayList.add(lineDataSet);


        //LineData is the data accord
//        LineData lineData = new LineData(iLineDataSetArrayList);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    public void viewCheekChart() {
        LineData lineData = new LineData();

        ArrayList<Entry> entryArrayList2 = new ArrayList<>();
//        entryArrayList2.add(new Entry(0, 50f, "1"));
//        entryArrayList2.add(new Entry(1, 10f, "2"));
//        entryArrayList2.add(new Entry(2, 20f, "3"));
//        entryArrayList2.add(new Entry(3, 25f, "4"));
//        entryArrayList2.add(new Entry(4, 15f, "5"));
//        entryArrayList2.add(new Entry(5, 40f, "6"));

        entryArrayList2.add(new Entry(0, 50f, "1"));
        entryArrayList2.add(new Entry(1, 10f, "2"));
        entryArrayList2.add(new Entry(2, 20f, "3"));
        entryArrayList2.add(new Entry(3, 25f, "4"));
        entryArrayList2.add(new Entry(4, 15f, "5"));
        entryArrayList2.add(new Entry(5, 40f, "6"));
        entryArrayList2.add(new Entry(6, 17f, "6"));
        entryArrayList2.add(new Entry(7, 36f, "6"));
        entryArrayList2.add(new Entry(8, 23f, "6"));
        entryArrayList2.add(new Entry(9, 35f, "6"));
        entryArrayList2.add(new Entry(10, 40f, "6"));
        entryArrayList2.add(new Entry(11, 15f, "6"));
        entryArrayList2.add(new Entry(12, 55f, "6"));
        entryArrayList2.add(new Entry(13, 35f, "6"));
        entryArrayList2.add(new Entry(14, 70f, "6"));
        entryArrayList2.add(new Entry(15, 50f, "6"));
        entryArrayList2.add(new Entry(16, 70f, "6"));
        entryArrayList2.add(new Entry(17, 45f, "6"));
        entryArrayList2.add(new Entry(18, 36f, "6"));
        entryArrayList2.add(new Entry(19, 90f, "6"));
        entryArrayList2.add(new Entry(20, 100f, "6"));
        entryArrayList2.add(new Entry(21, 76f, "6"));
        entryArrayList2.add(new Entry(22, 23f, "6"));
        entryArrayList2.add(new Entry(23, 50f, "6"));
        entryArrayList2.add(new Entry(24, 80f, "6"));
        entryArrayList2.add(new Entry(25, 60f, "6"));
        entryArrayList2.add(new Entry(26, 10f, "6"));
        entryArrayList2.add(new Entry(27, 70f, "6"));
        entryArrayList2.add(new Entry(28, 55f, "6"));
        entryArrayList2.add(new Entry(29, 15f, "6"));
        entryArrayList2.add(new Entry(30, 49f, "6"));

        LineDataSet lineDataSet2 = new LineDataSet(entryArrayList2, "This is z bill");
        lineData.addDataSet(lineDataSet2);

        lineDataSet2.setLineWidth(3f);
        lineDataSet2.setColor(Color.GREEN);
        lineDataSet2.setCircleColor(Color.WHITE);
        lineDataSet2.setHighLightColor(Color.RED);
        lineDataSet2.setDrawValues(false);
        lineDataSet2.setCircleRadius(10f);
        lineDataSet2.setCircleColor(Color.YELLOW);

        //to make the smooth line as the graph is adrapt change so smooth curve
        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //to enable the cubic density : if 1 then it will be sharp curve
        lineDataSet2.setCubicIntensity(0.2f);

        //to fill the below of smooth line in graph
        lineDataSet2.setDrawFilled(true);
        lineDataSet2.setFillColor(Color.GREEN);
        //set the transparency
        lineDataSet2.setFillAlpha(80);

        //set the gradiant then the above draw fill color will be replace
//        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradiant);
//        lineDataSet.setFillDrawable(drawable);

        //set legend disable or enable to hide {the left down corner name of graph}

        //to remove the cricle from the graph
        lineDataSet2.setDrawCircles(false);

        //lineDataSet.setColor(ColorTemplate.COLORFUL_COLORS);

//        ArrayList<ILineDataSet> iLineDataSetArrayList = new ArrayList<>();
//        iLineDataSetArrayList.add(lineDataSet);


        //LineData is the data accord
//        LineData lineData = new LineData(iLineDataSetArrayList);
        lineData.setValueTextSize(13f);
        lineData.setValueTextColor(Color.BLACK);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }

}

//
//    private class DateValueFormatter implements IAxisValueFormatter {
//
//        /**
//         * Returns the date to display on the x axis given the index
//         *
//         * @param value the x axis index on the chart
//         * @param axis
//         * @return the date in String format
//         */
//        @Override
//        public String getFormattedValue(float value, AxisBase axis) {
//            int index = Math.round(value);
//            if (days.length - 1 < index) {
//                return "";
//            }
////            Log.e("value", "" + value);
//            return days[index];
//        }
//
//    }
//}
