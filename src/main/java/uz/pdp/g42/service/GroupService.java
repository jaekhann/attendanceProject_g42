package uz.pdp.g42.service;

import lombok.RequiredArgsConstructor;
import uz.pdp.g42.dto.GroupDto;
import uz.pdp.g42.model.Group;



import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class GroupService implements BaseService<Group> {
    private final GroupDto groupDto;

     @Override
    public Group create(Group group) throws IOException {
         if (group.getId() != null ) {
             //  throw new IOException("Group id already exists or null");
             return null;
         }
         groupDto.create(group);
         return getById(group.getId());
     }

    @Override
    public Group getById(UUID id) throws IOException {
        return groupDto.getById(id).get();
    }

    @Override
    public boolean delete(UUID id) throws IOException {
        Group group;
        if(id == null || (group = getById(id)) == null || !group.isActive()) {
            return false;
        }
        group.setActive(false);
        return true;
    }

    @Override
    public List<Group> getList() throws IOException {
        return groupDto.list();
    }
}


