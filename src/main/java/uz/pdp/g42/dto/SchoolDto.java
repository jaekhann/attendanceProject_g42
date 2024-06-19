package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.School;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class SchoolDto implements BaseDto<School> {
    private final FileService<School> fileService = new FileService<>();

    @Override
    public void create(School school) throws IOException {
        fileService.write(school, FilePath.SCHOOLS_PATH, School[].class);
    }

    @Override
    public Optional<School> getById(UUID id) throws IOException {
        return list().stream().filter(school -> id.equals(school.getId())).findFirst();
    }

    @Override
    public List<School> list() throws IOException {
        return fileService.getList(FilePath.SCHOOLS_PATH.getPath(), School[].class);
    }

    public void update(List<School> list) throws IOException {
        fileService.update(FilePath.SCHOOLS_PATH, list);
    }
}

