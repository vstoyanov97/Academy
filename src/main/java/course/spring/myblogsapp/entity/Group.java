package course.spring.myblogsapp.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Group extends BaseEntity {

    @NonNull
    @NotNull
    @Size(min=2, max=60)
    private String name;

    @NonNull
    @NotNull
    @Size(min=2, max=10000)
    private String content;



    @NotNull
    @PastOrPresent
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @NotNull
    @PastOrPresent
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified = new Date();

    @ManyToMany
    @JoinTable(
            name = "group_users",
            joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<User> students = new HashSet<>();

}
