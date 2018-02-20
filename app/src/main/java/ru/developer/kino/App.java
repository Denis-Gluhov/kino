package ru.developer.kino;

import android.app.Application;
import android.support.annotation.NonNull;

import ru.developer.kino.dagger.AppComponent;
import ru.developer.kino.dagger.AppModule;
import ru.developer.kino.dagger.DaggerAppComponent;
import ru.developer.kino.detail_movie.DetailActivity;
import ru.developer.kino.detail_movie.DetailComponent;
import ru.developer.kino.detail_movie.DetailModule;
import ru.developer.kino.films.FilmsActivity;
import ru.developer.kino.films.FilmsComponent;
import ru.developer.kino.films.FilmsModule;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;
    private FilmsComponent filmsComponent;
    private DetailComponent detailComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public FilmsComponent initFilmsComponent(@NonNull FilmsActivity activity) {
        this.filmsComponent = appComponent.filmsComponent(new FilmsModule(activity));
        return filmsComponent;
    }

    public DetailComponent initDetailComponent(@NonNull DetailActivity activity) {
        this.detailComponent = appComponent.detailComponent(new DetailModule(activity));
        return detailComponent;
    }

    public void destroyFilmsComponent() {
        filmsComponent = null;
    }

    public void destroyDetailComponent() {
        detailComponent = null;
    }
}
