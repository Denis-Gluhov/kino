package ru.developer.kino.dagger;

import android.support.annotation.NonNull;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.developer.kino.model.ResponseDetailMovie;
import ru.developer.kino.model.ResponseFilms;

public interface ApiService {

    String BASE_URL = "https://api.themoviedb.org/";
    String GET_POSTER_URL = "http://image.tmdb.org/t/p/w185";
    String TOKEN = "0f959fc9ada028ea3674065dceb7c164";

//    String GET_ALL = "https://api.themoviedb.org/3/discover/movie?api_key=0f959fc9ada028ea3674065dceb7c164&primary_release_date.gte=2018-02-11&primary_release_date.lte=2018-02-18";
//    String GET_DETAIL = "https://api.themoviedb.org/3/movie/284054?api_key=0f959fc9ada028ea3674065dceb7c164";
//    String GET_POSTER = "http://image.tmdb.org/t/p/w500/bLBUCtMQGJclH36clliPLmljMys.jpg";
//    "w92", "w154", "w185", "w342", "w500", "w780"

    @NonNull
    @GET("/3/discover/movie?api_key={token}&primary_release_date.gte={begin_date}&primary_release_date.lte={end_date}")
    Single<ResponseFilms> getMoviesInTheatres(@NonNull @Path("token") String token,
                                              @NonNull @Path("begin_date") String beginDate,
                                              @NonNull @Path("end_date") String endDate);

    @NonNull
    @GET("/3/movie/{movie_id}?api_key={token}")
    Single<ResponseDetailMovie> getDetailMovieById(@NonNull @Path("token") String token,
                                                   @Path("movie_id") int movieId);


}
