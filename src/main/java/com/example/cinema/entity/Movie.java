package com.example.cinema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="movies")
@ToString
public @Data class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int id;

    @OneToMany(mappedBy = "movie_id")
    @ToString.Exclude
    private List<Screening> ScreeningList;

    @Column(name="title")
    @NotEmpty
    private String title;

    @Column(name="movie_length")
    @NotEmpty
    private String length;

    @Column(name="description")
    @NotEmpty
    private String description;
    @Column(name="main_actors")
    @NotEmpty
    private String mainActors;

    @Column(name="poster")
    @NotEmpty
    private String poster;

    public Movie(String title, String length, String description) {
        this.title = title;
        this.length = length;
        this.description = description;
    }
    public Movie() {
    }


}
