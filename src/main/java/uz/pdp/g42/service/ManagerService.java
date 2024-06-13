package uz.pdp.g42.service;

import uz.pdp.g42.model.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManagerService implements BaseService<Manager> {
    private final List<Manager> managers = new ArrayList<>();

    private static ManagerService managerService;

    public static ManagerService getInstance() {
        if (managerService == null) {
            managerService = new ManagerService();
        }
        return managerService;
    }

    @Override
    public Manager create(Manager manager) {
        manager.setId(UUID.randomUUID());
        managers.add(manager);
        return manager;
    }

    @Override
    public Manager getById(UUID id) throws IOException {
        return managers.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IOException("Manager not found"));
    }

    @Override
    public boolean delete(UUID id) {
        Manager manager = managers.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (manager == null || !manager.isActive()) {
            return false;
        }

        manager.setActive(false);
        return true;
    }

    @Override
    public List<Manager> getList() {
        return managers;
    }
}
