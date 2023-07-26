package jp.antonsibgatulin.educationapiservice.entity.like;

import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import lombok.Data;

@Data
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long objectId;
    private Long time;
    @Column(unique = true)
    private String type;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}
