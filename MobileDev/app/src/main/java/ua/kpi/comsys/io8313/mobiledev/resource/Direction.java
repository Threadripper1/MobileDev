package ua.kpi.comsys.io8313.mobiledev.resource;

public class Direction {
    CoordinateDK coordinateDK;
    int latinude;
    int longitude;
    String side;
    public String N = "N", S = "S", W = "W", E = "E";

    public Direction(){
        this.longitude = 0;
        this.latinude = 0;
    }

    private void setLocal(int latinude, int longitude){
        if ((latinude > 90 || latinude < -90) || (longitude > 180 || longitude < -180)){
            throw new IllegalArgumentException("Error. Invalid direction format !");
        }
    }

    public String inputDirection(int latinude, int longitude){
        setLocal(latinude,  longitude);
        String mid = getAvg(latinude, longitude);
        String taskA = String.format("%s", mid);
        return taskA;
    }

    String getAvg(int latinude, int longitude){
        setLocal(latinude, longitude);
        if ((longitude > 0) && (latinude < 0))
            side = N + W;
        else if ((longitude > 0) && (latinude > 0))
            side = N + E;
        else if ((longitude < 0) && (latinude < 0))
            side = S + W;
        else if ((longitude < 0) && (latinude > 0))
            side = S + E;
        else if (longitude > 0)
            side = N;
        else if (longitude < 0)
            side = S;
        else if (latinude > 0)
            side = E;
        else if (latinude < 0)
            side = W;
        else
            side = null;
        return side;
    }

    public Direction(int latinude, int longitude){
        this.longitude = longitude;
        this.latinude = latinude;
        getAvg(latinude, longitude);
    }


    @Override
    public String toString(){
        return latinude + " " + longitude;
    }



}