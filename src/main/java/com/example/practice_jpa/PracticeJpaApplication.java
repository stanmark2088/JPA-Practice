package com.example.practice_jpa;
import com.example.practice_jpa.model.Episode;
import com.example.practice_jpa.model.Genre;
import com.example.practice_jpa.model.Season;
import com.example.practice_jpa.model.Series;
import com.example.practice_jpa.repository.EpisodeRepository;
import com.example.practice_jpa.repository.SeasonRepository;
import com.example.practice_jpa.repository.SeriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PracticeJpaApplication {

    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private SeasonRepository seasonRepository;
    @Autowired
    private EpisodeRepository episodeRepository;

//    private static final Logger log = LoggerFactory.getLogger(PracticeJpaApplication.class);


    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(PracticeJpaApplication.class, args);
        SeriesRepository seriesRepository = configurableApplicationContext.getBean(SeriesRepository.class);
    }


    @Bean
    public CommandLineRunner init() {
        return args -> {
            Episode episode1 = Episode.builder()
                    .name("Il clan dei Savastano")
                    .releaseDate(LocalDate.of(2014, 5, 6))
                    .genre(Genre.DRAMA)
                    .genre(Genre.COMEDY)
                    .build();
            Episode episode2 = Episode.builder()
                    .name("ITi fidi di me?")
                    .releaseDate(LocalDate.of(2014, 5, 6))
                    .genre(Genre.SF)
                    .genre(Genre.THRILLER)
                    .build();
            Episode episode3 = Episode.builder()
                    .name("L'om e casa")
                    .releaseDate(LocalDate.of(2014, 5, 13))
                    .genre(Genre.DOCUMENTARY)
                    .genre(Genre.COMEDY)
                    .build();
            Episode episode4 = Episode.builder()
                    .name("Sangue africano")
                    .releaseDate(LocalDate.of(2014, 2, 13))
                    .genre(Genre.HORROR)
                    .build();
            Episode episode5 = Episode.builder()
                    .name("Il rugitto della leonessa")
                    .releaseDate(LocalDate.of(2014, 5, 20))
                    .genre(Genre.DRAMA)
                    .build();

            Season season1 = Season.builder()
                    .seasonNumber(1)
                    .episode(episode1)
                    .episode(episode2)
                    .episode(episode3)
                    .build();

            Season season2 = Season.builder()
                    .seasonNumber(2)
                    .episode(episode4)
                    .build();

            Season season3 = Season.builder()
                    .seasonNumber(3)
                    .episode(episode5)
                    .build();

//            episode1.setSeason(season1);
//            episode2.setSeason(season1);
//            episode3.setSeason(season1);
//            episode4.setSeason(season2);
//            episode5.setSeason(season3);

            Series Gomorrah = Series.builder()
                    .name("Gomorrah")
                    .season(season1)
                    .season(season2)
                    .season(season3)
                    .build();

//            season1.setSeries(Gomorrah);
//            season2.setSeries(Gomorrah);
//            season3.setSeries(Gomorrah);

            seriesRepository.save(Gomorrah);







        };
    }
}
