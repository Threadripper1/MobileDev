<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.parts;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;
import ua.kpi.comsys.io8313.mobiledev.Additionally.RangeForClass;
import ua.kpi.comsys.io8313.mobiledev.R;

public class PieAndGraphFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private SegmentedGroup tableSegmanted;
    private LineChart lineChart;
    private PieChart pieChart;
    public static final RangeForClass linerChartRange = new RangeForClass(-3, 3);
    public static final float DELTA = 0.01f;
    public static final float[] PIE_DATA = {15, 25, 45, 10, 5};
    public static final List<Integer> PIE_COLORS = new ArrayList<>(Arrays.asList(
            Color.YELLOW, Color.parseColor("#964B00"),
            Color.parseColor("#858585"), Color.RED, Color.parseColor("#5A009D")));

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.charts_fragment, container, false);
        tableSegmanted = view.findViewById(R.id.segmented);
        tableSegmanted.setOnCheckedChangeListener(this);

        lineChart = view.findViewById(R.id.line_chart);
        lineChart.setNoDataText("Select type of diagram on the button");

        pieChart = view.findViewById(R.id.pie_chart);
        pieChart.setNoDataText("Select type of diagram on the button");

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Description chartDescription = new Description();
        chartDescription.setText("");

        switch (checkedId){
            case R.id.lineChartButton:
                pieChart.setVisibility(View.GONE);
                lineChart.setVisibility(View.VISIBLE);
                LineDataSet lineDataSet = new LineDataSet(loadLineData(), "Data set");
                lineDataSet.setDrawCircles(false);
                lineDataSet.setLineWidth(1.5f);
                lineDataSet.setCircleColor(Color.MAGENTA);
                LineData lineData = new LineData(lineDataSet);
                lineChart.getLegend().setEnabled(false);
                lineChart.setData(lineData);
                lineChart.invalidate();
                break;

            case R.id.pieChartButton:
                lineChart.setVisibility(View.GONE);
                pieChart.setVisibility(View.VISIBLE);
                PieDataSet pieDataSet = new PieDataSet(loadPieData(PIE_DATA), "");
                pieDataSet.setColors(PIE_COLORS);
                PieData pieData = new PieData(pieDataSet);
                pieData.setDrawValues(false);
                pieChart.setDescription(chartDescription);
                pieChart.getLegend().setEnabled(false);
                pieChart.setHoleRadius(0);
                pieChart.setEntryLabelColor(Color.parseColor("#32CD32"));
                pieChart.setDrawHoleEnabled(false);
                pieChart.setData(pieData);
                pieChart.invalidate();
                break;
                default:
        }
    }

    public PieAndGraphFragment(){
    }

    private ArrayList<Entry> loadLineData(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        float i = linerChartRange.getStart() + DELTA;
        for(; i < linerChartRange.getEnd(); i+=DELTA){
            dataSet.add(new Entry(i, (float) Math.pow(i,3)));
        }
        return dataSet;
    }


    private ArrayList<PieEntry> loadPieData(float ... percents){
        ArrayList<PieEntry> pieDataSet = new ArrayList<>();
        for(float percent : percents){
            pieDataSet.add(new PieEntry(percent, percent + "%"));
        }
        return pieDataSet;
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.parts;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.hoang8f.android.segmented.SegmentedGroup;
import ua.kpi.comsys.io8313.mobiledev.Additionally.RangeForClass;
import ua.kpi.comsys.io8313.mobiledev.R;

public class PieAndGraphFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private SegmentedGroup tableSegmanted;
    private LineChart lineChart;
    private PieChart pieChart;
    public static final RangeForClass linerChartRange = new RangeForClass(-3, 3);
    public static final float DELTA = 0.01f;
    public static final float[] PIE_DATA = {15, 25, 45, 10, 5};
    public static final List<Integer> PIE_COLORS = new ArrayList<>(Arrays.asList(
            Color.YELLOW, Color.parseColor("#964B00"),
            Color.parseColor("#858585"), Color.RED, Color.parseColor("#5A009D")));

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.charts_fragment, container, false);
        tableSegmanted = view.findViewById(R.id.segmented);
        tableSegmanted.setOnCheckedChangeListener(this);

        lineChart = view.findViewById(R.id.line_chart);
        lineChart.setNoDataText("Select type of diagram on the button");

        pieChart = view.findViewById(R.id.pie_chart);
        pieChart.setNoDataText("Select type of diagram on the button");

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Description chartDescription = new Description();
        chartDescription.setText("");

        switch (checkedId){
            case R.id.lineChartButton:
                pieChart.setVisibility(View.GONE);
                lineChart.setVisibility(View.VISIBLE);
                LineDataSet lineDataSet = new LineDataSet(loadLineData(), "Data set");
                lineDataSet.setDrawCircles(false);
                lineDataSet.setLineWidth(1.5f);
                lineDataSet.setCircleColor(Color.MAGENTA);
                LineData lineData = new LineData(lineDataSet);
                lineChart.getLegend().setEnabled(false);
                lineChart.setData(lineData);
                lineChart.invalidate();
                break;

            case R.id.pieChartButton:
                lineChart.setVisibility(View.GONE);
                pieChart.setVisibility(View.VISIBLE);
                PieDataSet pieDataSet = new PieDataSet(loadPieData(PIE_DATA), "");
                pieDataSet.setColors(PIE_COLORS);
                PieData pieData = new PieData(pieDataSet);
                pieData.setDrawValues(false);
                pieChart.setDescription(chartDescription);
                pieChart.getLegend().setEnabled(false);
                pieChart.setHoleRadius(0);
                pieChart.setEntryLabelColor(Color.parseColor("#32CD32"));
                pieChart.setDrawHoleEnabled(false);
                pieChart.setData(pieData);
                pieChart.invalidate();
                break;
                default:
        }
    }

    public PieAndGraphFragment(){
    }

    private ArrayList<Entry> loadLineData(){
        ArrayList<Entry> dataSet = new ArrayList<>();
        float i = linerChartRange.getStart() + DELTA;
        for(; i < linerChartRange.getEnd(); i+=DELTA){
            dataSet.add(new Entry(i, (float) Math.pow(i,3)));
        }
        return dataSet;
    }


    private ArrayList<PieEntry> loadPieData(float ... percents){
        ArrayList<PieEntry> pieDataSet = new ArrayList<>();
        for(float percent : percents){
            pieDataSet.add(new PieEntry(percent, percent + "%"));
        }
        return pieDataSet;
    }
}
>>>>>>> f951f76 (lab5)
