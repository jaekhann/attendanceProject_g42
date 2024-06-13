package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Student;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class StudentDto implements BaseDto<Student> {
    private final FileService<Student> fileService = new FileService<>();

    @Override
    public void create(Student student) throws IOException {
        fileService.write(student, FilePath.STUDENTS_PATH, Student[].class);
    }

    @Override
    public Optional<Student> getById(UUID id) throws IOException {
        return fileService.getList(FilePath.STUDENTS_PATH.getPath(), Student[].class)
                .stream().filter(student -> id.equals(student.getId())).findFirst();
    }

    @Override
    public List<Student> list() throws IOException {
        return fileService.getList(FilePath.STUDENTS_PATH.getPath(), Student[].class);
    }

    public void update(List<Student> list) throws IOException {
        fileService.update(FilePath.STUDENTS_PATH, list);
    }
}

