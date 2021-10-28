package entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {
    public static void listTopLT (List<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getLt(),o1.getLt());
            }
        });
        for (int i = 0; i < 10; i++) {
            System.out.println(students.get(i).getName()+ " " + students.get(i).getLt());
        }
    }

    public static void calculateAvg (List<Student>students){
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setAvg(Math.round((students.get(i).getBonus()*0.1 + students.get(i).getReport()*0.3 + students.get(i).getApp()*0.15 + students.get(i).getLt()*0.45)*10)/10.0);
            students.get(i).setAvg(Math.round(students.get(i).getAvg()*2)/2.0);
        }
    }

    public static void listLowestAvg (List<Student>students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getAvg(),o2.getAvg());
            }
        });
        for (int i = 0; i < 10; i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getAvg());
        }
    }
}
