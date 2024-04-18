import exceptions.ChangeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class InMemoryStudents123Test {

    private Students123 students123;

    @BeforeEach
    void setUp() {
        students123 = new InMemoryStudents123();
    }

    @org.junit.jupiter.api.Test
    void putChange() throws ChangeNotFoundException {
        Student student = new Student("����", "�����������", 5);
        students123.putChange(student);

        Student actual = students123.getChange(student.name(), student.object(), student.number());
        Assertions.assertEquals(student, actual);
    }

    @org.junit.jupiter.api.Test
    void getChange() throws ChangeNotFoundException {
        Student student1 = new Student("����", "����������", 4);
        Map<String, Student> zachet = new HashMap<>();
        zachet.put(student1.name(), student1);

        Student studentActual = zachet.get(student1.name());
        Assertions.assertEquals(student1, studentActual);
        Assertions.assertThrows(ChangeNotFoundException.class, () -> students123.getChange("����", "����������", 4));
    }

    @org.junit.jupiter.api.Test
    void getAverageRating(List<Student> students) {
        Student student1 = new Student("����", "�����������", 5);
        Student student2 = new Student("����", "�����������", 3);
        Student student3 = new Student("����", "�����������", 4);
        Student student4 = new Student("����", "�����������", 2);
        Student student5 = new Student("����", "�����������", 5);
        Student student6 = new Student("����", "�����������", 4);
        List<Student> zachet = List.of(student1, student2, student3, student4, student5, student6);

        float averageMark = students123.getAverageRating((zachet));
        Assertions.assertEquals(3, averageMark);
    }

    @org.junit.jupiter.api.Test
    void getStudentsGood(List<Student> students) {
        Student student1 = new Student("����", "�����������", 5);
        Student student2 = new Student("����", "�����������", 3);
        Student student3 = new Student("����", "�����������", 4);
        Student student4 = new Student("����", "�����������", 2);
        Student student5 = new Student("������", "�����������", 5);
        Student student6 = new Student("�����", "�����������", 4);
        Student student7 = new Student("����", "�����������", 4);
        List<Student> studentss = List.of(student1, student2, student3, student4, student5, student6, student7);
        List<String> excellentStudents = new ArrayList<>();
        List<String> exvellentStudents = students123.getStudentsGood((studentss));

        Assertions.assertEquals(List.of("����", "������", "����", "�����", "����"), exvellentStudents);
    }

    @org.junit.jupiter.api.Test
    void getObjects(List<Student> students) {
        Student student1 = new Student("����", "�����������", 5);
        Student student2 = new Student("����", "�����������", 3);
        Student student3 = new Student("����", "�����������", 4);
        Student student4 = new Student("����", "�����������", 2);
        Student student5 = new Student("������", "�����������", 5);
        Student student6 = new Student("�����", "�����������", 4);
        Student student7 = new Student("����", "�����������", 4);
        List<Student> studentss = List.of(student1, student2, student3, student4, student5, student6, student7);
        students123.getObjects((studentss));
        Assertions.assertEquals(7, students.size());
    }
}