package jp.antonsibgatulin.educationapiservice.entity.task;

import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.file.File;
import jp.antonsibgatulin.educationapiservice.entity.post_item.PostItem;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinTable
    @ManyToMany
    private List<File> files;

    @JoinColumn
    @ManyToOne
    private PostItem postItem;

    private String name;
    private String description;


}
