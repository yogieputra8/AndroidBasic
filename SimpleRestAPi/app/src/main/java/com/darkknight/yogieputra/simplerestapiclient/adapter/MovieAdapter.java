package com.darkknight.yogieputra.simplerestapiclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.darkknight.yogieputra.simplerestapiclient.R;
import com.darkknight.yogieputra.simplerestapiclient.model.Movies;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<Movies> movies;

    public MovieAdapter(Context context, List<Movies> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movies movies1 = movies.get(position);
        holder.title.setText(movies1.getTitle());
        holder.director.setText(movies1.getDirector());
        holder.description.setText(movies1.getDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, director, description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            director = (TextView) itemView.findViewById(R.id.tv_director);
            description = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }
}
