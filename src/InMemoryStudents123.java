import exceptions.ChangeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStudents123 implements Students123{
    private final Map<String, Student> studentMap = new HashMap<>();

    @Override
    public void putChange(Student student) {
        studentMap.put(student.name(), student);
    }

    @Override
    public Student getChange(String name, String object, int number) throws ChangeNotFoundException {
        Student student = studentMap.get(name);
        if(student == null){
            throw new ChangeNotFoundException(name);
        }
        return student;
    }


    @Override
    public float getAverageRating(List<Student> students) {
    int sumScore = 0;
        for (int i = 0; i < students.size(); i++) {
            sumScore = sumScore + students.get(i).number();
        }
        return sumScore/students.size();
    }

    @Override
    public List<String> getStudentsGood(List<Student> students) {
        List<String> excellentStudents = new ArrayList<>();
        for(Student items : students){
            if(items.number() == 5){
                excellentStudents.add(items.name());
            }
        }
        return excellentStudents;
    }

    @Override
    public void getObjects(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
