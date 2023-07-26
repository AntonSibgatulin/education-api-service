package jp.antonsibgatulin.educationapiservice.entity.post_item;

import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.item.Item;
import lombok.Data;

@Data
@Entity
public class PostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String attempting;
    private String name_task;
    private String link_;
    @Column(name = "like_")
    private Integer like;
    private Integer dislike;

    @JoinColumn
    @ManyToOne
    private Item item;

}
