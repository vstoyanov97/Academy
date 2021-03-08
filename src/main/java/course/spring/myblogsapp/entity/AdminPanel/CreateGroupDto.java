package course.spring.myblogsapp.entity.AdminPanel;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupDto {

    @Size(min=2, max=60)
    private String name;


    @Size(min=2, max=10000)
    private String content;
    

    private String teacherUsername;

}
