package com.example.e_doctor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static com.example.e_doctor.MyDatabaseHelper.TABLE_NAME3;

public class DoctorAccess extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageButton;
    SharedPreferences pref;
    Intent intent;
    CardView appointment,prescription;
    MyDatabaseHelper myDatabaseHelper;
String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_access);
        myDatabaseHelper = new MyDatabaseHelper(this);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        s=pref.getString("username",null);
        imageButton=(ImageButton)findViewById(R.id.reg);
        appointment=findViewById(R.id.appontmentlist);
        prescription=findViewById(R.id.prescription);
       appointment.setOnClickListener(this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent i= new Intent(DoctorAccess.this,HomeDoctor.class);
                startActivity(i);
            }


        });



        prescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();
                Intent in= new Intent(DoctorAccess.this,Prescription.class);
                intent=new Intent(DoctorAccess.this,HomeDoctor.class);
                if(pref.contains("username") && pref.contains("password")){
                    startActivity(in);
                }
                else{
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onClick(View view) {


        if (view.getId()==R.id.appontmentlist){
          // SQLiteDatabase sqLiteDatabase =myDatabaseHelper.getWritableDatabase();
            Cursor cursor=myDatabaseHelper.displayAllData();
            intent=new Intent(DoctorAccess.this,HomeDoctor.class);
            if(pref.contains("username") && pref.contains("password")){
                //startActivity(in);

                //Cursor cursor=  sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME3 + " WHERE    DOCTOR_USERNAME='Biju' ",null);
                // Cursor cursor=myDatabaseHelper.displayAllData();

                if(cursor.getCount()==0){
                    showData("Error ","No Data Found");
                    return;
                }

                StringBuffer stringBuffer= new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("Appointmnet_ID:"+cursor.getString(0)+"\n");
                    stringBuffer.append("PatientName:"+cursor.getString(1)+"\n");
                    stringBuffer.append("Appointmnet_Time:"+cursor.getString(6)+"\n");
                    stringBuffer.append("Appointmnet_Date:"+cursor.getString(5)+"\n\n");
                    stringBuffer.append("-----------------------------------------\n");
                }
                showData("Your Appointments",stringBuffer.toString());
            }
            else{
                startActivity(intent);
            }




        }


    }

    private void showData(String title, String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }
}
