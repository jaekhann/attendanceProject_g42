package uz.pdp.g42.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    T create(T t) throws IOException;
    T getById(UUID id) throws IOException;
//    boolean update(T t);
    boolean delete(UUID id) throws IOException;
    List<T> getList() throws IOException;
}
