package uz.pdp.g42.service;

import uz.pdp.g42.model.AttendanceSheet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class AttendanceSheetService implements BaseService<AttendanceSheet> {
    @Override
    public AttendanceSheet create(AttendanceSheet attendanceSheet) throws IOException {
        return null;
    }

    @Override
    public AttendanceSheet getById(UUID id) throws IOException {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        return false;
    }

    @Override
    public List<AttendanceSheet> getList() throws IOException {
        return List.of();
    }
}
