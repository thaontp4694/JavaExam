import entities.Ex2;
import entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestEx2 {

    @Test
    public void TestEx2(){
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
        List<Student> dsOutlook = Ex2.getOutlook(students);
        Assertions.assertTrue(dsOutlook.get(0).getEmail().contains("outlook.com"));
    }
}