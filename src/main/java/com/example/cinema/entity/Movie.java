package com.example.cinema.entity;

import jakarta.persistence.*;
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
    private List<Seance> seanceList;

    @Column(name="title")
    private String title;

    @Column(name="movie_length")
    private String length;

    @Column(name="description")
    private String description;
    @Column(name="main_actors")
    private String mainActors;

    @Column(name="poster")
    private String poster;

    @Column(name="rating")
    private int raitng;


    public Movie(String title, String length, String description) {
        this.title = title;
        this.length = length;
        this.description = description;
    }
    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
