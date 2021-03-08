package course.spring.myblogsapp.entity.dto.UsersDto;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    @Size(min=2, max=20,message="invalid username")
    private String username;

    @Size(min=4,message="Password length must be at least 4 characters")
    private String password;


}
