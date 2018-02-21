package ru.developer.kino.films;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import ru.developer.kino.model.Movie;

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

    }

    @Override
    public void onSuccess(@NonNull List<Movie> data) {

    }

    @Override
    public void onFail(@NonNull Throwable throwable) {

    }
}
