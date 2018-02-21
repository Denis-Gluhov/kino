package ru.developer.kino.films;

import android.support.annotation.NonNull;

import ru.developer.kino.dagger.ApiService;

public class FilmsInteractor implements FilmsContract.Interactor {

    @NonNull
    private final ApiService apiService;

    FilmsInteractor(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void load(@NonNull LoadListener listener) {

    }
}
