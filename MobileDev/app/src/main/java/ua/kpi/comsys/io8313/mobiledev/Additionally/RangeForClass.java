package ua.kpi.comsys.io8313.mobiledev.Additionally;

import android.annotation.SuppressLint;

public class RangeForClass {
    private int start;
    private int end;

    public RangeForClass(int start, int end){
        this.end = end;
        this.start = start;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public void setStart(int start){
        this.start = start;
    }

    public void setEnd(int end){
        this.end = end;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString(){
        return String.format("[%d %d]", start, end);
    }
}
