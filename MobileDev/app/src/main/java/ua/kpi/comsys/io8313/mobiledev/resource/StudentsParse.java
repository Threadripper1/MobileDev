<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.resource;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentsParse {
    private static final Collator collator = Collator.getInstance(new Locale("uk", "UA"));
    private final String studentsStr;
    private final Map<Student, String> groupOfStudens;
    private final List<Student> students;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public StudentsParse(String studentsStr) {
        this.studentsStr = studentsStr;
        this.groupOfStudens = parse(studentsStr);
        this.students = new ArrayList<>(groupOfStudens.keySet());
    }

    public List<Student> getStudents(){
        return students;
    }

    public Collection<String> getGroups(){
        return this.groupOfStudens.values();
    }

    public String getInputStr(){
        return studentsStr;
    }

    public Map<Student, String > getGroupOfStudens(){
        return getGroupOfStudens();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Map<Student, String> parse(String studentsStr){
        if (studentsStr == null){
            return null;
        }
        String[] s = studentsStr.split(";");
        return Arrays.stream(s).map(students -> students.split("-"))
                .collect(Collectors.toMap(strings -> new Student(strings[0].trim()), strings -> strings[1].trim()));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, List<Student>> takeOfGroups(){
        Set<String> groups = new HashSet<>(this.getGroups());
        Map<String, List<Student>> groupMap = new HashMap<>();
        for (final String group : groups){
            List<Student> s = groupOfStudens.entrySet().stream().filter(students -> students.getValue().equals(group)).map(Map.Entry::getKey)
                    .sorted((s1, s2) -> collator.compare(s1.getName(), s2.getName())).collect(Collectors.toList());
            groupMap.put(group, s);
        }
        return groupMap;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Double> groupOfMiddleMarks(Map<String, Map<Student, Integer>> studentsWithFinalMarks) {
        Map<String, Double> groupAvgMarks = new HashMap<>();
        for (Map.Entry<String, Map<Student, Integer>> studentEntrySetWithMarks: studentsWithFinalMarks.entrySet()) {
            Map<Student, Integer> studentSet = studentEntrySetWithMarks.getValue();
            Double avg = null;
            avg = studentSet.values().stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            groupAvgMarks.put(studentEntrySetWithMarks.getKey(), avg);
        }
        return groupAvgMarks;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Map<Student, Integer>> groupOfMiddleFinalMarks(Map<String, Map<Student, List<Integer>>> studentsWithPointsByGroups) {
        Map<String, Map<Student, Integer>> studentsWithMarksByGroup = new HashMap<>();
        for (Map.Entry<String, Map<Student, List<Integer>>> studentsWithPoints: studentsWithPointsByGroups.entrySet()) {
            Map<Student, Integer> studentsWithSumMarks = new HashMap<>();
            for (Map.Entry<Student, List<Integer>> studentIntegerMap: studentsWithPoints.getValue().entrySet()) {
                studentsWithSumMarks.put(
                        studentIntegerMap.getKey(),
                        studentIntegerMap.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .sum()
                );
            }
            studentsWithMarksByGroup.put(studentsWithPoints.getKey(), studentsWithSumMarks);
        }

        return studentsWithMarksByGroup;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, List<Student>> filtStudents(Map<String, Map<Student, Integer>> studentsWithFinalMarks, int floor) {
        Map<String, List<Student>> filteredStudentMap = new HashMap<>();
        for (Map.Entry<String, Map<Student, Integer>> studentSetWithMarks: studentsWithFinalMarks.entrySet()) {
            List<Student> students = studentSetWithMarks.getValue().entrySet().stream()
                    .filter(x -> x.getValue() >= floor)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            filteredStudentMap.put(studentSetWithMarks.getKey(), students);
        }

        return filteredStudentMap;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Map<Student, List<Integer>>> theGroupWithMarks(Integer[] maxPoints) {
        Map<String, Map<Student, List<Integer>>> studentsWithMarksByGroups = new HashMap<>();
        Map<String, List<Student>> groupMap = this.takeOfGroups();

        for (Map.Entry<String, List<Student>> gm : groupMap.entrySet()) {
            Map<Student, List<Integer>> studentsWithMarks = gm.getValue().stream()
                    .collect(Collectors.toMap(
                            student -> student, student -> Students.getPoints(maxPoints)
                            )
                    );
            studentsWithMarksByGroups.put(gm.getKey(), studentsWithMarks);
        }

        return studentsWithMarksByGroups;
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.resource;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentsParse {
    private static final Collator collator = Collator.getInstance(new Locale("uk", "UA"));
    private final String studentsStr;
    private final Map<Student, String> groupOfStudens;
    private final List<Student> students;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public StudentsParse(String studentsStr) {
        this.studentsStr = studentsStr;
        this.groupOfStudens = parse(studentsStr);
        this.students = new ArrayList<>(groupOfStudens.keySet());
    }

    public List<Student> getStudents(){
        return students;
    }

    public Collection<String> getGroups(){
        return this.groupOfStudens.values();
    }

    public String getInputStr(){
        return studentsStr;
    }

    public Map<Student, String > getGroupOfStudens(){
        return getGroupOfStudens();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Map<Student, String> parse(String studentsStr){
        if (studentsStr == null){
            return null;
        }
        String[] s = studentsStr.split(";");
        return Arrays.stream(s).map(students -> students.split("-"))
                .collect(Collectors.toMap(strings -> new Student(strings[0].trim()), strings -> strings[1].trim()));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, List<Student>> takeOfGroups(){
        Set<String> groups = new HashSet<>(this.getGroups());
        Map<String, List<Student>> groupMap = new HashMap<>();
        for (final String group : groups){
            List<Student> s = groupOfStudens.entrySet().stream().filter(students -> students.getValue().equals(group)).map(Map.Entry::getKey)
                    .sorted((s1, s2) -> collator.compare(s1.getName(), s2.getName())).collect(Collectors.toList());
            groupMap.put(group, s);
        }
        return groupMap;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Double> groupOfMiddleMarks(Map<String, Map<Student, Integer>> studentsWithFinalMarks) {
        Map<String, Double> groupAvgMarks = new HashMap<>();
        for (Map.Entry<String, Map<Student, Integer>> studentEntrySetWithMarks: studentsWithFinalMarks.entrySet()) {
            Map<Student, Integer> studentSet = studentEntrySetWithMarks.getValue();
            Double avg = null;
            avg = studentSet.values().stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            groupAvgMarks.put(studentEntrySetWithMarks.getKey(), avg);
        }
        return groupAvgMarks;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Map<Student, Integer>> groupOfMiddleFinalMarks(Map<String, Map<Student, List<Integer>>> studentsWithPointsByGroups) {
        Map<String, Map<Student, Integer>> studentsWithMarksByGroup = new HashMap<>();
        for (Map.Entry<String, Map<Student, List<Integer>>> studentsWithPoints: studentsWithPointsByGroups.entrySet()) {
            Map<Student, Integer> studentsWithSumMarks = new HashMap<>();
            for (Map.Entry<Student, List<Integer>> studentIntegerMap: studentsWithPoints.getValue().entrySet()) {
                studentsWithSumMarks.put(
                        studentIntegerMap.getKey(),
                        studentIntegerMap.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .sum()
                );
            }
            studentsWithMarksByGroup.put(studentsWithPoints.getKey(), studentsWithSumMarks);
        }

        return studentsWithMarksByGroup;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, List<Student>> filtStudents(Map<String, Map<Student, Integer>> studentsWithFinalMarks, int floor) {
        Map<String, List<Student>> filteredStudentMap = new HashMap<>();
        for (Map.Entry<String, Map<Student, Integer>> studentSetWithMarks: studentsWithFinalMarks.entrySet()) {
            List<Student> students = studentSetWithMarks.getValue().entrySet().stream()
                    .filter(x -> x.getValue() >= floor)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            filteredStudentMap.put(studentSetWithMarks.getKey(), students);
        }

        return filteredStudentMap;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Map<String, Map<Student, List<Integer>>> theGroupWithMarks(Integer[] maxPoints) {
        Map<String, Map<Student, List<Integer>>> studentsWithMarksByGroups = new HashMap<>();
        Map<String, List<Student>> groupMap = this.takeOfGroups();

        for (Map.Entry<String, List<Student>> gm : groupMap.entrySet()) {
            Map<Student, List<Integer>> studentsWithMarks = gm.getValue().stream()
                    .collect(Collectors.toMap(
                            student -> student, student -> Students.getPoints(maxPoints)
                            )
                    );
            studentsWithMarksByGroups.put(gm.getKey(), studentsWithMarks);
        }

        return studentsWithMarksByGroups;
    }
}
>>>>>>> f951f76 (lab5)
