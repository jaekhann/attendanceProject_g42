package uz.pdp.g42.service;

import com.google.gson.Gson;
import uz.pdp.g42.dto.enums.FilePath;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService<T> {
    static final Gson gson = new Gson();

    public void write(T t, FilePath filePath, Class<T[]> clazz) throws IOException {
        List<T> list = read(filePath, clazz);
        list.add(t);

        try (
                FileWriter fileWriter = new FileWriter(filePath.getPath());
        ) {
            fileWriter.write(gson.toJson(list));
        }
    }

    public void update(FilePath filePath, List<T> list) throws IOException {
        try (
                FileWriter fileWriter = new FileWriter(filePath.getPath());
        ) {
            fileWriter.write(gson.toJson(list));
        }
    }

    public List<T> read(FilePath filePath, Class<T[]> clazz) throws IOException {
        return getList(filePath.getPath(), clazz);
    }

    public List<T> getList(String filePath, Class<T[]> clazz) throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
        ) {
            byte[] bytes = fileInputStream.readAllBytes();
            String jsonString = new String(bytes);
            T[] ts = gson.fromJson(jsonString, clazz);
            List<T> list = new ArrayList<>();
            for (int i = 0; i < ts.length; i++) {
                list.add(ts[i]);
            }
            return list;
        }
    }
}
