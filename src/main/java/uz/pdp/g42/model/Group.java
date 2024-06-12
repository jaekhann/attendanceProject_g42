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
public class Group extends BaseModel {
    private String groupNumber;
    private UUID subjectId;
    private UUID schoolId;
}
