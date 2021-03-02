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

import static android.widget.Toast.makeText;

public class signup extends AppCompatActivity implements View.OnClickListener {



    private EditText editUsername,editPassword,editEmail,editPhone,editFirstname,editLastname,editCPassword;
    private Button buttonRegister;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editEmail=(EditText)findViewById(R.id.email);
        editUsername=(EditText)findViewById(R.id.username);
        editPassword=(EditText)findViewById(R.id.password);
        editPhone=(EditText)findViewById(R.id.phonenumber);
        editFirstname=(EditText)findViewById(R.id.firstname);
        editLastname=(EditText)findViewById(R.id.lastname);
        editCPassword=(EditText)findViewById(R.id.cpassword);


        buttonRegister=(Button)findViewById(R.id.buttonRegister);

        progressDialog=new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);


    }

    private void registerUser()
    {
        final String email=editEmail.getText().toString().trim();
        final String username=editUsername.getText().toString().trim();
        final String password=editPassword.getText().toString().trim();
        final String cpassword=editCPassword.getText().toString().trim();
        final String firstname=editFirstname.getText().toString().trim();
        final String lastname=editLastname.getText().toString().trim();
        final String phonenumber=editPhone.getText().toString().trim();

        progressDialog.setMessage("Registering User.....");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try
                {
                    JSONObject jsonObject=new JSONObject(response);

                    Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();

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
                        progressDialog.hide();
                        makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("userName",username);
                params.put("email",email);
                params.put("password",password);
                params.put("firstName",firstname);
                params.put("lastName",lastname);
                params.put("phoneNumber",phonenumber);
                params.put("cpassword",cpassword);
                return params;
            }
        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);

    }

    @Override
    public void onClick(View view)
    {
        if(view==buttonRegister)
        {
            registerUser();
        }

    }


}