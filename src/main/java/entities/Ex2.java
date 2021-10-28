package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex2 {
    public static void listGmail (List<Student> students) {
        Pattern patternGmail = Pattern.compile("^(.+)@gmail(.+)$");
        List<Student> dsSinhVienGMail = getStudent(students, patternGmail);
        for (int i = 0; i < dsSinhVienGMail.size(); i++) {
            System.out.println(dsSinhVienGMail.get(i));
        }
    }
    public static void listOutlook (List<Student> students) {
        List<Student> dsOutlook = getOutlook(students);
        for (int i = 0; i < dsOutlook.size(); i++) {
            System.out.println(dsOutlook.get(i));
        }
    }
    public static List<Student> getOutlook (List<Student> students) {
        Pattern patternOutlook = Pattern.compile("^(.+)@outlook(.+)$");
        return getStudent(students, patternOutlook);
    }

    public static void printOutlookMail(List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream("outlook.bin");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            for (Student st : getOutlook(students)) {
                dos.writeUTF(st.getID());
                dos.writeUTF(st.getName());
                dos.writeUTF(st.getEmail());
                dos.writeDouble(st.getBonus());
                dos.writeDouble(st.getReport());
                dos.writeDouble(st.getApp());
                dos.writeDouble(st.getLt());
            }
            dos.flush();
            dos.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static void readOutlook (){
        try

    {
        FileInputStream fis = new FileInputStream("outlook.bin");
        DataInputStream dis = new DataInputStream(fis);
        while (dis.available() > 0) {
            String ID = dis.readUTF();
            String name = dis.readUTF();
            String email = dis.readUTF();
            double bonus = dis.readDouble();
            double report = dis.readDouble();
            double app = dis.readDouble();
            double lt = dis.readDouble();
            Student getOutlook = new Student(ID, name, email, bonus, report, app, lt);
            System.out.println(getOutlook);
        }
        dis.close();
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }

}

    public static List<Student> getStudent(List<Student> students, Pattern pattern) {
        List<Student> results = new ArrayList<>();
        int n = students.size();
        for (Student st : students) {
            Matcher matcher = pattern.matcher(st.email);
            if (matcher.find()) {
                results.add(st);
            }
        }
        return results;
    }
}