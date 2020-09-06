package com.harshit.taskhub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.harshit.taskhub.Config.Config;
import com.harshit.taskhub.utils.SharedPreferenceValue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    private ImageView logo, ivSignIn;
    private AutoCompleteTextView email, password;
    private TextView forgotPass, signUp;
    private Button btnSignIn;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeGUI();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inEmail = email.getText().toString();
                String inPassword = password.getText().toString();

                if(validateInput(inEmail, inPassword)){
                    signUser(inEmail, inPassword);
                }

            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,PWresetActivity.class));
            }
        });



    }


//signin
    public void signUser(String email, String password){
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

            Map<String, String> params = new HashMap<>();
            params.put("email", email);
            params.put("password", password);
            JsonObjectRequest request_json = new JsonObjectRequest(Config.LOGIN, new JSONObject(params),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //Process os success response
                            try {

                                String token = response.getString("token").toString();
                                SharedPreferenceValue.updatToken(getApplicationContext(),token);
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));

                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.d("loginError",e.toString());

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.e("Error: ", error.toString());
                            Log.d("loginErrorVolly",error.toString());
                        }
                    });
            requestQueue.add(request_json);

        }




//init
    private void initializeGUI(){

        logo = findViewById(R.id.ivLogLogo);
        ivSignIn = findViewById(R.id.ivSignIn);
        email = findViewById(R.id.atvEmailLog);
        password = findViewById(R.id.atvPasswordLog);
        forgotPass = findViewById(R.id.tvForgotPass);
        signUp = findViewById(R.id.tvSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);
        progressDialog = new ProgressDialog(this);


    }

//validating
    public boolean validateInput(String inemail, String inpassword){

        if(inemail.isEmpty()){
            email.setError("Email field is empty.");
            return false;
        }
        if(inpassword.isEmpty()){
            password.setError("Password is empty.");
            return false;
        }

        return true;
    }

}
