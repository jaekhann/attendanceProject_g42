package uz.pdp.g42.service;

import uz.pdp.g42.model.Schedule;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ScheduleService implements BaseService<Schedule> {
    @Override
    public Schedule create(Schedule schedule) throws IOException {
        return null;
    }

    @Override
    public Schedule getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<Schedule> getList() throws IOException {
        return List.of();
    }
}
