package ua.kpi.comsys.io8313.labs1_2.resource;

import android.annotation.SuppressLint;

public class CoordinateDK {
    private Direction direction;
    private int degrees;
    private int minutes;
    private int seconds;
    private int longitude;
    private int latinude;

    public int getDegrees(){
        return degrees;
    }

    public void setDegrees(int degrees){
        this.degrees = degrees;
    }

    public int getMinutes(){
        return minutes;
    }

    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    public int getSeconds(){
        return seconds;
    }

    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    public CoordinateDK(){
        this.seconds = 0;
        this.minutes = 0;
        this.degrees = 0;
        this.longitude = direction.longitude = 0;
        this.latinude = direction.latinude = 0;
    }

    private void setLocal(int degrees, int latinude, int longitude, int minutes, int seconds){
        if ((degrees > 90 || degrees < -90) || (latinude > 90 || latinude < -90) || (longitude > 180 || longitude < -180) ||
                (minutes < 0 || minutes > 59) || (seconds < 0 || seconds > 59)){
            throw new IllegalArgumentException("Invalid date format:"+ String.format("%d:%d:%d:%d:%d", degrees, latinude, longitude, minutes, seconds));
        }
    }

    private String inputInt(int degrees, int minutes, int seconds){
        @SuppressLint("DefaultLocale") String taskA = String.format("%d:%d:%d", degrees, minutes, seconds);
        return taskA;
    }

    private String inputFloat(float degrees, float minutes, float seconds){
        @SuppressLint("DefaultLocale") String taskB = String.format("%d:%d:%d", degrees, minutes, seconds);
        return taskB;
    }
}


