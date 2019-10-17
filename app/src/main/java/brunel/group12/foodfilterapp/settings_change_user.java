package brunel.group12.foodfilterapp;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.content.Intent;
        import android.widget.Button;




public class settings_change_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_change_user);


        FloatingActionButton b = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(settings_change_user.this, settings.class);
            startActivity(i);
            }


        } );


    }
}
