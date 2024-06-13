package uz.pdp.g42.service;

import uz.pdp.g42.model.School;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class SchoolService implements BaseService<School> {
    @Override
    public School create(School school) throws IOException {
        return null;
    }

    @Override
    public School getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<School> getList() throws IOException {
        return List.of();
    }
}
