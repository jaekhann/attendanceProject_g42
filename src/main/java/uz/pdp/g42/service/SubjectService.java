package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.SubjectDto;
import uz.pdp.g42.model.Subject;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class SubjectService implements BaseService<Subject> {
    private final SubjectDto subjectDto;

    @Override
    public Subject create(Subject subject) throws IOException {
        if (subject == null ||
                subject.getSchoolId() == null ||
                subject.getName().isEmpty()) {
            return null;
        }

        subjectDto.create(subject);
        return getById(subject.getId());
    }

    @Override
    public Subject getById(UUID id) throws IOException {
        return subjectDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        Subject subject;
        if (id == null || (subject = getById(id)) == null || !subject.isActive()) {
            return false;
        }

        subject.setActive(false);
        return true;
    }

    @Override
    public List<Subject> getList() throws IOException {
        return subjectDto.list();
    }
}
