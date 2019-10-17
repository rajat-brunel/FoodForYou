package brunel.group12.foodfilterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Restaurant_Options extends drawer_act {

    private RecyclerView recyclerView;
    private List<restItems> RestItem;
    private Rest_RVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data_bundle = getIntent().getExtras();
        String res = data_bundle.getString("filter");
        String post = data_bundle.getString("post");
        setContentView(R.layout.activity_restaurant__options);
        setTitle("Restaurants Available");

        recyclerView = (RecyclerView) findViewById(R.id.rest_rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llmanager);



        RestItem = new ArrayList<>();

        Response.Listener<String> responselistener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray array1 = jsonResponse.getJSONArray("rest");

                    for (int i = 0 ; i<array1.length();i++){

                        JSONObject object1 = array1.getJSONObject(i);

                        restItems Item1 = new restItems(object1.getString("name"),
                                object1.getString("type"),
                                object1.getString("logo")
                        );
                        RestItem.add(Item1);
                        }
                   // RestItem.add(new restItems("Subway","American","http://178.62.122.19/img/logo/subway.png"));
                        adapter = new Rest_RVAdapter(RestItem,getApplicationContext());
                        recyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Restaurant_Options_Request request_1 = new Restaurant_Options_Request(post,res,responselistener);
        RequestQueue queue = Volley.newRequestQueue(Restaurant_Options.this);
        queue.add(request_1);
    }
}
