package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.AttendanceItemDto;
import uz.pdp.g42.model.AttendanceItem;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class AttendanceItemService implements BaseService<AttendanceItem> {
    private final AttendanceItemDto attendanceItemDto;

    @Override
    public AttendanceItem create(AttendanceItem attendanceItem) throws IOException {
        if (attendanceItem.getStudentId() == null) {
            return null;
        }

        attendanceItemDto.create(attendanceItem);
        // you can also return just 'true' value
        return getById(attendanceItem.getId());
        // return true;
    }

    @Override
    public AttendanceItem getById(UUID id) throws IOException {
        return attendanceItemDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        AttendanceItem attendanceItem;
        if (id == null || (attendanceItem = getById(id)) == null || !attendanceItem.isActive()) {
            return false;
        }

        attendanceItem.setActive(false);
        return true;
    }

    @Override
    public List<AttendanceItem> getList() throws IOException {
        return attendanceItemDto.list();
    }
}
