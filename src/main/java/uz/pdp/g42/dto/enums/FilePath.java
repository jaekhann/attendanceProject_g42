package uz.pdp.g42.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FilePath {
    ATTENDANCE_ITEMS_PATH("json/attendanceItems.json"),
    ATTENDANCE_SHEETS_PATH("json/attendanceSheets.json"),
    GROUPS_PATH("json/groups.json"),
    MANAGERS_PATH("json/managers.json"),
    SCHEDULE_PATH("json/schedules.json"),
    SCHEDULE_ITEM_PATH("json/scheduleItems.json"),
    SCHOOLS_PATH("json/schools.json"),
    STUDENTS_PATH("json/students.json"),
    SUBJECTS_PATH("json/subjects.json"),
    TEACHERS_PATH("json/teachers.json");

    private final String path;
}
