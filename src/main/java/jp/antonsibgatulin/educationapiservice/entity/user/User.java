package jp.antonsibgatulin.educationapiservice.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(16)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(16)")
    private String surname;

    @Column(unique = true)
    private String email;

    private Long timeReg;
    private Long online;
    private String phone;

    private Long profileImageId;


    private String password;

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }


    public void create() {
        timeReg = System.currentTimeMillis();
        online = timeReg;
    }
    //likes
}
