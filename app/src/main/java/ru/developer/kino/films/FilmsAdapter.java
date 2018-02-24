package ru.developer.kino.films;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.developer.kino.R;
import ru.developer.kino.dagger.ApiService;
import ru.developer.kino.model.Movie;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    interface OnClickListener {
        void onItemClick(@NonNull Movie movie);
    }

    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;
    @NonNull
    private final WeakReference<OnClickListener> listenerWeakReference;

    @NonNull
    private List<Movie> data;

    @Inject
    FilmsAdapter(@NonNull Context context,
                 @NonNull LayoutInflater inflater,
                 @NonNull WeakReference<OnClickListener> listenerWeakReference) {
        this.context = context;
        this.inflater = inflater;
        this.listenerWeakReference = listenerWeakReference;
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
        holder.nameFilm.setText(movie.getTitle());
        loadImage(holder.imageFilm, ApiService.GET_POSTER_URL + movie.getPosterPath());
        holder.cardFilm.setOnClickListener(v -> {
            OnClickListener clickListener = listenerWeakReference.get();
            clickListener.onItemClick(movie);
        });
    }

    @Override
    public int getItemCount() {
        if (!data.isEmpty())
            return data.size();
        else
            return 0;
    }

    private void loadImage(@NonNull ImageView imageView,
                           @NonNull String url) {
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardFilm;
        final ImageView imageFilm;
        final TextView nameFilm;
        ViewHolder(View itemView) {
            super(itemView);
            cardFilm = itemView.findViewById(R.id.films_card);
            imageFilm = itemView.findViewById(R.id.films_image);
            nameFilm = itemView.findViewById(R.id.films_name);
        }
    }
}
