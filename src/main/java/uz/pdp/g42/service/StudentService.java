package uz.pdp.g42.service;

import uz.pdp.g42.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentService implements BaseService<Student> {
    private final List<Student> students = new ArrayList<>();

    private static StudentService studentService;

    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }

    @Override
    public Student create(Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return student;
    }

    @Override
    public Student getById(UUID id) throws IOException {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IOException("Student not found"));
    }

    @Override
    public boolean delete(UUID id) {
        Student student = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (student == null || !student.isActive()) {
            return false;
        }

        student.setActive(false);
        return true;
    }

    @Override
    public List<Student> getList() {
        return students;
    }
}
