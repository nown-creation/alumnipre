package com.example.darkmode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class officeBearers extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    ListView listView;
    String mTitle[] = {"Thiru P.Sachithanandhan","Dr.V.Balusamy","Dr.R.Baskar","Ms.S.Gomathi","Dr.T.Pradeep","Dr.R.Naveen Kumar"};

    String mDescription1[] = {"Chief Patron\n\n" +
            "Correspondent,KEC\n\n","Patron\n\n" +
            "Principal\n\n" +
            "Kongu Engineering College\n\n",
            "Chief Coordinator\n\n" +
                    "Professor & Head of Department\n\n" +
                    "Food Technology\n\n, KEC\n\n" +
                    "Email: erbaskar@kongu.ac.in\n\n" +
                    "Mobile: 9842294264\n\n",
            "Secretary\n\n" +
                    "Assistant Professor\n\n" +
                    "Department of Electronics and Communication Engineering ,KEC\n\n" +
                    "Email: sgomathi@kongu.ac.in\n\n" +
                    "Mob: 9865270970\n\n",
            "Joint Secretary\n\n" +
                    "Assistant Professor\n\n" +
                    "Department of Civil Engineering,KEC\n\n" +
                    "Email: pradeep@kongu.ac.in\n\n" +
                    "Mob: 9944062686\n\n",
            "Treasurer\n\n" +
                    "Assistant Professor\n\n" +
                    "Department of Mechanical Engineering,KEC\n\n" +
                    "Email: naveenmech@kongu.ac.in\n\n" +
                    "Mob: 9790267674\n\n"};
    int images[] = {R.drawable.corresp, R.drawable.princi,R.drawable.chief_coordinator,R.drawable.secretary,R.drawable.jo_secretary,R.drawable.treasurer};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_bearers);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription1, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Chief Patron", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Patron", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Chief Coordinator", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Secretary", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Joint Secretary", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.officeBearers.this, "Treasurer", Toast.LENGTH_SHORT).show();
                }

            }
        });

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.officeBearers.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.officeBearers.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.officeBearers.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.officeBearers.this, dark_mode.class));
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


    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rTitle[];
        String rDescription1[];
        int rImgs[];

        MyAdapter(Context c, String title[],String description1[],int imgs[])
        {
            super(c, R.layout.row, R.id.textView1,title);
            this.context =c;
            this.rTitle =title;
            this.rDescription1 = description1;
            this.rImgs =imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription1 = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription1.setText(rDescription1[position]);
            return row;
        }
    }  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu3, menu);
        return true;
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
                    startActivity(new Intent(this, com.example.darkmode.officeBearers.class));
                    return true;
                case R.id.dept:
                    startActivity(new Intent(this, com.example.darkmode.deptco.class));
                    return true;
                case R.id.contact:
                    startActivity(new Intent(this, com.example.darkmode.contactUs.class));
                    return true;
                case R.id.campus:
                    startActivity(new Intent(this, campus.class));
                    return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}