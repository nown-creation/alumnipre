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

public class Chapter extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.Chapter.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.Chapter.this, terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.Chapter.this, policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.Chapter.this, dark_mode.class));
                        return true;

                }
                return true;
            }

        });






        Button mideast = findViewById(R.id.mideast);
        mideast.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this,Chapter_middle_east.class);
                startActivity(activity2Intent);
            }
        });

        Button america = findViewById(R.id.northAmerica);
        america.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this,Chapter_america.class);
                startActivity(activity2Intent);
            }
        });

        Button erode = findViewById(R.id.erode);
        erode.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this,Chapter_erode.class);
                startActivity(activity2Intent);
            }
        });

        Button uk = findViewById(R.id.uk);
        uk.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this, com.example.darkmode.Chapter_uk.class);
                startActivity(activity2Intent);
            }
        });

        Button singapore = findViewById(R.id.singapore);
        singapore.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this, com.example.darkmode.Chapter_singapore.class);
                startActivity(activity2Intent);
            }
        });

        Button bangalore = findViewById(R.id.bangalore);
        bangalore.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this, com.example.darkmode.Chapter_bangalore.class);
                startActivity(activity2Intent);
            }
        });

        Button australia = findViewById(R.id.australia);
        australia.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Chapter.this, com.example.darkmode.Chapter_australia.class);
                startActivity(activity2Intent);
            }
        });
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}