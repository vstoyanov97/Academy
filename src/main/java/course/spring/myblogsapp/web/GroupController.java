package course.spring.myblogsapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GroupController {
    @GetMapping("/group")
    public String groups( Model model){


        return "/group";

    }
    @GetMapping("/group/create")
    public String createGroup( Model model){


        return "/group";

    }

}
