package ru.developer.kino.films;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import ru.developer.kino.App;
import ru.developer.kino.BaseActivity;
import ru.developer.kino.R;
import ru.developer.kino.model.Movie;

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
        initToolbar();
        initRecyclerView();
        presenter.load();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.films_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.menu_films);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.films_event:

                    break;
                case R.id.films_filter:

                    break;
                default:
                    break;
            }
            return true;
        });
    }

    @Override
    public void setupActivityComponent() {
        App.getInstance().initFilmsComponent(this)
                .inject(this);
    }

    @Override
    public void setData(@NonNull List<Movie> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
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
