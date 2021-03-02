package com.example.darkmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn1 = findViewById(R.id.google);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.home.this,google.class);
                startActivity(activity2Intent);
            }
        });


        Button btn2 = findViewById(R.id.microsoft);
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.home.this,microsoft.class);
                startActivity(activity2Intent);
            }
        });






        Button princi = findViewById(R.id.princi);
        princi.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.home.this,princi.class);
                startActivity(activity2Intent);
            }
        });


        Button corres = findViewById(R.id.corres);
        corres.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.home.this, com.example.darkmode.corres.class);
                startActivity(activity2Intent);
            }
        });

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.home.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.home.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.home.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.home.this, dark_mode.class));
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
        return super.onOptionsItemSelected(item);
    }

}