package ru.developer.kino.films;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import javax.inject.Named;

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
    @Named("films")
    @Provides
    Context provideContex() {
        return (Context) view;
    }

    @NonNull
    @FilmsScoupe
    @Provides
    FilmsContract.Interactor provideInteractor(@NonNull ApiService apiService) {
        return new FilmsInteractor(apiService);
    }

    @NonNull
    @FilmsScoupe
    @Provides
    FilmsContract.Presenter providePresenter(@NonNull FilmsContract.View view,
                                             @NonNull FilmsContract.Interactor interactor) {
        return new FilmsPresenter(view, interactor);
    }

    @NonNull
    @FilmsScoupe
    @Provides
    RecyclerView.LayoutManager provideLayoutManager(@NonNull @Named("films") Context context) {
        return new GridLayoutManager(context, 2);
    }

    @NonNull
    @FilmsScoupe
    @Provides
    FilmsAdapter provideAdapter(@NonNull @Named("films") Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new FilmsAdapter(context, inflater);
    }
}
