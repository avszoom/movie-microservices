package com.avszoom.moviecatalogservice.models;

public class Movie {

    private String movieId;
    private String name;

    /*
    * you need empty constructor because when jackson unmarshall a string to an object it first creates an empty object
    * and then refer to each field by field.
    * */
    public Movie(){}

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
