package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class favourite extends drawer_act {

    private RecyclerView recyclerView;
    private List<favItems> favItem1;
    private favourite_adapter adapter_fav;
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        setTitle("Favourites");

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user_fav= sharedPref.getString("user_email_sp", "");

        recyclerView = (RecyclerView) findViewById(R.id.fav_rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager favlmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(favlmanager);

        favItem1 = new ArrayList<>();

        Response.Listener<String> responsefav = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray arrayfav = jsonResponse.getJSONArray("fav");

                    for(int i=0;i<arrayfav.length();i++){
                        JSONObject objectfav = arrayfav.getJSONObject(i);
                        favItems itemfav = new favItems(objectfav.getString("favourites")
                        );
                        favItem1.add(itemfav);
                    }
                    adapter_fav = new favourite_adapter(favItem1, getApplicationContext());
                    recyclerView.setAdapter(adapter_fav);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

       // favItem1.add(new favItems("Subway"));
       // favItem1.add(new favItems("more"));



        fav_request req2 = new fav_request(user_fav,responsefav);
        RequestQueue favqueue = Volley.newRequestQueue(favourite.this);
        favqueue.add(req2);

    }
}
