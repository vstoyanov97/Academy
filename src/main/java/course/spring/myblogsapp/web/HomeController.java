package course.spring.myblogsapp.web;


import course.spring.myblogsapp.exception.InvalidEntityDataException;
import course.spring.myblogsapp.entity.User;
import course.spring.myblogsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("index")
public class HomeController  {

    private final UserService userService;




    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String home(Model model) {


        return "index";
    }



}
