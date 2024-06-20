package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.ScheduleDto;
import uz.pdp.g42.model.Schedule;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class ScheduleService implements BaseService<Schedule> {
    private final ScheduleDto scheduleDto;
    @Override
    public Schedule create(Schedule schedule) throws IOException {
        if(schedule.getId() == null ||
                schedule.getGroupId() == null ||
                schedule.getSubjects() == null) {
            return null;
        }
        scheduleDto.create(schedule);
        return getById(schedule.getId());
    }

    @Override
    public Schedule getById(UUID id) throws IOException {
        return scheduleDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        Schedule schedule;
        if(id == null || (schedule = getById(id)) == null || !schedule.isActive()) {
            return false;
        }
        schedule.setActive(false);
        return true;
    }

    @Override
    public List<Schedule> getList() throws IOException {
        return scheduleDto.list();
    }
}
