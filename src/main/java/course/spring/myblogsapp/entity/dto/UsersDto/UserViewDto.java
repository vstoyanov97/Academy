package course.spring.myblogsapp.entity.dto.UsersDto;

import course.spring.myblogsapp.entity.Group;
import course.spring.myblogsapp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private Set<Role> roles=new HashSet();

    private Set<Group> groups = new HashSet<>();

}
