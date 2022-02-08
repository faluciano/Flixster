package com.example.flixster.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    double voteAverage;
    String popularity;
    Integer id;

    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        backdropPath = jsonObject.getString("backdrop_path");
        voteAverage = jsonObject.getDouble("vote_average");
        popularity = jsonObject.getString("popularity");
        id = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getBackdropPath() {
        if (!backdropPath.equals("null")) {
            return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
        }
        return getPosterPath();
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public float getVoteAverage() {
        return (float) voteAverage/2;
    }

    public String getPopularity() {
        return popularity;
    }

    public Integer getId() {
        return id;
    }

}
