package uz.pdp.g42.service;

import uz.pdp.g42.model.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherService implements BaseService<Teacher> {
    private final List<Teacher> teachers = new ArrayList<>();

    private static TeacherService teacherService;

    public static TeacherService getInstance() {
        if (teacherService == null) {
            teacherService = new TeacherService();
        }
        return teacherService;
    }

    @Override
    public Teacher create(Teacher teacher) {
        teacher.setId(UUID.randomUUID());
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public Teacher getById(UUID id) throws IOException {
        return teachers.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IOException("Teacher not found"));
    }

    @Override
    public boolean delete(UUID id) {
        Teacher teacher = teachers.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (teacher == null || !teacher.isActive()) {
            return false;
        }

        teacher.setActive(false);
        return true;
    }

    @Override
    public List<Teacher> getList() {
        return teachers;
    }
}
