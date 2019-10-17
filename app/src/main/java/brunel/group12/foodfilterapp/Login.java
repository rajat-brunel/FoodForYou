package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.Intent;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        //Initialize the TextInput
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);

        //Set The TextInput Hints
        usernameWrapper.setHint("Email");
        passwordWrapper.setHint("Password");

        //Initialize Login Button
        Button btn = (Button)findViewById(R.id.btn);

        //Initialize the signup page Intent
        TextView link_signup = (TextView)findViewById(R.id.link_signup);

        //SignUp Page Intent Listener
        link_signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    Intent signUp = new Intent(getApplicationContext(), Signup.class);
                startActivity(signUp);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        //Login Button Listener
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();

                if (!ValidateEmail(username)){
                    usernameWrapper.setError("Not a valid address!");
                }else if (!validatePassword(password)){
                    passwordWrapper.setError("Not a valid password");
                }else{
                    usernameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
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

        public boolean ValidateEmail(String email) {
            matcher = pattern.matcher(email);
            return matcher.matches();
        }

        public boolean validatePassword(String password){
            return password.length()>6;
        }

        public void doLogin(){
            onLogin();

        }
            public void onLogin(){
                final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                progressDialog.setMessage("Authenticating");
                progressDialog.show();
                final String username = usernameWrapper.getEditText().getText().toString();
                final String password = passwordWrapper.getEditText().getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                    String first_name = jsonResponse.getString("first_name");
                                    String user_email = jsonResponse.getString("username");

                                    //Initiate Shared Preference
                                    SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPref.edit();
                                    editor.putString("user_email_sp",user_email);
                                    editor.apply();
                                  //Toast.makeText(Login.this, user_email, Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Login.this, Welcome.class);
                                    intent.putExtra("userName",first_name);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);

                            } else {

                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();
                            }

                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                login_request Request = new login_request(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(Request);
            }



    });


    }
    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }
}
