package com.example.darkmode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity implements View.OnClickListener {



    private EditText editPassword,editEmail;
    private Button buttonLogin;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editEmail=(EditText)findViewById(R.id.editEmail);
        editPassword=(EditText)findViewById(R.id.editPassword);
        buttonLogin=(Button)findViewById(R.id.buttonLogin);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait......");

        buttonLogin.setOnClickListener(this);

        Button buttonOne = findViewById(R.id.button3);
        buttonOne.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Button1 Clicked");
                Intent activity2Intent = new Intent(login.this,com.example.darkmode.signup.class);
                startActivity(activity2Intent);
            }
        });


    }

    private void userLogin()
    {
        final String email = editEmail.getText().toString().trim();
        final String password = editPassword.getText().toString().trim();

        progressDialog.show();

        StringRequest stringRequest= new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                       try{
                        JSONObject obj=new JSONObject(response);
                        if(!obj.getBoolean("error"))
                        {
                            SharedPrefManager.getInstance(getApplicationContext())
                                    .userLogin(obj.getInt("id"),obj.getString("username"),obj.getString("email"));

                            Toast.makeText(getApplicationContext(),"User Login Sucessful",Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),obj.getString("message"),Toast.LENGTH_LONG).show();
                        }


                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      progressDialog.dismiss();
                      Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               Map<String,String> params = new HashMap<>();
               params.put("email",email);
               params.put("password",password);
               return params;
            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }


    @Override
    public void onClick(View view) {
        if(view == buttonLogin)
        {
            userLogin();
        }
    }

}




