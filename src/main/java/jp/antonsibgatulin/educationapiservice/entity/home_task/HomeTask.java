package jp.antonsibgatulin.educationapiservice.entity.home_task;


import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.file.File;
import jp.antonsibgatulin.educationapiservice.entity.task.Task;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class HomeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Task task;

    @JoinTable
    @ManyToMany
    private List<File> file;
    private String name;
    private String description;

    //@ManyToOne
    //@JoinColumn
    //private Grade grade;

    @JoinColumn
    @ManyToOne
    private User user;

}
