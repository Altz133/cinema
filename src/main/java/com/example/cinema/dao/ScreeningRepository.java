package com.example.cinema.dao;

import com.example.cinema.entity.Screening;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends CrudRepository<Screening,Integer> {
    Screening getScreeningsById(int id);

    @Query(value = "SELECT s.* FROM screening as s JOIN movies as m  ON s.movie_id = m.movie_id WHERE m.title= :title", nativeQuery = true)
    Optional<Iterable<Screening>> findByTitle(@Param("title")String title);


}
