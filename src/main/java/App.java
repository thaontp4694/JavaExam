import entities.Ex1;
import entities.Ex2;
import entities.Student;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students.add(new Student(values[0], values[1], values[2], Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6])));
            }
            System.out.println("---------Bài 1---------");
            System.out.println("10 sinh viên có điểm thi lý thuyết cao nhất");
            Ex1.listTopLT(students);
            System.out.println();
            Ex1.calculateAvg(students);
            System.out.println("10 sinh viên có điểm trung bình thấp nhất");
            Ex1.listLowestAvg(students);
            File csvOutputFile = new File("output.csv");
            try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
                for (int i = 0; i < students.size(); i++) {
                    pw.println(students.get(i).toString());
                }
            }
            System.out.println("--------Bài 2---------");
            System.out.println("Sinh viên sử dụng outlook");
            Ex2.listOutlook(students);
            System.out.println("Sinh viên sử dụng gmail");
            Ex2.listGmail(students);
            Ex2.printOutlookMail(students);
            System.out.println("In thông tin sv sử dụng outlook trong file:");
            Ex2.readOutlook();

        } catch (Exception e) {

        }
    }

}


