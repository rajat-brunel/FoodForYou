package brunel.group12.foodfilterapp;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Filter_Options extends drawer_act {


    private RecyclerView recyclerView;
    private GridViewAdapter adapter;

    private List<GridItem> gridItems;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        setTitle("Filters Available");

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view_grid);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);


        Bundle post = getIntent().getExtras();
        String pst = post.getString("post_code");
        gridItems = new ArrayList<>();


        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
               // String test1="";

                try{

                    JSONObject jsonResponse = new JSONObject(response);
                  //  boolean error = jsonResponse.getBoolean("error");
                    JSONArray array = jsonResponse.getJSONArray("rest");

                    for(int i=0; i<array.length();i++){

                        JSONObject object = array.getJSONObject(i);

                        GridItem item = new GridItem(
                                object.getString("name"),
                                object.getString("img_res"),
                                object.getString("post_code")
                        );

                        gridItems.add(item);

                    }
                    adapter = new GridViewAdapter(gridItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };


        Filter_Options_Request Request = new Filter_Options_Request(pst,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Filter_Options.this);
        queue.add(Request);


    }



}
