package course.spring.myblogsapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("redirect:projects");
        registry.addViewController("/").setViewName("redirect:index");
        registry.addViewController("/register");
        registry.addViewController("/group");
        registry.addViewController("/login");
        registry.addViewController("/admin");
        registry.addViewController("admin/allUsers");
        registry.addViewController("admin/user");
    }

}
