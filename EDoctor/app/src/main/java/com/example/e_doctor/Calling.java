package com.example.e_doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.e_doctor.R.id.image_call;

public class Calling extends AppCompatActivity {
    private  static  final  int REQUEST_CALL=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);
        ImageButton imagecall=findViewById(image_call);
        imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });

    }

    private  void makePhoneCall(){
        String number="16484";
        if (number.trim().length()>0){
            if (number.trim().length()>0){
                if (ContextCompat.checkSelfPermission(Calling.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(Calling.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }else {
                    String dial="tel:" + number;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
            //else {

            //}
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();

            }
        }
    }
}
