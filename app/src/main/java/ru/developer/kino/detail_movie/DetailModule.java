package ru.developer.kino.detail_movie;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @NonNull
    private final DetailContract.View view;

    public DetailModule(@NonNull DetailContract.View view) {
        this.view = view;
    }

    @NonNull
    @DetailScope
    @Provides
    DetailContract.View provideView() {
        return view;
    }
}
