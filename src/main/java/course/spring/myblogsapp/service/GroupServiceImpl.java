package course.spring.myblogsapp.service;

import course.spring.myblogsapp.dao.GroupRepository;
import course.spring.myblogsapp.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;

    @Autowired
    GroupServiceImpl(GroupRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Group> getAllGroups() {
        return null;
    }

    @Override
    public Group getProjectById(Long id) {
        return null;
    }

    @Override
    public Group addGroup(@Valid Group group) {
        return null;
    }

    @Override
    public Group updateGroup(@Valid Group group) {
        return null;
    }

    @Override
    public Group deleteGroup(Long id) {
        return null;
    }

    @Override
    public long getGroupCount() {
        return 0;
    }
}
