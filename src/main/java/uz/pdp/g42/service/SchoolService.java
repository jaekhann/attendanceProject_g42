package uz.pdp.g42.service;

import uz.pdp.g42.model.School;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SchoolService implements BaseService<School> {
    private final List<School> schools = new ArrayList<>();

    @Override
    public School create(School school) {
        school.setId(UUID.randomUUID());
        schools.add(school);
        return school;
    }

    @Override
    public School getById(UUID id) throws IOException {
        return schools.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IOException("School not found"));
    }

    @Override
    public boolean delete(UUID id) {
        return schools.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<School> getList() {
        return schools;
    }

    public School update(UUID id, School updatedSchool) throws IOException {
        School existingSchool = getById(id);
        existingSchool.setManagerId(updatedSchool.getManagerId());
        existingSchool.setName(updatedSchool.getName());
        existingSchool.setSpecialization(updatedSchool.getSpecialization());
        return existingSchool;
    }
}