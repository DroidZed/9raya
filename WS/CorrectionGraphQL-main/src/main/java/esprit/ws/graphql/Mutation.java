package esprit.ws.graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.ws.entities.Student;
import esprit.ws.reposot.StudentRepository;

public class Mutation implements GraphQLRootResolver {
    private StudentRepository studentRepository;

    public Mutation(StudentRepository stdR) {
        // TODO Auto-generated constructor stub
        this.studentRepository = stdR;
    }

    public Student createStudent(String cin, String nompre, String email) {
        Student s = new Student(cin, nompre, email);
        this.studentRepository.saveStudent(s);
        return s;
    }

    public Student deleteStudent(String cin) {
        this.studentRepository.deleteStudent(cin);
        return null;
    }

    public Student updateStudent(String cin, String nompre, String email) {
        Student s = new Student(cin, nompre, email);
        this.studentRepository.updateStudent(s);
        return s;
    }
}
