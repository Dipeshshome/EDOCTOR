package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Completeprofile extends AppCompatActivity {
    Button users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completeprofile);
        users=(Button)findViewById(R.id.completeprofile);
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i= new Intent(Completeprofile.this,Userprofile.class);
                startActivity(i);
            }


        });
    }
}
