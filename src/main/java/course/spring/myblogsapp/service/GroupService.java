package course.spring.myblogsapp.service;

import course.spring.myblogsapp.entity.Project;
import course.spring.myblogsapp.entity.Group;

import javax.validation.Valid;
import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group  getProjectById(Long id);
    Group addGroup(@Valid Group group);
    Group updateGroup(@Valid Group group);
    Group deleteGroup(Long id);
    long getGroupCount();
}
