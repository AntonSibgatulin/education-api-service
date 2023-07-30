package jp.antonsibgatulin.educationapiservice.entity.teacher;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String last_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    @JoinColumn(name = "user_id",unique = true,nullable = false)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Experience> experienceList;


    public Teacher(String last_name, User user) {
        this.last_name = last_name;
        this.user = user;
    }
}
