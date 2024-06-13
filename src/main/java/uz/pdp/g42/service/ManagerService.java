package uz.pdp.g42.service;

import uz.pdp.g42.model.Manager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ManagerService implements BaseService<Manager> {
    @Override
    public Manager create(Manager manager) throws IOException {
        return null;
    }

    @Override
    public Manager getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<Manager> getList() throws IOException {
        return List.of();
    }
}
