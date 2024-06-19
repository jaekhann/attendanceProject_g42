package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.AttendanceItem;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class AttendanceItemDto implements BaseDto<AttendanceItem> {
    private final FileService<AttendanceItem> fileService = new FileService<>();

    @Override
    public void create(AttendanceItem attendanceItem) throws IOException {
        fileService.write(attendanceItem, FilePath.ATTENDANCE_ITEMS_PATH, AttendanceItem[].class);
    }

    @Override
    public Optional<AttendanceItem> getById(UUID id) throws IOException {
        return list().stream().filter(attendanceItem -> id.equals(attendanceItem.getId())).findFirst();
    }

    @Override
    public List<AttendanceItem> list() throws IOException {
        return fileService.getList(FilePath.ATTENDANCE_ITEMS_PATH.getPath(), AttendanceItem[].class);
    }

    public void update(List<AttendanceItem> list) throws IOException {
        fileService.update(FilePath.ATTENDANCE_ITEMS_PATH, list);
    }
}
