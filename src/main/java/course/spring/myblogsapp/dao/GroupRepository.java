package course.spring.myblogsapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import course.spring.myblogsapp.entity.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
