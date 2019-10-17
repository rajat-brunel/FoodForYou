package brunel.group12.foodfilterapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.DisplayMetrics;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Muhammad Azeem on 09/02/2017.
 */

public class Pop extends drawer_act{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        Button b = (Button) findViewById(R.id.backButton);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Pop.this, settings.class);
                startActivity(i);
            }

        } );

    }
}
