package uz.pdp.g42.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseModel {
    private String fullName;
    private int age;
    private UUID managerId;
    private UUID schoolId;
}
