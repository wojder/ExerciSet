package com.example.wojder.exerciset.model;

/**
 * Created by wojder on 25.02.16.
 */
public class Application {

    private String name;
    private String artist;
    private String releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Artist: " +getArtist() + "\n" +
                "Application release date: " + "\n";
    }
}
