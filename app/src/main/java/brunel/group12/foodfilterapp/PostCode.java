package brunel.group12.foodfilterapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PostCode extends drawer_act {

    //Initialize buttons, Text and LocationListeners
    private ImageButton b;
    private TextView t;
    private TextView post_txt;
    private Button sendPost;
    private LocationManager locationManager;
    private LocationListener listener;
    private ImageView img;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_code);
        setTitle("Enter PostCode");

        //

        b = (ImageButton) findViewById(R.id.press_me_v2);
        // t= (TextView) findViewById(R.id.result_gps);
        post_txt = (TextView) findViewById(R.id.text_post);
        sendPost = (Button) findViewById(R.id.btn_filter);
        img = (ImageView) findViewById(R.id.help_btn);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Longitude

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //t.append("\n " + "Longitude " + location.getLongitude() + " Latitude " + location.getLatitude());
                location.getLongitude();
                location.getLatitude();
                Geocoder geoCoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                List<Address> address = null;

                //Get Postcode from Longitude and Latitude

                if (geoCoder !=null){
                    try{
                        address = geoCoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    }catch (IOException e1){
                        e1.printStackTrace();
                        //Compare size of address, if null print cant get postcode
                    }if (address.size()>0){
                        String postCode= address.get(0).getPostalCode();
                        post_txt.setText(postCode);
                    }else{
                        Toast.makeText(getBaseContext(), "Can't Get PostCode", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                //ASK For Permissions
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);

            }
        };
        configure_button();

        sendPost.setOnClickListener(new View.OnClickListener(){

                                        public void onClick(View v){

                                            if (!post_txt.equals("")) {
                                                final String pst=post_txt.getText().toString();

                                                //  Toast.makeText(PostCode.this, pst, Toast.LENGTH_SHORT).show();

                                                Response.Listener<String> responseListener = new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {
                                                        String test1="";
                                                        try{

                                                            JSONObject jsonResponse = new JSONObject(response);
                                                            boolean error = jsonResponse.getBoolean("error");
                                                            JSONArray array = jsonResponse.getJSONArray("rest");

                                                            for(int i=0; i<array.length();i++){
                                                                JSONObject object = array.getJSONObject(i);
                                                                object.getString("img_res");
                                                                test1+=object.getString("img_res");
                                                            }

                                                            if(error){
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(PostCode.this);
                                                                builder.setMessage("No Filter Options Available in this area!").setNegativeButton("Try Another",null).create().show();
                                                                Toast.makeText(PostCode.this, "yay", Toast.LENGTH_SHORT).show();
                                                            }else{
                                                               // Toast.makeText(PostCode.this, test1, Toast.LENGTH_SHORT).show();
                                                                Intent filter_scrn = new Intent(PostCode.this, Filter_Options.class);
                                                                filter_scrn.putExtra("post_code",pst);

                                                                PostCode.this.startActivity(filter_scrn);
                                                            }

                                                        } catch (JSONException e){
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                };
                                                Filter_Options_Request Request = new Filter_Options_Request(pst,responseListener);
                                                RequestQueue queue = Volley.newRequestQueue(PostCode.this);
                                                queue.add(Request);
                                            }
                                            else
                                            {
                                                Toast.makeText(getBaseContext(), "Please Enter Post Code", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }

        );

        img.setOnClickListener(new View.OnClickListener()
                               {
                                   public void onClick(View v){
                                       Intent help_intent = new Intent(PostCode.this,help.class);
                                       startActivity(help_intent);
                                   }
                               }
        );
    }
    @Override

    // Run configure button once permissions are granted
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions ,@NonNull int[] grantResults){
        switch (requestCode){
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button(){
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }

        // Get Location request through GPS

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,5, listener);
            }
        });
    }
}
