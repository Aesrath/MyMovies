package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by 16003806 on 23/7/2018.
 */

public class MovieDetailActivity extends AppCompatActivity {
    ImageView ivRating;
    TextView tvTitle;
    TextView tvDesc;
    TextView tvSys;
    TextView tvDate;
    TextView tvVenue;
    RatingBar rtMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        ivRating = findViewById(R.id.imageViewRatingD);
        tvTitle = findViewById(R.id.textViewTitleD);
        tvDesc = findViewById(R.id.textViewDescD);
        tvSys = findViewById(R.id.textViewSynopsis);
        tvDate = findViewById(R.id.textViewWatchOn);
        tvVenue = findViewById(R.id.textViewVenue);
        rtMovie = findViewById(R.id.ratingBarMovie);

        Intent intentReceived = getIntent();
        String rating = intentReceived.getStringExtra("Rating");
        if(rating.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if(rating.equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if(rating.equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if(rating.equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if(rating.equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if(rating.equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        String title = intentReceived.getStringExtra("Title");
        tvTitle.setText(title);
        String year = intentReceived.getStringExtra("Year");
        String genre = intentReceived.getStringExtra("Genre");
        tvDesc.setText(year + " - " + genre);
        String date = intentReceived.getStringExtra("Date");
        tvDate.setText("Watched On: " + date);
        String sys = intentReceived.getStringExtra("Synopsis");
        tvSys.setText(sys);
        String venue = intentReceived.getStringExtra("Venue");
        tvVenue.setText("In Theatre: " + venue);
        int rate = intentReceived.getIntExtra("barRate",0);
        rtMovie.setRating(rate);





    }
}
