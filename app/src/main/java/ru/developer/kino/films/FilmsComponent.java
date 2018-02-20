package ru.developer.kino.films;

import android.support.annotation.NonNull;

import dagger.Subcomponent;

@FilmsScoupe
@Subcomponent(modules = FilmsModule.class)
public interface FilmsComponent {
    void inject(@NonNull FilmsActivity activity);
}
