package course.spring.myblogsapp.service;

import course.spring.myblogsapp.dao.UserRepository;
import course.spring.myblogsapp.entity.User;
import course.spring.myblogsapp.entity.dto.UsersDto.UserRegisterDto;
import course.spring.myblogsapp.exception.InvalidEntityDataException;
import course.spring.myblogsapp.exception.NonExisitingEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional()
@Validated
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;



    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(
                () -> new NonExisitingEntityException(
                        String.format("User with ID='%d' does not exists", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow( () ->
                new InvalidEntityDataException("Invalid username or password."));
    }

    @Override
    @Transactional
    public User addUser(@Valid User user) {
        user.setId(null);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String passwordHash= encoder.encode(user.getPassword());

        user.setPassword(passwordHash);

        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User updateUser(@Valid User user) {
        User old = getUserById(user.getId());
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User deleteUser(Long id) {
        User deleted = getUserById(id);
        userRepo.deleteById(id);
        return deleted;
    }

    @Override
    public User getUserByEmail(String email) {
      User user= this.userRepo.findByEmail(email).orElseThrow( () ->
              new InvalidEntityDataException("Invalid Email"));
      return user;
    }

    @Override
    public long getUsersCount() {
        return userRepo.count();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {

        return this.userRepo.findByUsername(username);

    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }


    public boolean usernameExist(String username)
    {

      if(findUserByUsername(username).isPresent()){
          return true;
      }
      return  false;
    }

    @Override
    public User registerUser(@Valid UserRegisterDto userRegisterDto) {



        User user=new User(userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),userRegisterDto.getEmail(),userRegisterDto.getUsername(),userRegisterDto.getPassword());






        this.addUser(user);
        return user;
    }

    public boolean emailExist(String email)
    {

        if(findUserByEmail(email).isPresent()){
            return true;
        }
        return  false;
    }
}
