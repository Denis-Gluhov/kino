package ru.developer.kino.films;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import javax.inject.Inject;

import ru.developer.kino.App;
import ru.developer.kino.BaseActivity;
import ru.developer.kino.R;

public class FilmsActivity extends BaseActivity implements FilmsContract.View {

    @Inject
    FilmsContract.Presenter presenter;
    @Inject
    FilmsAdapter adapter;
    @Inject
    RecyclerView.LayoutManager layoutManager;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter.load();
    }

    @Override
    public void setupActivityComponent() {
        App.getInstance().initFilmsComponent(this)
                .inject(this);
    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.films_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.load());
        RecyclerView recyclerView = findViewById(R.id.films_recycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgressLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgressLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(@NonNull String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        App.getInstance().destroyFilmsComponent();
        super.onDestroy();
    }
}
