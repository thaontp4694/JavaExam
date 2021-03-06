import entities.Ex1;
import entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestEx1 {

    @Test
    public void TestEx1(){
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students.add(new Student(values[0], values[1], values[2], Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6])));
            }
        } catch (Exception e) {

        }
        Ex1.listTopLT(students);
        Assertions.assertTrue(students.get(0).getLt() > students.get(1).getLt());
    }
}
