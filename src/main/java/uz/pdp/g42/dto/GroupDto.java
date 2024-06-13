package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Group;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class GroupDto implements BaseDto<Group> {
    private final FileService<Group> fileService = new FileService<>();

    @Override
    public void create(Group group) throws IOException {
        fileService.write(group, FilePath.GROUPS_PATH, Group[].class);
    }

    @Override
    public Optional<Group> getById(UUID id) throws IOException {
        return fileService.getList(FilePath.GROUPS_PATH.getPath(), Group[].class)
                .stream().filter(group -> id.equals(group.getId())).findFirst();
    }

    @Override
    public List<Group> list() throws IOException {
        return fileService.getList(FilePath.GROUPS_PATH.getPath(), Group[].class);
    }

    public void update(List<Group> list) throws IOException {
        fileService.update(FilePath.GROUPS_PATH, list);
    }
}

