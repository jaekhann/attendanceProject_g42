package uz.pdp.g42.dto;

import uz.pdp.g42.model.ScheduleItem;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseDto<T> {
    void create(T t) throws IOException;
    Optional<T> getById(UUID id) throws IOException;
    List<T> list() throws IOException;
   // void update(List<ScheduleItem> list) throws IOException;
}