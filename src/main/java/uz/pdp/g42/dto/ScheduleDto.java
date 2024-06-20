package uz.pdp.g42.dto;

import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.Manager;
import uz.pdp.g42.model.Schedule;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ScheduleDto implements BaseDto<Schedule> {
    private final FileService<Schedule> fileService = new FileService<>();

    @Override
    public void create(Schedule schedule) throws IOException {
        fileService.write(schedule, FilePath.SCHEDULE_PATH, Schedule[].class);
    }

    @Override
    public Optional<Schedule> getById(UUID id) throws IOException {
        return list().stream().filter(schedule -> id.equals(schedule.getId())).findFirst();
    }

    @Override
    public List<Schedule> list() throws IOException {
        return fileService.getList(FilePath.SCHEDULE_PATH.getPath(), Schedule[].class);
    }
}