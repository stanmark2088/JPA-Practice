package com.example.practice_jpa.repository;

import com.example.practice_jpa.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode,Long> {

}
