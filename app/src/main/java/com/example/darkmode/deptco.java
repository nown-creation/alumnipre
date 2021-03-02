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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class deptco extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    ListView listView;
    String mTitle[] = {"Mr. P. Dinesh kumar","Mr. M. Harikrishnakumar","Mr. S. K. Thangarasu","Mr. R. Nithyaprakash","Dr. S. Sasikala","Dr. R. S. Mohana","Ms. D. Deepa","Mr. D. Vijay Anand","Dr. M. Sivachitra","Mr. P. Tamilarasu","Dr. R. Subasri","Dr. N. Mahesh","D.Revathi","Ms. A. Sangeetha","Ms. P. Gokila Brindha","Dr. G. R. Sreekanth","Ms. S. Hemalatha","Dr. P. Karthikeyan"};

    String mDescription1[] = {"Assistant Professor\n\n" +
            "Department of Civil Engineering\n\n" +
            "Email: dinucivil@kongu.ac.in\n\n" +
            "Mob: 9842060648","Assistant Professor\n\n" +
            "Department of Mechanical Engineering\n\n" +
            "Email: harikrishnamech@kongu.ac.in\n\n" +
            "Mob: 9715808222",
            "Assistant Professor\n\n" +
                    "Department of Mechatronics Engineering\n\n" +
                    "Email: thangarasu@kongu.ac.in\n\n" +
                    "Mob: 9942783338",
            "Assistant Professor\n\n" +
                    "Department of Mechatronics Engineering\n\n" +
                    "Email: nithyaprakash.mts@kongu.ac.in\n\n" +
                    "Mob: 9944586397",
            "Assistant Professor\n\n" +
                    "Department of Electronics and Communication Engineering\n\n" +
                    "Email: sasikalas@kongu.ac.in\n\n" +
                    "Mob: 9952514913",
            "Assistant Professor(SRG)\n\n" +
                    "Department of Computer Science and Engineering\n\n" +
                    "Email: mohanapragash@kongu.ac.in\n\n" +
                    "Mob: 8012187005","Assistant Professor\n\n" +
            "Department of Computer Science and Engineering\n\n" +
            "Email: deepa@kongu.ac.in, deepa.cse@kongu.edu\n\n" +
            "Mob: 9952784664,7868040150","Assistant Professor\n\n" +
            "Department of Information Technology\n\n" +
            "Email: erovijay@kongu.ac.in\n\n" +
            "Mob: 9942013143","Assistant Professor\n\n" +
            "Department of Electrical and Electronics Engineering\n\n" +
            "Email: sivachitra@kongu.ac.in\n\n" +
            "Mob: 8344402476","Assistant Professor\n\n" +
            "Department of Electrical and Electronics Engineering\n\n" +
            "Email: tamilarasu@kongu.ac.in\n\n" +
            "Mob: 9865255912","Professor\n\n" +
            "Department of Electronics and Instrumentation Engineering\n\n" +
            "Email: soamisuba@kongu.ac.in\n\n" +
            "Mob: 9965527506","Assistant Professor\n\n" +
            "Department of Electronics and Instrumentation Engineering\n\n" +
            "Email: mahesh@kongu.ac.in\n\n" +
            "Mob: 9944197349","Assistant Professor\n\n" +
            "Department of Chemical Engineering\n\n" +
            "Email: revathichem@kongu.ac.in\n\n" +
            "Mob: 9487505959","Assistant Professor\n\n" +
            "Department of Food Technology\n\n" +
            "Email: asangeetha.ft@kongu.ac.in\n" +
            "Mob: 9942357599","Assistant Professor\n\n" +
            "Department of Computer Technology - UG\n\n" +
            "Email: brindha@kongu.ac.in\n\n" +
            "Mob: 9865805218","Assistant Professor\n\n" +
            "Department of Computer Technology - PG\n\n" +
            "Email: grsreekanth@kongu.ac.in\n\n" +
            "Mob: 9952574455","Assistant Professor\n\n" +
            "Master of Computer Applications\n\n" +
            "Email: hemalatha@kongu.ac.in\n\n" +
            "Mob: 9786266777","Assistant Professor\n\n" +
            "Department of Management Studies\n\n" +
            "Email: ptp_karthi@kongu.ac.in\n\n" +
            "Mob: 9843641321"};
    int images[] = {R.drawable.dinesh, R.drawable.harikrishna,R.drawable.thangarasu,R.drawable.nithyaprakash,R.drawable.sasikala,R.drawable.mohana,R.drawable.deepa,R.drawable.vijay,R.drawable.sivachitra,R.drawable.tamilarasu,R.drawable.subasri,R.drawable.mahesh,R.drawable.revathi,R.drawable.sangeetha,R.drawable.gokila,R.drawable.sreekanth,R.drawable.hemalatha,R.drawable.karthikeyan};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deptco);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription1, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Chief Patron", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Patron", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Chief Coordinator", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Secretary", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Joint Secretary", Toast.LENGTH_SHORT).show();
                }
                if (position == 0) {
                    Toast.makeText(com.example.darkmode.deptco.this, "Treasurer", Toast.LENGTH_SHORT).show();
                }

            }
        });

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.deptco.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.deptco.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.deptco.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.deptco.this, dark_mode.class));
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
            }
        }
        return super.onOptionsItemSelected(item);
    }



    class MyAdapter extends ArrayAdapter<String> implements ListAdapter {
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
    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawermenu3, menu);
        return true;
    }
}