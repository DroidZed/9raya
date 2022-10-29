package esprit.ws.reposot;

import java.util.ArrayList;
import java.util.List;

import esprit.ws.entities.Student;

public class StudentRepository {

    private List<Student> students;

    public StudentRepository() {

        students = new ArrayList<Student>();

        students.add(new Student("123", "ben foulen ahmed", "ahmed@gmail.com"));
        students.add(new Student("456", "ben ahmed ala", "alaaa@gmail.com"));
    }

    public List<Student> getListStudent() {
        return students;
    }

    public void saveStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudentbycin(String cin) {
        for (Student S : students) {
            if (S.getCin().equals(cin))

                return S;

        }
        return null;

    }

    public void deleteStudent(String cin) {
        Student s = this.getStudentbycin(cin);
        this.students.remove(s);

    }

    public void updateStudent(Student s) {
        
        students.stream().filter(st -> st.getCin().equals(s.getCin()));

    }

}
