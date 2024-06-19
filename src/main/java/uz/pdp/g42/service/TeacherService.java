package uz.pdp.g42.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.TeacherDto;
import uz.pdp.g42.model.Teacher;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TeacherService implements BaseService<Teacher> {
    private final TeacherDto teacherDto;

    @Override
    public Teacher create(Teacher teacher) throws IOException {
        if( teacher.getFullName() == null || teacher.getManagerId() == null || teacher.getSchoolId() == null || teacher.getAge() == 0 ){
            return null;
        }
        teacherDto.create(teacher);
        return getById(teacher.getId());

    }

    @Override
    public Teacher getById(UUID id) throws IOException {
        return teacherDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        Teacher teacher;
        if(id == null || (teacher = getById(id)) == null || teacher.isActive()){

            return false;
        }
        teacher.setActive(false);
        return true;
    }

    @Override
    public List<Teacher> getList() throws IOException {
        return teacherDto.list();
    }
}
