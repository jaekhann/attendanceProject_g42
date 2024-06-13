package uz.pdp.g42.dto;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.enums.FilePath;
import uz.pdp.g42.model.AttendanceSheet;
import uz.pdp.g42.service.FileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class AttendanceSheetDto implements BaseDto<AttendanceSheet> {
    private final FileService<AttendanceSheet> fileService = new FileService<>();

    @Override
    public void create(AttendanceSheet attendanceSheet) throws IOException {
        fileService.write(attendanceSheet, FilePath.ATTENDANCE_SHEETS_PATH, AttendanceSheet[].class);
    }

    @Override
    public Optional<AttendanceSheet> getById(UUID id) throws IOException {
        return fileService.getList(FilePath.ATTENDANCE_SHEETS_PATH.getPath(), AttendanceSheet[].class)
                .stream().filter(attendanceSheet -> id.equals(attendanceSheet.getId())).findFirst();
    }

    @Override
    public List<AttendanceSheet> list() throws IOException {
        return fileService.getList(FilePath.ATTENDANCE_SHEETS_PATH.getPath(), AttendanceSheet[].class);
    }

    public void update(List<AttendanceSheet> list) throws IOException {
        fileService.update(FilePath.ATTENDANCE_SHEETS_PATH, list);
    }
}

