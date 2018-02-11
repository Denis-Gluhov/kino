package ru.developer.kino.data.api;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.developer.kino.model.Response;

public interface ApiService {

    String BASE_URL = "https://api.themoviedb.org/";
    String TOKEN = "0f959fc9ada028ea3674065dceb7c164";

    @NonNull
    @GET("/3/discover/movie?api_key={token}&primary_release_date.gte={begin_date}&primary_release_date.lte={end_date}")
    Observable<Response> getMoviesInTheatres(@NonNull @Path("token") String token,
                                             @NonNull @Path("begin_date") String beginDate,
                                             @NonNull @Path("end_date") String endDate);
}
