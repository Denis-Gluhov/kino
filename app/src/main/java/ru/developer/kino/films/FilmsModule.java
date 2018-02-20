package ru.developer.kino.films;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import ru.developer.kino.dagger.ApiService;

@Module
public class FilmsModule {

    @NonNull
    private final FilmsContract.View view;

    public FilmsModule(@NonNull FilmsContract.View view) {
        this.view = view;
    }

    @NonNull
    @FilmsScoupe
    @Provides
    FilmsContract.View provideView() {
        return view;
    }

    @NonNull
    @FilmsScoupe
    @Provides
    FilmsContract.Interactor provideInteractor(@NonNull ApiService apiService) {
        return new FilmsInteractor(apiService);
    }
}
