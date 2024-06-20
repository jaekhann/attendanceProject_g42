package uz.pdp.g42.service;

import uz.pdp.g42.model.ScheduleItem;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ScheduleItemService implements BaseService<ScheduleItem> {
    @Override
    public ScheduleItem create(ScheduleItem scheduleItem) throws IOException {
        return null;
    }

    @Override
    public ScheduleItem getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<ScheduleItem> getList() throws IOException {
        return List.of();
    }
}
