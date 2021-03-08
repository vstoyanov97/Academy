package course.spring.myblogsapp.service;

import course.spring.myblogsapp.entity.User;
import course.spring.myblogsapp.entity.dto.UsersDto.UserRegisterDto;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface UserService {
    List<User>  getAllUsers();
    User  getUserById(Long id);
    User getUserByUsername(String username);
    User addUser(@Valid User post);
    User updateUser(@Valid User post);
    User deleteUser(Long id);
    User getUserByEmail(String email);
    long getUsersCount();
    Optional<User>findUserByUsername(String username);
    Optional<User>findUserByEmail(String email);

    boolean emailExist(String email);
    boolean usernameExist(String username);

    User registerUser(@Valid UserRegisterDto userRegisterDto);

}
