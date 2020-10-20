package com.example.practice_jpa.model;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data //generates getters setters hashcode toString constructor
@NoArgsConstructor // empty constr
@AllArgsConstructor // constr with args
@Builder// replaces setters
@Entity
@Table(name = "Series")

public class Series {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Singular
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "series",
            cascade =  CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Season> seasons = new ArrayList<>();


}