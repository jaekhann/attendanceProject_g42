package uz.pdp.g42.service;

import uz.pdp.g42.model.Teacher;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class TeacherService implements BaseService<Teacher> {
    @Override
    public Teacher create(Teacher teacher) throws IOException {
        return null;
    }

    @Override
    public Teacher getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<Teacher> getList() throws IOException {
        return List.of();
    }
}
