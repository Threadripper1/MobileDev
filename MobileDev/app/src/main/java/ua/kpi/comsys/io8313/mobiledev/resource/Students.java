<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Students {

    public static List<Integer> getPoints(Integer[] maxPoints){
        List<Integer> points = new ArrayList<>();
        for (Integer maxPoint : maxPoints){
            points.add(randomVal(maxPoint));
        }
        return points;
    }

    public static int randomVal(int maxVal){
        Random random = new Random();
        switch (random.nextInt(6) + 1){
            case 1:
                return (int) Math.ceil(maxVal * 0.7);
            case 2:
                return (int) Math.ceil(maxVal * 0.9);
            case 3:
            case 4:
            case 5:
                return maxVal;
            default:
                return 0;
        }
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Students {

    public static List<Integer> getPoints(Integer[] maxPoints){
        List<Integer> points = new ArrayList<>();
        for (Integer maxPoint : maxPoints){
            points.add(randomVal(maxPoint));
        }
        return points;
    }

    public static int randomVal(int maxVal){
        Random random = new Random();
        switch (random.nextInt(6) + 1){
            case 1:
                return (int) Math.ceil(maxVal * 0.7);
            case 2:
                return (int) Math.ceil(maxVal * 0.9);
            case 3:
            case 4:
            case 5:
                return maxVal;
            default:
                return 0;
        }
    }
}
>>>>>>> f951f76 (lab5)
