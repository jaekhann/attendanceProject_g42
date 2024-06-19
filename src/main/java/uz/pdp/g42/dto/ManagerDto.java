package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Manager;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class ManagerDto implements BaseDto<Manager> {
    private final FileService<Manager> fileService = new FileService<>();

    @Override
    public void create(Manager manager) throws IOException {
        fileService.write(manager, FilePath.MANAGERS_PATH, Manager[].class);
    }

    @Override
    public Optional<Manager> getById(UUID id) throws IOException {
        return list().stream().filter(manager -> id.equals(manager.getId())).findFirst();
    }

    @Override
    public List<Manager> list() throws IOException {
        return fileService.getList(FilePath.MANAGERS_PATH.getPath(), Manager[].class);
    }

    public void update(List<Manager> list) throws IOException {
        fileService.update(FilePath.MANAGERS_PATH, list);
    }
}

