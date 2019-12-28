package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Button users, doctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loginas);
        users = (Button) findViewById(R.id.patients);
        doctor = (Button) findViewById(R.id.doctor);
        users.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, Loginas.class);
                startActivity(i);
            }


        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, DoctorAccess.class);
                startActivity(i);
            }


        });

    }
}
