package course.spring.myblogsapp.web;

import course.spring.myblogsapp.entity.User;
import course.spring.myblogsapp.entity.dto.UsersDto.UserLoginDto;
import course.spring.myblogsapp.entity.dto.UsersDto.UserRegisterDto;
import course.spring.myblogsapp.exception.InvalidEntityDataException;
import course.spring.myblogsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticator;


    @Autowired
    public UserController(UserService userService,AuthenticationManager authenticator) {
        this.userService = userService;
        this.authenticator=authenticator;


    }

   @GetMapping("/register")
   public String register(@ModelAttribute UserRegisterDto user, Model model){
   model.addAttribute("userDto", user);
   return "/register";
   }

   @PostMapping("/register")
   public String register(@Valid  UserRegisterDto userDto, BindingResult bindingResult ){

        if(userService.emailExist(userDto.getEmail())){
            bindingResult.addError(new
                    FieldError( "userDto","email","Email address already in use"));

        }
        if(userService.usernameExist(userDto.getUsername())){

            bindingResult.addError(new
                    FieldError( "userDto","username","username address already in use"));

        }

        if(userDto.getPassword()!=null && userDto.getConfirmPassword()!=null){
            if(!userDto.getPassword().equals(userDto.getConfirmPassword()))
            {
                bindingResult.addError(new
                        FieldError( "userDto","password","password must match"));

            }
        }

        if(bindingResult.hasErrors()){

            return "redirect:/register";
        }


        userService.registerUser(userDto);

       return "redirect:index";
   }

    @GetMapping("/login")
    public String home(@ModelAttribute UserLoginDto user, Model model) {
        model.addAttribute("loginDto", new UserLoginDto());

        return "/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginDto")   UserLoginDto user, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors()){

            throw new InvalidEntityDataException("Invalid username or password");
        }
        Authentication authentication =    authenticator.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()));


        final User loginUser=this.userService.getUserByUsername(user.getUsername());



        return   "redirect:index";


    }

    @PostMapping(value = "/logout")
    public String logout() {
        return "";
    }

}
