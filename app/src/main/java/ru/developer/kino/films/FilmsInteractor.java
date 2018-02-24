package ru.developer.kino.films;

import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import ru.developer.kino.dagger.ApiService;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FilmsInteractor implements FilmsContract.Interactor {

    @NonNull
    private final ApiService apiService;

    private final CompositeDisposable disposable;

    FilmsInteractor(@NonNull ApiService apiService) {
        this.apiService = apiService;
        disposable = new CompositeDisposable();
    }

    @Override
    public void load(@NonNull LoadListener listener) {
        apiService.getMoviesInTheatres(ApiService.TOKEN, "2018-02-24", "2018-03-08")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onFail);
    }
}
