package brunel.group12.foodfilterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class reviews extends drawer_act {


    double rate1 ;
    double rate2;
    private TextView rev_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Reviews");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        Button b = (Button) findViewById(R.id.submit_review);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar3);
        RatingBar ratingBar2 = (RatingBar) findViewById(R.id.ratingBar);
        rev_name = (TextView) findViewById(R.id.rest_name_rev);
        Bundle bundleData = getIntent().getExtras();
        String name_rev_1 =bundleData.getString("res_rev_name");

        rev_name.setText(name_rev_1);

        Response.Listener<String> responselistener = new Response.Listener<String>() {
            double res_rating;
            @Override
            public void onResponse(String response) {
                try
                {JSONObject jsonResponse = new JSONObject(response);
                    JSONArray array2 = jsonResponse.getJSONArray("rest");

                    for (int i=0;i<array2.length(); i++){

                        JSONObject obj = array2.getJSONObject(i);

                        res_rating=obj.getString("rating");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ratingBar2.setRating(res_rating);
        };

        rating_page_request request = new rating_page_request(res_id,responselistener);
        RequestQueue queue2 = Volley.newRequestQueue(reviews.this);
        queue2.add(request);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(reviews.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
                rate1=rating;
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check_rating(rate1)) {
                    Toast.makeText(getBaseContext(), "Please Enter a Rating", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Submitted!!!", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });


    }
    public boolean check_rating(Double rate1) {

        return rate1>0.5;
    }
}