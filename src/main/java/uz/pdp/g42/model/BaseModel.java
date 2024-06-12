package uz.pdp.g42.model;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class BaseModel {
    protected UUID id;
    protected boolean isActive;

    public BaseModel() {
        this.id = UUID.randomUUID();
    }
}
