package com.example.practice_jpa.model;


import lombok.*;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Episode")
public class Episode {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate releaseDate;

    @Transient
    private int daysSinceRelease;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Singular
    private List<Genre> genres =  new ArrayList<>();

    public void calculateDaysSinceRelease(){
        if(releaseDate != null){
            daysSinceRelease = (int) ChronoUnit.YEARS.between(releaseDate,LocalDate.now());
        }
    }


}
