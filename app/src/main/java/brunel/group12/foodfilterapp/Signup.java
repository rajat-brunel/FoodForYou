package brunel.group12.foodfilterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("Sign Up");

        //Initialize the TextInput
        final TextInputLayout fName_Wrapper = (TextInputLayout) findViewById(R.id.fNameWrapper);
        final TextInputLayout lName_Wrapper = (TextInputLayout) findViewById(R.id.lNameWrapper);
        final TextInputLayout Email_Wrapper = (TextInputLayout) findViewById(R.id.Email_Id_Wrapper);
        final TextInputLayout pass_Wrapper = (TextInputLayout) findViewById(R.id.pass_Wrapper);

        //Set The TextInput Hints
        fName_Wrapper.setHint("First Name");
        lName_Wrapper.setHint("Last Name");
        Email_Wrapper.setHint("Email");
        pass_Wrapper.setHint("Password");

        //Initialize Login Button
        Button button_signup = (Button)findViewById(R.id.btn_SignUp);

        //Initialize the signup page Intent
        TextView link_signup = (TextView)findViewById(R.id.link_login);

        //SignUp Page Intent Listener
        link_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
            }
        });

        //SignUp button Listener

        button_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hideKeyboard();

                String fName = fName_Wrapper.getEditText().getText().toString();
                String lName = lName_Wrapper.getEditText().getText().toString();
                String Email = Email_Wrapper.getEditText().getText().toString();
                String pass = pass_Wrapper.getEditText().getText().toString();

                if (!ValidateEmail(Email)){
                    Email_Wrapper.setError("Enter Valid Email");
                }else if (!ValidatePass(pass)){
                    pass_Wrapper.setError("Minimum length of password is 6");
                }else{
                    Email_Wrapper.setErrorEnabled(false);
                    pass_Wrapper.setErrorEnabled(false);
                    doLogin();
                }

            }
            //Hides the keyboard after userInput
            private void hideKeyboard() {
                View view = getCurrentFocus();
                if (view != null) {
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                            hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }

            private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
            private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            private Matcher matcher;

            //Validation

            public boolean ValidateEmail(String email) {
                matcher = pattern.matcher(email);
                return matcher.matches();
            }

            public boolean ValidatePass(String pass){
                return pass.length()>6;
            }
            public void doLogin(){
                onLoginSuccess();

            }

            public void onLoginSuccess() {

                final ProgressDialog progressDialog = new ProgressDialog(Signup.this);
                progressDialog.setMessage("Authenticating");
                progressDialog.show();

                final String first_name = fName_Wrapper.getEditText().getText().toString();
                final String last_name = lName_Wrapper.getEditText().getText().toString();
                final String username = Email_Wrapper.getEditText().getText().toString();
                final String password = pass_Wrapper.getEditText().getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();

                        try {
                            JSONObject jsonResponse= new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("user_email_sp",username);
                                editor.apply();
                                Intent i = new Intent(getApplicationContext(),Welcome.class);
                                i.putExtra("RegUserName",first_name);
                                 startActivity(i);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                                builder.setMessage("Register Failed").setNegativeButton("Retry", null).create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(first_name, last_name, username, password, responseListener);

                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                queue.add(registerRequest);

                //String fName = fName_Wrapper.getEditText().getText().toString();
                //Intent i = new Intent(getApplicationContext(),Welcome.class);
                //i.putExtra("RegUserName",fName);
               // startActivity(i);
            }
        });
    }


}
