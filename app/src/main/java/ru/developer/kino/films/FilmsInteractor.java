package ru.developer.kino.films;

import android.support.annotation.NonNull;

import ru.developer.kino.dagger.ApiService;

public class FilmsInteractor implements FilmsContract.Interactor {

    @NonNull
    private final ApiService apiService;

    public FilmsInteractor(@NonNull ApiService apiService) {
        this.apiService = apiService;
    }
}
