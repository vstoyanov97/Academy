package course.spring.myblogsapp.web;

import course.spring.myblogsapp.entity.User;
import course.spring.myblogsapp.entity.dto.UsersDto.UserViewDto;
import course.spring.myblogsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping(method = RequestMethod.GET)
    public String admin(){

        
        return "/admin";

    }
    @GetMapping("/admin/groups")
    public String getAllGroups( Model model){



        return "/admin/groups";

    }

    @PostMapping("/admin/groups/createGroup")
    @Transactional
    public String addGroup( Model model){



        return "/admin/groups";

    }



    @RequestMapping(method = RequestMethod.GET,value="allUsers")
    public String allUsers( Model model){

        List<UserViewDto> allUsers=new ArrayList<UserViewDto>();


        for (User user : this.userService.getAllUsers())
        {

            UserViewDto tempUser=new UserViewDto();
            tempUser.setUsername(user.getUsername());
            tempUser.setId(user.getId());

            allUsers.add(tempUser);

        }

        model.addAttribute("userDto",allUsers);
        model.addAttribute("path", "admin/allUsers");


        return "admin/allUsers";

    }

    @RequestMapping(method = RequestMethod.GET,value="allUsers/{userID}")
    public String User( Model model,@PathVariable long userID){

        UserViewDto user=new UserViewDto();

        User tempUser=this.userService.getUserById(userID);

        user.setUsername(tempUser.getUsername());
        user.setGroups(tempUser.getGroups());
        user.setRoles(tempUser.getRoles());
        user.setFirstName(tempUser.getFirstName());
        user.setLastName(tempUser.getLastName());
        user.setEmail(tempUser.getEmail());


        model.addAttribute("userDto",user);
        model.addAttribute("path", "admin/user");


        return "admin/user";

    }


}
