package ua.kpi.comsys.io8313.labs1_2.resource;

import android.annotation.SuppressLint;

public class CoordinateDK {
    private String direction;
    private int degrees;
    private int minutes;
    private int seconds;
    int subv;

    public CoordinateDK(){
        this.seconds = 0;
        this.minutes = 0;
        this.degrees = 0;
    }

    public CoordinateDK(int degrees, int minutes, int seconds, String direction){
        this.seconds = seconds;
        this.minutes = minutes;
        this.degrees = degrees;
        this.direction = direction;
    }

    private void setLocal(int degrees,  int minutes, int seconds){
        if ((degrees > 90 || degrees < -90) || (minutes < 0 || minutes > 59) || (seconds < 0 || seconds > 59)){
            throw new IllegalArgumentException("Error. Invalid direction format !");
        }
    }

    private void setLocalf(double degrees,  double minutes, double seconds){
        if ((degrees > 90.0 || degrees < -90.0) || (minutes < 0 || minutes > 59.9) || (seconds < 0 || seconds > 59.9)){
            throw new IllegalArgumentException("Error. Invalid direction format !");
        }
    }

    public String inputInt(int degrees, int minutes, int seconds){
        setLocal(degrees, minutes, seconds);
        String taskA = String.format("%d° %d′ %d″", degrees, minutes, seconds);
        return taskA;
    }

    public String inputFloat(double degrees, double minutes, double seconds){
        setLocalf(degrees, minutes, seconds);
        String taskB = String.format("%.3f° %.3f′ %.3f″", degrees, minutes, seconds);
        return taskB;
    }

    public CoordinateDK getOne(CoordinateDK cor2){
        if ((direction.length() > 1) || (cor2.direction.length() > 1))
            return null;
        else if (direction.length() <= 1){
            if ((direction == "N") && (cor2.direction == "S") || (direction == "S") && (cor2.direction == "N")){
                degrees = this.degrees - cor2.degrees;
                minutes = this.minutes - cor2.minutes;
                seconds = this.seconds - cor2.seconds;}
            else if ((direction == "W") && (cor2.direction == "E") || (direction == "E") && (cor2.direction == "W")){
                degrees = this.degrees - cor2.degrees;
                minutes = this.minutes - cor2.minutes;
                seconds = this.seconds - cor2.seconds;}
            else if ((direction == "W") && (cor2.direction == "N") || (direction == "N") && (cor2.direction == "W"))
                return null;
            else if ((direction == "N") && (cor2.direction == "E") || (direction == "E") && (cor2.direction == "N"))
                return null;
            else if ((direction == "E") && (cor2.direction == "S") || (direction == "S") && (cor2.direction == "E"))
                return null;
            else if ((direction == "W") && (cor2.direction == "S") || (direction == "S") && (cor2.direction == "W"))
                return null;
            else
                degrees = (this.degrees + cor2.degrees) / 2;
            minutes = (this.minutes + cor2.minutes) / 2;
            seconds = (this.seconds + cor2.seconds) / 2;
        }
        return new CoordinateDK(degrees, minutes, seconds, direction);
    }

    public static CoordinateDK getmiddle(CoordinateDK cor1, CoordinateDK cor2){
        return cor1.getOne(cor2);
    }

    @Override
    public String toString(){
        return degrees + "° " + minutes + "′ " + seconds + "″ " + direction;
    }
}


