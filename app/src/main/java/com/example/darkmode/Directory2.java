package com.example.darkmode;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class Directory2 extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView tvname, tvemail, tvdepartment, tvbatch, tvcountry;
    ImageView Image;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory2);

        tvname = findViewById(R.id.NameValue);
        tvemail = findViewById(R.id.EmailValue);
        tvdepartment = findViewById(R.id.DepartmentValue);
        tvcountry = findViewById(R.id.CountryValue);
        tvbatch = findViewById(R.id.BatchValue);

        Image = findViewById(R.id.image);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        tvname.setText(Directory.SubjectList.get(position).getName());
        tvemail.setText(Directory.SubjectList.get(position).getEmail());
        tvdepartment.setText(Directory.SubjectList.get(position).getDepartment());
        tvbatch.setText(Directory.SubjectList.get(position).getBatch());
        tvcountry.setText(Directory.SubjectList.get(position).getCountry());
        Glide.with(Image.getContext()).load(Directory.SubjectList.get(position).getImage()).into(Image);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.Directory2.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.Directory2.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.Directory2.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.Directory2.this, dark_mode.class));
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
