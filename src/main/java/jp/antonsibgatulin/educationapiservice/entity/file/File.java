package jp.antonsibgatulin.educationapiservice.entity.file;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private User user;
    private String name;

    private String file;

}
