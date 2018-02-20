package ru.developer.kino.dagger;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import ru.developer.kino.detail_movie.DetailComponent;
import ru.developer.kino.detail_movie.DetailModule;
import ru.developer.kino.films.FilmsComponent;
import ru.developer.kino.films.FilmsModule;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    FilmsComponent filmsComponent(@NonNull FilmsModule module);
    DetailComponent detailComponent(@NonNull DetailModule module);
}
