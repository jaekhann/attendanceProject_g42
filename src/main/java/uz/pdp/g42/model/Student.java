package uz.pdp.g42.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseModel {
    private String fullName;
    private String phoneNumber;
    private UUID groupId;
    private UUID subjectId;
    private UUID teacherId;
}
