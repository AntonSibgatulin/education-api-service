package jp.antonsibgatulin.educationapiservice.entity.teacher;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "expirience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer number_of_year;

    public Experience(String description, Integer number_of_year) {
        this.description = description;
        this.number_of_year = number_of_year;
    }
}
