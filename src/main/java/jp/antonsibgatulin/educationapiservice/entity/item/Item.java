package jp.antonsibgatulin.educationapiservice.entity.item;


import jakarta.persistence.*;
import jp.antonsibgatulin.educationapiservice.entity.tag.Tag;
import jp.antonsibgatulin.educationapiservice.entity.teacher.Teacher;
import jp.antonsibgatulin.educationapiservice.enums.TypeItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

@NoArgsConstructor
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    private Integer price;
    private Integer number_of_students;
    private Integer seats_left;
    private Long timeStart;
    private Long timeEnd;
    @ManyToMany
    @JoinTable
    private List<Tag> tags;
    private Long timeCreate;
    private Long view;
    private Double rating; // -/5
    private Long count_voice;
    @Enumerated(EnumType.STRING)
    private TypeItem type;


    public Item(String name, String description, Teacher teacher, Integer price, Integer number_of_students, Integer seats_left, List<Tag> tags, TypeItem type) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.price = price;
        this.number_of_students = number_of_students;
        this.seats_left = seats_left;
        this.tags = tags;
        this.type = type;
        init();
    }


    public Item(String name, String description, Teacher teacher, Integer price, Integer number_of_students, List<Tag> tags) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.price = price;
        this.number_of_students = number_of_students;
        this.tags = tags;
        init();
    }

    public void init(){
        create();
    }
    public void create(){
        timeCreate = System.currentTimeMillis();
        timeStart = timeCreate;
        timeEnd = timeCreate + 1000*60*60*24*31;
        view = 0L;
        rating = 0.0;
        count_voice = 0L;
        type = TypeItem.DEF;
    }

    public void createTest() {
        create();
        view = new Random().nextLong(10000000);
        rating = 1.0+new Random().nextDouble(5,1);
        count_voice = new Random().nextLong(view);

    }
}
