package com.example.darkmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.btnlog);
        buttonOne.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(com.example.darkmode.MainActivity.this, com.example.darkmode.Dashboard.class);
                startActivity(activity2Intent);
            }
        });


    }
}