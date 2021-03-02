package com.example.darkmode;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class AboutusActivity extends AppCompatActivity  {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.AboutusActivity.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.AboutusActivity.this, terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.AboutusActivity.this, policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.AboutusActivity.this, dark_mode.class));
                        return true;
                }
                return true;
            }

        });





        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        else
        {

            //handle presses on the action bar items
            switch (item.getItemId()) {
                case R.id.office:
                    startActivity(new Intent(this, officeBearers.class));
                    return true;
                case R.id.dept:
                    startActivity(new Intent(this, com.example.darkmode.deptco.class));
                    return true;
                case R.id.contact:
                    startActivity(new Intent(this, contactUs.class));
                    return true;
                case R.id.campus:
                    startActivity(new Intent(this, campus.class));
                    return true;
            }}
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu3, menu);
        return true;
    }


}