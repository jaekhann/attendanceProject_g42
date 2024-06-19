package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Subject;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class SubjectDto implements BaseDto<Subject> {
    private final FileService<Subject> fileService;

    @Override
    public void create(Subject subject) throws IOException {
        fileService.write(subject, FilePath.SUBJECTS_PATH, Subject[].class);
    }

    @Override
    public Optional<Subject> getById(UUID id) throws IOException {
        return list().stream().filter(subject -> id.equals(subject.getId())).findFirst();
    }

    @Override
    public List<Subject> list() throws IOException {
        return fileService.getList(FilePath.SUBJECTS_PATH.getPath(), Subject[].class);
    }

    public void update(List<Subject> subjectList) throws IOException {
        fileService.update(FilePath.SUBJECTS_PATH, subjectList);
    }
}
