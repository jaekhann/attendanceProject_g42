package uz.pdp.g42.dto;

import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.ScheduleItem;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ScheduleItemDto implements BaseDto<ScheduleItem>{
    private final FileService<ScheduleItem> fileService = new FileService<>();

    @Override
    public void create(ScheduleItem scheduleItem) throws IOException {
        fileService.write(scheduleItem, FilePath.SCHEDULE_ITEM_PATH, ScheduleItem[].class);
    }

    @Override
    public Optional<ScheduleItem> getById(UUID id) throws IOException {
        return list().stream().filter(scheduleItem -> id.equals(scheduleItem.getId())).findFirst();
    }

    @Override
    public List<ScheduleItem> list() throws IOException {
        return fileService.getList(FilePath.SCHEDULE_ITEM_PATH.getPath(), ScheduleItem[].class);
    }
//    @Override
//    public void update(List<ScheduleItem> list) throws IOException {
//        fileService.update(FilePath.SCHEDULE_ITEM_PATH, list);
//    }
}
