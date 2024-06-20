package uz.pdp.g42.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.g42.model.enums.WeekDays;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleItem extends BaseModel {
    private UUID subjectId;
    private WeekDays[] lessonDays;
    private String[] lessonTimes;
}
