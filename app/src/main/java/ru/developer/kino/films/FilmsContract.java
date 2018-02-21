package ru.developer.kino.films;

import android.support.annotation.NonNull;

import java.util.List;

import ru.developer.kino.model.Movie;

public interface FilmsContract {

    interface View {

        void showProgressLoading();

        void hideProgressLoading();

        void showMessage(@NonNull String msg);

    }

    interface Presenter {

        void load();

    }

    interface Interactor {

        void load(@NonNull LoadListener listener);

        interface LoadListener {

            void onSuccess(@NonNull List<Movie> data);

            void onFail(@NonNull Throwable throwable);
        }

    }

}
