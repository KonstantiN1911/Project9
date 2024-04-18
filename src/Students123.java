import exceptions.ChangeNotFoundException;

import java.util.List;


public interface Students123 {
    void putChange(Student student);
    Student getChange(String name, String object, int number) throws ChangeNotFoundException;


    float getAverageRating(List<Student> students);
    List<String> getStudentsGood(List<Student> students);
    void getObjects(List<Student> students);
}
