package ru.developer.kino.detail_movie;

import android.os.Bundle;
import android.support.annotation.Nullable;

import ru.developer.kino.App;
import ru.developer.kino.BaseActivity;

public class DetailActivity extends BaseActivity implements DetailContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setupActivityComponent() {
        App.getInstance().initDetailComponent(this)
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        App.getInstance().destroyDetailComponent();
        super.onDestroy();
    }
}
