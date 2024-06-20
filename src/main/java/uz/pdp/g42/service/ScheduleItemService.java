package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.ScheduleItemDto;
import uz.pdp.g42.model.ScheduleItem;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class ScheduleItemService implements BaseService<ScheduleItem> {
    private final ScheduleItemDto scheduleItemDto;
    @Override
    public ScheduleItem create(ScheduleItem scheduleItem) throws IOException {
        if(scheduleItem.getId() == null ||
                scheduleItem.getLessonDays() == null ||
                scheduleItem.getLessonTimes() == null ||
                scheduleItem.getSubjectId() == null) {
            return null;
        }
        scheduleItemDto.create(scheduleItem);
        return getById(scheduleItem.getId());
    }

    @Override
    public ScheduleItem getById(UUID id) throws IOException {
        return scheduleItemDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        ScheduleItem scheduleItem;
        if(id == null || (scheduleItem = getById(id)) == null || !scheduleItem.isActive()) {
            return false;
        }
        scheduleItem.setActive(false);
        return true;
    }

    @Override
    public List<ScheduleItem> getList() throws IOException {
        return scheduleItemDto.list();
    }
}
