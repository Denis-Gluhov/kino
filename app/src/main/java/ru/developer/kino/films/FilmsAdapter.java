package ru.developer.kino.films;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.developer.kino.R;
import ru.developer.kino.dagger.ApiService;
import ru.developer.kino.model.Movie;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;

    @NonNull
    private List<Movie> data;

    @Inject
    FilmsAdapter(@NonNull Context context,
                 @NonNull LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
        this.data = new ArrayList<>();
    }

    public void setData(@NonNull List<Movie> data) {
        this.data = data;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.films_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = data.get(position);
        loadImage(holder.imageFilm, ApiService.GET_POSTER_URL + movie.getPosterPath());
    }

    @Override
    public int getItemCount() {
        if (!data.isEmpty())
            return data.size();
        else
            return 1;
    }

    private void loadImage(@NonNull ImageView imageView,
                           @NonNull String url) {
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageFilm;
        ViewHolder(View itemView) {
            super(itemView);
            imageFilm = itemView.findViewById(R.id.films_image);
        }
    }
}
