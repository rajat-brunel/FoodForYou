package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
      //  getSupportActionBar().hide();

        ImageView logo_link = (ImageView)findViewById(R.id.ffy);

        logo_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rest = "http://178.62.122.19/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(rest));

                startActivity(i);
            }
        });

    }


    public void OnClick_Login(View view){

        Intent login = new Intent(this, Login.class);
        startActivity(login);
    }

    public void OnClick_Guest(View view){

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("user_email_sp","Guest");
        editor.apply();
        Intent login = new Intent(this, PostCode.class);
        login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(login);
    }

    public void OnClick_sign(View view){

        Intent login = new Intent(this, Signup.class);
        startActivity(login);
    }
}
