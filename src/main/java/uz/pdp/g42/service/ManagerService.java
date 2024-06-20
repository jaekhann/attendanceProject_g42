package uz.pdp.g42.service;

import uz.pdp.g42.dto.ManagerDto;
import uz.pdp.g42.model.Manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManagerService implements BaseService<Manager> {
    private static ManagerDto managerDto;

    @Override
    public Manager create(Manager manager) throws IOException {
        if(manager.getUsername() == null ||
                manager.getPassword() == null ||
                manager.getName() == null) {
            //throw new IOException("Username and password are required");
            return null;
        }
        managerDto.create(manager);
        return getById(manager.getId());

    }

    @Override
    public Manager getById(UUID id) throws IOException {
       return managerDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
       Manager manager;
       if(id == null || (manager = getById(id)) == null || !manager.isActive()){
           return false;
       }
        manager.setActive(false);
        return true;
    }

    @Override
    public List<Manager> getList() throws IOException {
        return managerDto.list();
    }
}
