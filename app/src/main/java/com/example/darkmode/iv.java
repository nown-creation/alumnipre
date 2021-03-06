package com.example.darkmode;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.makeText;

public class iv extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private EditText editEmail,editPhone,editFirstname,editLastname,editBranch,editPass,editCompany,editOffering,editadd,editcity,editzip;
    private CheckBox cmechanical,cmechatronics,ccivil,ccse,cchemical,cei,ceee,cece,cft,cbsc,cmsc,cmba,cautomobile;
    private Spinner editcountry;
    private Button buttonRegister;
    private ProgressDialog progressDialog;
    private ArrayList<String> result;

    private String checkBoxChoices ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iv);

        editFirstname=(EditText)findViewById(R.id.firstname);
        editLastname=(EditText)findViewById(R.id.lastname);
        editEmail=(EditText)findViewById(R.id.email);
        editPass=(EditText)findViewById(R.id.pass);
        editPhone=(EditText)findViewById(R.id.phonenumber);
        editBranch=(EditText)findViewById(R.id.branch);
        editCompany=(EditText)findViewById(R.id.company);
        editcountry=(Spinner)findViewById(R.id.country);
        editOffering=(EditText)findViewById(R.id.offering);
        editadd=(EditText)findViewById(R.id.address);
        editzip=(EditText)findViewById(R.id.zip);
        editcity=(EditText)findViewById(R.id.city);

        cmechanical=(CheckBox)findViewById(R.id.mechanical);
        cmechatronics=(CheckBox)findViewById(R.id.mechatronics);
        ccivil=(CheckBox)findViewById(R.id.civil);
        cei=(CheckBox)findViewById(R.id.ei);
        ceee=(CheckBox)findViewById(R.id.eee);
        cece=(CheckBox)findViewById(R.id.ece);
        ccse=(CheckBox)findViewById(R.id.cse);
        cft=(CheckBox)findViewById(R.id.ft);
        cchemical=(CheckBox)findViewById(R.id.chemical);
        cbsc=(CheckBox)findViewById(R.id.bsc);
        cmsc=(CheckBox)findViewById(R.id.msc);
        cmba=(CheckBox)findViewById(R.id.mba);
        cautomobile=(CheckBox)findViewById(R.id.automobile);






        buttonRegister=(Button)findViewById(R.id.buttonRegister);

        progressDialog=new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.notify:
                        startActivity(new Intent(com.example.darkmode.iv.this, com.example.darkmode.notify.class));
                        return true;

                    case R.id.terms:
                        startActivity(new Intent(com.example.darkmode.iv.this, com.example.darkmode.terms.class));
                        return true;

                    case R.id.privacy:
                        startActivity(new Intent(com.example.darkmode.iv.this, com.example.darkmode.policy.class));
                        return true;

                    case R.id.mode:
                        startActivity(new Intent(com.example.darkmode.iv.this, dark_mode.class));
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

    private void ivForm()
    {

        final String firstname=editFirstname.getText().toString().trim();
        final String lastname=editLastname.getText().toString().trim();
        final String email=editEmail.getText().toString().trim();
        final String pass=editPass.getText().toString().trim();
        final String phonenumber=editPhone.getText().toString().trim();
        final String branch=editBranch.getText().toString().trim();
        final String company=editCompany.getText().toString().trim();
        final String offering=editOffering.getText().toString().trim();
        final String country=editcountry.getSelectedItem().toString();
        final String zip=editzip.getText().toString();
        final String city=editcity.getText().toString();
        final String add=editadd.getText().toString();


        checkBoxChoices = "";

        if (cmba.isChecked()) {
            checkBoxChoices += cmba.getText().toString() + " ";
        }

        if (cmechanical.isChecked()) {
            checkBoxChoices += cmechanical.getText().toString() + " ";
        }

        if (cmechatronics.isChecked()) {
            checkBoxChoices += cmechatronics.getText().toString() + " ";
        }

        if (cece.isChecked()) {
            checkBoxChoices += cece.getText().toString() + " ";
        }
        if (ceee.isChecked()) {
            checkBoxChoices += ceee.getText().toString() + " ";
        }
        if (cei.isChecked()) {
            checkBoxChoices += cei.getText().toString() + " ";
        }
        if (cautomobile.isChecked()) {
            checkBoxChoices += cautomobile.getText().toString() + " ";
        }
        if (cft.isChecked()) {
            checkBoxChoices += cft.getText().toString() + " ";
        }
        if (cbsc.isChecked()) {
            checkBoxChoices += cbsc.getText().toString() + " ";
        }
        if (cmsc.isChecked()) {
            checkBoxChoices += cmsc.getText().toString() + " ";
        }
        if (ccse.isChecked()) {
            checkBoxChoices += ccse.getText().toString() + " ";
        }
        if (cchemical.isChecked()) {
            checkBoxChoices += cchemical.getText().toString() + " ";
        }
        if (ccivil.isChecked()) {
            checkBoxChoices += ccivil.getText().toString() + " ";
        }

        final String member=checkBoxChoices;






        progressDialog.setMessage("Registering User.....");
        progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL_IVFORM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try
                {
                    JSONObject jsonObject=new JSONObject(response);

                    makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();

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

                params.put("firstName",firstname);
                params.put("lastName",lastname);
                params.put("email",email);
                params.put("year",pass);
                params.put("branch",branch);
                params.put("phoneNumber",phonenumber);
                params.put("company",company);
                params.put("offering",offering);
                params.put("dept",member);
                params.put("country",country);
                params.put("zip",zip);
                params.put("city",city);
                params.put("address",add);
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
            ivForm();
        }
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