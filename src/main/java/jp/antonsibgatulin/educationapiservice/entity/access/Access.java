package jp.antonsibgatulin.educationapiservice.entity.access;

import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import jp.antonsibgatulin.educationapiservice.entity.user.User;
import lombok.Data;

@Data
@Entity
@Table(name = "access_for_user")
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne
    private Item item;

    private Integer access_type;
}
