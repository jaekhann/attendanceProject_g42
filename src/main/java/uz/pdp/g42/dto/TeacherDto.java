package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Teacher;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TeacherDto implements BaseDto<Teacher> {
    private final FileService<Teacher> fileService = new FileService<>();

    @Override
    public void create(Teacher teacher) throws IOException {
        fileService.write(teacher, FilePath.TEACHERS_PATH, Teacher[].class);
    }

    @Override
    public Optional<Teacher> getById(UUID id) throws IOException {
        return fileService.getList(FilePath.TEACHERS_PATH.getPath(), Teacher[].class)
                .stream().filter(teacher -> id.equals(teacher.getId())).findFirst();
    }

    @Override
    public List<Teacher> list() throws IOException {
        return fileService.getList(FilePath.TEACHERS_PATH.getPath(), Teacher[].class);
    }

    public void update(List<Teacher> list) throws IOException {
        fileService.update(FilePath.TEACHERS_PATH, list);
    }
}

