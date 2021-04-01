package ua.kpi.comsys.io8313.labs1_2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Map;

import ua.kpi.comsys.io8313.labs1_2.resource.CoordinateDK;
import ua.kpi.comsys.io8313.labs1_2.resource.Direction;
import ua.kpi.comsys.io8313.labs1_2.resource.Student;
import ua.kpi.comsys.io8313.labs1_2.resource.StudentsParse;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LabMain {
    public static void main(String[] args) {
        String studentStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія- ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Мітячкін Денис Євгенійович - ІО-83; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";
        Integer[] points = {12, 12, 12, 12, 12, 12, 12, 16};
        StudentsParse studentsParse = new StudentsParse(studentStr);
        System.out.println("\nStudents: " + studentStr);

        //Task 1
        Map<String, List<Student>> groupMaps = studentsParse.takeOfGroups();
        System.out.println("\nTask1:\n" + groupMaps);

        //Task2
        Map<String, Map<Student, List<Integer>>> theGroupWithMarks = studentsParse.theGroupWithMarks(points);
        System.out.println("\nTask2:\n" + theGroupWithMarks);

        //Task3
        Map<String, Map<Student, Integer>> groupOfMiddleFinalMarks = studentsParse.groupOfMiddleFinalMarks(theGroupWithMarks);
        System.out.println("\nTask3:\n" + groupOfMiddleFinalMarks);

        //Task4
        Map<String, Double> groupOfMiddleMarks = studentsParse.groupOfMiddleMarks(groupOfMiddleFinalMarks);
        System.out.println("\nTask4:\n" + groupOfMiddleMarks);

        //Task5
        int max = 85;
        Map<String, List<Student>> filtStudents = studentsParse.filtStudents(groupOfMiddleFinalMarks, max);
        System.out.println("\nTask5:\n" + filtStudents);

        CoordinateDK coordinateDK = new CoordinateDK(10, 20, 30, "E");
        Direction direction = new Direction(10, 10);

        CoordinateDK[] cor2 = {
                new CoordinateDK(12, 30, 40, "W"),
                new CoordinateDK(10, 20, 30, "NE"),
                new CoordinateDK(60, 50, 40, "E"),
                new CoordinateDK(2, 10, 20, "S"),
                new CoordinateDK(-45, 25, 45, "W"),
                new CoordinateDK()
        };

        Direction[] dir2 = {
                new Direction(-10, 10),
                new Direction(10, 10),
                new Direction(80, 100),
                new Direction(-25, -100),
                new Direction(-75, -145),
                new Direction()
        };

        System.out.println("\nDirection:"+ coordinateDK.inputInt(60, 20, 10) + " " + direction.inputDirection(0, 110));
        System.out.println("Direction:"+ coordinateDK.inputInt(89, 40, 46) + " " + direction.inputDirection(0, -50));
        System.out.println("Direction:"+ coordinateDK.inputFloat(60.0, 20.0, 10.0) + " " + direction.inputDirection(80, 0));
        System.out.println("Direction:"+ coordinateDK.inputFloat(89.0, 40.0, 46.0) + " " + direction.inputDirection(-10, 0) +"\n");

        for (int i = 0; i < cor2.length; i++)
            System.out.printf("Coordinates%d: %s%s%n", i+1, cor2[i], dir2[i]) ;

        System.out.println("\nGet average value:");
        System.out.println("Mean:"+ coordinateDK.getOne(cor2[2]));
        System.out.println("Mean:"+ CoordinateDK.getmiddle(cor2[0], cor2[4]));

        System.out.println("\nInvalid input direction:");
        System.out.println("Mean:"+ coordinateDK.getOne(cor2[1]));
        System.out.println("Direction:"+ coordinateDK.inputInt(60, -1, 10) + " " + direction.inputDirection(0, 110));
    }
}