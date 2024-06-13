package uz.pdp.g42.service;

import uz.pdp.g42.model.Group;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class GroupService implements BaseService<Group> {
    @Override
    public Group create(Group group) throws IOException {
        return null;
    }

    @Override
    public Group getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<Group> getList() throws IOException {
        return List.of();
    }
}
