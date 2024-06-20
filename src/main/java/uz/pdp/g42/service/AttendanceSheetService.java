package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.AttendanceItemDto;
import uz.pdp.g42.dto.AttendanceSheetDto;
import uz.pdp.g42.model.AttendanceSheet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
public class AttendanceSheetService implements BaseService<AttendanceSheet> {
    private AttendanceSheetDto attendanceSheetDto;
    @Override
    public AttendanceSheet create(AttendanceSheet attendanceSheet) throws IOException {
        if (attendanceSheet.getSchoolId() == null ||
                attendanceSheet.getGroupId() == null ||
                attendanceSheet.getTeacherId() == null) {
            return null;
        }

        attendanceSheetDto.create(attendanceSheet);
        return getById(attendanceSheet.getId());
    }

    @Override
    public AttendanceSheet getById(UUID id) throws IOException {
        return attendanceSheetDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        AttendanceSheet attendanceSheet;
        if (id == null || (attendanceSheet = getById(id)) == null || !attendanceSheet.isActive()) {
            return false;
        }

        attendanceSheet.setActive(false);
        return true;
    }

    @Override
    public List<AttendanceSheet> getList() throws IOException {
        return attendanceSheetDto.list();
    }
}
