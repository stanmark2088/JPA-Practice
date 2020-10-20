package com.example.practice_jpa.repository;

import com.example.practice_jpa.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series,Long> {

}
