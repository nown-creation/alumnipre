package com.example.darkmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.GalleryActivity.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.GalleryActivity.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.GalleryActivity.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.GalleryActivity.this, dark_mode.class));
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

        RecyclerView postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postsRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        List<com.example.darkmode.PostItem> postItems = new ArrayList<>();
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g1)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g2)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g3)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g4)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g5)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g6)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g7)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g8)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g9)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g10)));

        postItems.add(new com.example.darkmode.PostItem((R.drawable.g11)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g12)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g13)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g14)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g15)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g16)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g17)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g18)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g19)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g20)));

        postItems.add(new com.example.darkmode.PostItem((R.drawable.g21)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g22)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g23)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g24)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g25)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g26)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g27)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g28)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g29)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g30)));

        postItems.add(new com.example.darkmode.PostItem((R.drawable.g31)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g32)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g33)));
        postItems.add(new com.example.darkmode.PostItem((R.drawable.g34)));

        postsRecyclerView.setAdapter(new com.example.darkmode.PostsAdapter(postItems));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}