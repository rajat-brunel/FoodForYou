package brunel.group12.foodfilterapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class drawer_act extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    private FrameLayout view_stub; //This is the framelayout to keep your content view
    private NavigationView navigation_view; // The new navigation view from Android Design Library. Can inflate menu resources
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Menu drawerMenu;
    private String uname_str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_drawer_act);// The base layout that contains your navigation drawer.
        view_stub = (FrameLayout) findViewById(R.id.view_stub);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        View header = navigation_view.getHeaderView(0);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0);

        TextView user_email;
        user_email = (TextView)header.findViewById(R.id.nav_email_user);


        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigation_view.setItemIconTintList(null);

        //get SharedPreference data

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        uname_str= sharedPref.getString("user_email_sp", "");
      //  Toast.makeText(this, uname_str, Toast.LENGTH_SHORT).show();

        user_email.setText(uname_str);


        drawerMenu = navigation_view.getMenu();
        for(int i = 0; i < drawerMenu.size(); i++) {
            drawerMenu.getItem(i).setOnMenuItemClickListener(this);
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /* Override all setContentView methods to put the content view to the FrameLayout view_stub
     * so that, we can make other activity implementations looks like normal activity subclasses.
     */
    @Override
    public void setContentView(int layoutResID) {
        if (view_stub != null) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            View stubView = inflater.inflate(layoutResID, view_stub, false);
            view_stub.addView(stubView, lp);

        }
    }

    @Override
    public void setContentView(View view) {
        if (view_stub != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            view_stub.addView(view, lp);

        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (view_stub != null) {
            view_stub.addView(view, params);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Help_nav : Intent help= new Intent(this,help.class);
                     startActivity(help);
                return true;
            case R.id.logout_nav : Intent logout = new Intent(this,MainActivity.class);
                     startActivity(logout);
                return true;
            case R.id.settings_nav : Intent settings = new Intent(this,settings.class);
                    startActivity(settings);
                return true;
            case R.id.about_nav : Intent about_us = new Intent(this,about_us_2.class);
                startActivity(about_us);
                return true;
            case R.id.fav_nav :
                if (uname_str=="Guest"){
                    AlertDialog.Builder builder_guest = new AlertDialog.Builder(drawer_act.this);
                    builder_guest.setMessage("Please Register/SignUp to use this feature").setNegativeButton("Retry", null).create().show();
                    return false;
                }else{
                Intent fav_nav = new Intent(this,favourite.class);
                startActivity(fav_nav);
                }
                return true;
        }
        return false;
    }
}
