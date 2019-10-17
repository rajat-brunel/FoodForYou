package brunel.group12.foodfilterapp;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.content.Intent;


public class settings_change_pass extends drawer_act {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_pass);


   FloatingActionButton b = (FloatingActionButton) findViewById(R.id.floatingActionButton);

         b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                 Intent i = new Intent(settings_change_pass.this, settings.class);

                startActivity(i);
             }

         });

    }
}


