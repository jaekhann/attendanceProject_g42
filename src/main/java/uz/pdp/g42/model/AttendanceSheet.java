package uz.pdp.g42.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceSheet extends BaseModel {
    private UUID schoolId;
    private UUID groupId;
    private UUID subjectId;
    private UUID teacherId;
    private String date;
    private List<AttendanceItem> studentsAttendance;
}
