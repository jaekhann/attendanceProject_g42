package uz.pdp.g42.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FilePath {
    ATTENDANCE_ITEMS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/attendanceItems.json"),
    ATTENDANCE_SHEETS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/attendanceSheets.json"),
    GROUPS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/groups.json"),
    MANAGERS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/managers.json"),
    SCHOOLS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/schools.json"),
    STUDENTS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/students.json"),
    TEACHERS_PATH("/Users/jaxongir/Desktop/AttendanceProject/projectAttendance/json/teachers.json");

    private final String path;
}
