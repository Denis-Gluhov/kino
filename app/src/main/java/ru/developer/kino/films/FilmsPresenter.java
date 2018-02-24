package ru.developer.kino.films;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import ru.developer.kino.model.Movie;
import ru.developer.kino.model.ResponseFilms;

public class FilmsPresenter implements FilmsContract.Presenter,
                                FilmsContract.Interactor.LoadListener {

    @NonNull
    private final FilmsContract.View view;
    @NonNull
    private final FilmsContract.Interactor interactor;

    @Inject
    FilmsPresenter(@NonNull FilmsContract.View view,
                   @NonNull FilmsContract.Interactor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void load() {
        interactor.load(this);
    }

    @Override
    public void onSuccess(@NonNull ResponseFilms data) {
        view.setData(data.getResults());
    }

    @Override
    public void onFail(@NonNull Throwable throwable) {

    }

    @Override
    public void showDetailMovie(@NonNull Movie movie) {
        view.goToDetailMovie(movie.getId());
    }
}
