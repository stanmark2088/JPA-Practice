package com.example.practice_jpa.model;
import com.example.practice_jpa.model.Episode;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Season")
public class Season {

        @Id
        @GeneratedValue
        private Long id;
        private int seasonNumber;

        @ManyToOne
        @JoinColumn(name = "series_id")
        private Series series;

        @Singular
        @OneToMany(
                fetch = FetchType.EAGER,
                mappedBy = "season",
                cascade =  CascadeType.ALL,
                orphanRemoval = true
        )
        private List<Episode> episodes = new ArrayList<>();

}
