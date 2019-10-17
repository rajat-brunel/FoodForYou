package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class rest_page extends drawer_act {

    private ImageView b1;
    private ImageView b2;
    private ImageView b3;
    private ImageView b4;
    private ImageView bck_image;
    private CircleImageView logo_image;
    private TextView name;
    private TextView type;
    private String rest_menu;
    private String pass_ref_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_page);
        setTitle("Restaurant Page");


        b1 = (ImageView) findViewById(R.id.button1);
        b2 = (ImageView) findViewById(R.id.button2);
        b3 = (ImageView) findViewById(R.id.button3);
        b4 = (ImageView) findViewById(R.id.button4);
        bck_image = (ImageView) findViewById(R.id.imageView1);
        logo_image = (CircleImageView) findViewById(R.id.res_logo_image);
        name = (TextView) findViewById(R.id.res_name);
        type = (TextView) findViewById(R.id.res_type);

        Bundle bundle2 = getIntent().getExtras();
        String res = bundle2.getString("res");

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String user_cur= sharedPref.getString("user_email_sp", "");


            Response.Listener<String> responselistener = new Response.Listener<String>() {
                String name_res,logo,type_res,bckimg,menu_res;
                @Override
                public void onResponse(String response) {
                    try
                    {JSONObject jsonResponse = new JSONObject(response);
                     JSONArray array2 = jsonResponse.getJSONArray("rest");

                        for (int i=0;i<array2.length(); i++){

                            JSONObject obj = array2.getJSONObject(i);

                        name_res=obj.getString("name");
                        logo=obj.getString("logo");
                        type_res=obj.getString("type");
                        bckimg=obj.getString("bck");
                        menu_res=obj.getString("menu");
                    }

                    name.setText(name_res);
                    type.setText(type_res);
                    rest_menu=menu_res;
                        pass_ref_name=name_res;

                    Picasso.with(getApplicationContext()).
                        load(logo).
                        skipMemoryCache().
                        into(logo_image);

                   Picasso.with(getApplicationContext()).
                            load(bckimg).
                            skipMemoryCache().
                            into(bck_image);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
    };

    rest_page_request request2 = new rest_page_request(res,responselistener);
    RequestQueue queue2 = Volley.newRequestQueue(rest_page.this);
    queue2.add(request2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String rest = "https://www.pizzaexpress.com/our-food/restaurant-menu";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(rest_menu));

                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(rest_page.this, reviews.class);
                j.putExtra("res_rev_name",pass_ref_name);
                startActivity(j);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(rest_page.this, MapsActivity.class);
                k.putExtra("res_map_name",pass_ref_name);
                startActivity(k);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(rest_page.this, user_cur+pass_ref_name, Toast.LENGTH_SHORT).show();
                if(user_cur=="Guest"){
                    AlertDialog.Builder builder_guest = new AlertDialog.Builder(rest_page.this);
                    builder_guest.setMessage("Please Register/SignUp to use this feature").setNegativeButton("Retry", null).create().show();
                }
                else {
                    Response.Listener<String> response = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success) {
                                    Toast.makeText(rest_page.this, "Added to Favourites", Toast.LENGTH_SHORT).show();
                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(rest_page.this);
                                    builder.setMessage("This Restaurant is already in your favourites").setNegativeButton("Retry", null).create().show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    add_fav_request req = new add_fav_request(user_cur, pass_ref_name, response);
                    RequestQueue queue_fav = Volley.newRequestQueue(rest_page.this);
                    queue_fav.add(req);
                }
            }
        });
    }
}
