package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Loginas extends AppCompatActivity {
     MyDatabaseHelper myDatabaseHelper;
    CardView createappointment,remedy,blog;
    CardView callservice;
    SharedPreferences pref;
    Intent intent;
    ViewFlipper fliiper;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        imageButton=(ImageButton)findViewById(R.id.reg);
        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
        fliiper = findViewById(R.id.v_fliiper);
        createappointment=findViewById(R.id.appontmentcreate);
        remedy=findViewById(R.id.remedy);
        blog=findViewById(R.id.blog);
        callservice=findViewById(R.id.call);

        for (int image : images) {
            flipperImages(image);

        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i= new Intent(Loginas.this,Home.class);
                startActivity(i);
            }


        });


        createappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent in= new Intent(Loginas.this,Appointments.class);
                intent=new Intent(Loginas.this,Home.class);
                if(pref.contains("username") && pref.contains("password")){
                    startActivity(in);
                }
                else{
                    startActivity(intent);
                }
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent in= new Intent(Loginas.this,blog.class);
                intent=new Intent(Loginas.this,Home.class);
                if(pref.contains("username") && pref.contains("password")){
                    startActivity(in);
                }
                else{
                    startActivity(intent);
                }
            }
        });
        remedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent in= new Intent(Loginas.this,GeneralRemedyShow.class);
                intent=new Intent(Loginas.this,Home.class);
                if(pref.contains("username") && pref.contains("password")){
                    startActivity(in);
                }
                else{
                    startActivity(intent);
                }
            }
        });

        callservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent in= new Intent(Loginas.this,Calling.class);
                intent=new Intent(Loginas.this,Home.class);
                if(pref.contains("username") && pref.contains("password")){
                    startActivity(in);
                }
                else{
                    startActivity(intent);
                }
            }
        });


    }

    public  void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        fliiper.addView(imageView);
        fliiper.setFlipInterval(4000);
        fliiper.setAutoStart(true);
        fliiper.setInAnimation(this,android.R.anim.slide_in_left);
        fliiper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    }

