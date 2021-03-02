package com.example.darkmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    public CardView card1,card2,card3,card4,card5,card6,card7,card8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.Dashboard.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.Dashboard.this, terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.Dashboard.this, policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.Dashboard.this, dark_mode.class));
                        return true;

                    case R.id.login:
                        startActivity(new Intent(com.example.darkmode.Dashboard.this, login.class));
                        return true;

                }
                return true;
            }

        });



        /*ImageButton home = findViewById(R.id.homeicon);
        home.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.Dashboard.this,home.class);
                startActivity(activity2Intent);
            }
        });*/





        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        card1 = (CardView) findViewById(R.id.cardaboutus);
        card2 = (CardView) findViewById(R.id.cardevents);
        card3 = (CardView) findViewById(R.id.cardconnect);
        card4 = (CardView) findViewById(R.id.cardchapters);
        card5 = (CardView) findViewById(R.id.carddirectory);
        card6 = (CardView) findViewById(R.id.cardgallery);
        card7 = (CardView) findViewById(R.id.cardachievements);
        card8 = (CardView) findViewById(R.id.cardcontribution);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        else
        {

            //handle presses on the action bar items
            switch (item.getItemId()) {
                case R.id.homeicon:
                    startActivity(new Intent(this, home.class));
                    return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {
            case R.id.cardaboutus:
                i = new Intent(this, AboutusActivity.class);
                startActivity(i);
                break;


            case R.id.cardgallery :
                i = new Intent(this,GalleryActivity.class);
                startActivity(i);
                break;

            case R.id.cardevents :
                i = new Intent(this,EventsActivity.class);
                startActivity(i);
                break;

            case R.id.cardchapters :
                i = new Intent(this,Chapter.class);
                startActivity(i);
                break;

            case R.id.cardachievements :
                i = new Intent(this,achievement.class);
                startActivity(i);
                break;

            case R.id.cardcontribution :
                i = new Intent(this,contribution.class);
                startActivity(i);
                break;

            case R.id.carddirectory :
                i = new Intent(this,Directory.class);
                startActivity(i);
                break;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawerhome, menu);
        return true;
    }




}


















     /*

            case R.id.cardconnect :
                i = new Intent(this,ConnectActivity.class);
                startActivity(i);
                break;

            case R.id.cardchapters :
                i = new Intent(this,ChaptersActivity.class);
                startActivity(i);
                break;





*/