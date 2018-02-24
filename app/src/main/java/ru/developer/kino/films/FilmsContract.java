package ru.developer.kino.films;

import android.support.annotation.NonNull;

import java.util.List;

import ru.developer.kino.model.Movie;
import ru.developer.kino.model.ResponseFilms;

public interface FilmsContract {

    interface View {

        void showProgressLoading();

        void hideProgressLoading();

        void showMessage(@NonNull String msg);

        void setData(@NonNull List<Movie> data);

        void goToDetailMovie(int movieId);

    }

    interface Presenter {

        void load();

        void showDetailMovie(@NonNull Movie movie);

    }

    interface Interactor {

        void load(@NonNull LoadListener listener);

        interface LoadListener {

            void onSuccess(@NonNull ResponseFilms data);

            void onFail(@NonNull Throwable throwable);
        }

    }

}
