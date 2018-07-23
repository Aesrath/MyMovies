package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by 16003806 on 23/7/2018.
 */

public class CostumAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<MovieList> movieList;

    public CostumAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MovieList> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout_id,parent,false);

        TextView tvTitle = view.findViewById(R.id.textViewTitle);
        TextView tvDesc = view.findViewById(R.id.textViewDesc);
        ImageView ivRated = view.findViewById(R.id.imageViewRating);

        MovieList currentMovie = movieList.get(position);

        String title = currentMovie.getTitle();
        String year = currentMovie.getYear();
        String genre = currentMovie.getGenre();
        String rated = currentMovie.getRated();

        tvTitle.setText(title);
        tvDesc.setText(year + " - " + genre);
        if(rated.equalsIgnoreCase("g")){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equalsIgnoreCase("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equalsIgnoreCase("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(rated.equalsIgnoreCase("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equalsIgnoreCase("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equalsIgnoreCase("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }

        return view;

    }
}
