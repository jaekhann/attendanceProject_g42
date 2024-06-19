package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.StudentDto;
import uz.pdp.g42.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {
    private final StudentDto studentDto;


    @Override
    public Student create(Student student) throws IOException {
        if(student.getFullName() == null ||
                student.getGroupId() == null ||
                student.getPhoneNumber() == null ||
                student.getTeacherId() == null ||
                student.getSubjectId() == null){
            return null;
        }
        studentDto.create(student);
        return getById(student.getId());

    }

    @Override
    public Student getById(UUID id) throws IOException {
        return studentDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        Student student;
        if(id == null || (student = getById(id)) == null || student.isActive()){
            return false;
        }
        student.setActive(false);
        return true;
    }

    @Override
    public List<Student> getList() throws IOException {
        return studentDto.list();
    }
}
