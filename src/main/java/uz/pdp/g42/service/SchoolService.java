package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.SchoolDto;
import uz.pdp.g42.model.School;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class SchoolService implements BaseService<School> {
    private final SchoolDto schoolDto;


    @Override
    public School create(School school) throws IOException {
        if(school.getManagerId() == null ||
                school.getName() == null ||
                school.getSpecialization() == null){
            return null;
        }
        schoolDto.create(school);
        return getById(school.getId());
    }

    @Override
    public School getById(UUID id) throws IOException {
        return schoolDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        School school;
       if(id == null || (school = getById(id)) == null || !school.isActive()){
           return false;
       }
       school.setActive(false);
       return true;
    }

    @Override
    public List<School> getList() throws IOException {
        return schoolDto.list();
    }
}