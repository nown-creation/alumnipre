package com.example.darkmode;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    ListView listView;
    public static ArrayList<Event> SubjectList = new ArrayList<Event>();
    String HttpURL = "http://192.168.43.108/Alumni/event.php";
    EventAdapter listAdapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listView = (ListView) findViewById(R.id.listView1);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        listView.setTextFilterEnabled(true);

        new ParseJSonDataClass(this).execute();



    }

    private class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;

        public ParseJSonDataClass(Context context) {

            this.context = context;
        }

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            HttpServiceClass httpServiceClass = new HttpServiceClass(HttpURL);

            try {
                httpServiceClass.ExecutePostRequest();

                if (httpServiceClass.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClass.getResponse();

                    if (FinalJSonResult != null) {

                        JSONArray jsonArray = null;
                        try {

                            jsonArray = new JSONArray(FinalJSonResult);

                            JSONObject jsonObject;

                            Event user;

                            SubjectList = new ArrayList<Event>();

                            for (int i = 0; i < jsonArray.length(); i++) {

                                jsonObject = jsonArray.getJSONObject(i);

                                String tempDate = jsonObject.getString("Date").toString();

                                String tempEvent = jsonObject.getString("Event").toString();

                                String tempPlace = jsonObject.getString("Place").toString();

                                String tempTime = jsonObject.getString("Time").toString();



                                user = new Event(tempDate,tempEvent,tempTime,tempPlace);

                                SubjectList.add(user);
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {

                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            progressBar.setVisibility(View.INVISIBLE);
            listAdapter = new EventAdapter(EventsActivity.this, R.layout.list_layout, SubjectList);
            listView.setAdapter(listAdapter);
        }
    }
}