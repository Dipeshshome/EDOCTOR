package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeDoctor extends AppCompatActivity {
    ViewFlipper fliiper;
    Button register,login;
    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_doctor);
        register=(Button)findViewById(R.id.registration);
        uname = (EditText)findViewById(R.id.txtName);
        pwd = (EditText)findViewById(R.id.txtPwd);
        loginBtn = (Button)findViewById(R.id.btnLogin);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(HomeDoctor.this,DoctorAccess.class);
        if(pref.contains("email") && pref.contains("password")){
            startActivity(intent);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();
                boolean result=myDatabaseHelper.loginCheck2(username,password);
                if(result==true){
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",username);
                    editor.putString("password",password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();

                }

            }
        });
        //login=(Button)findViewById(R.id.login);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i= new Intent(HomeDoctor.this,Doctorprofile.class);
                startActivity(i);
            }


        });
    }
}
