package ru.developer.kino.detail_movie;

import android.support.annotation.NonNull;

import dagger.Subcomponent;

@DetailScope
@Subcomponent(modules = DetailModule.class)
public interface DetailComponent {
    void inject(@NonNull DetailActivity activity);
}
