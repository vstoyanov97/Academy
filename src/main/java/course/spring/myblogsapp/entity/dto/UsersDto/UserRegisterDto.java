package course.spring.myblogsapp.entity.dto.UsersDto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterDto {

    @Size(min=2, max=20,message="invalid firstName")
    private String firstName;

    @Size(min=2, max=20,message = "invalid lastName")
    private String lastName;

    @Size(min=2, max=20,message="invalid username")
    private String username;


    @Email(message = "invalid email")
    private String email;

    @Size(min=4,message="Password length must be at least 4 characters")
    private String password;


    private String confirmPassword;

}
