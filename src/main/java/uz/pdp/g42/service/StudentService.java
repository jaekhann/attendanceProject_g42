package uz.pdp.g42.service;

import uz.pdp.g42.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class StudentService implements BaseService<Student> {
    @Override
    public Student create(Student student) throws IOException {
        return null;
    }

    @Override
    public Student getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<Student> getList() throws IOException {
        return List.of();
    }
}
