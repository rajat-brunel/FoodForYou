package brunel.group12.foodfilterapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import static com.android.volley.Request.Method.HEAD;

public class settings extends drawer_act{


    private Button b,c,d,e,f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        b = (Button) findViewById(R.id.chg_pass);
        c = (Button) findViewById(R.id.Username);
        d = (Button) findViewById(R.id.ClearFavourites);
        e = (Button) findViewById(R.id.edt_photo);
        f = (Button) findViewById(R.id.button_gps_settings);



        //Intent to Clear Favorites
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(settings.this,Pop.class));

                           }
        } );


                //Intent to change password
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(settings.this, settings_change_pass.class);

                        startActivity(i);

                    }
                });
        //Intent to change user
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(settings.this, settings_change_user.class);

                startActivity(i);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        });
    }

}