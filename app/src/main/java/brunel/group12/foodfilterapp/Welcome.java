package brunel.group12.foodfilterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle("Welcome");

        Bundle userNameData = getIntent().getExtras();
        if (userNameData==null){
            return;
        }
        String userName = userNameData.getString("userName");
        String RegUserName = userNameData.getString("RegUserName");
        Button button1 = (Button) findViewById(R.id.btn_cont_gps);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gps1 = new Intent(getApplicationContext(), PostCode.class);
                startActivity(gps1);
            }});
        final TextView userText = (TextView) findViewById(R.id.message_user);
        if (RegUserName==null){
            userText.setText(userName);
        }
        else {
            userText.setText(RegUserName);
        }
    }
    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }
}
