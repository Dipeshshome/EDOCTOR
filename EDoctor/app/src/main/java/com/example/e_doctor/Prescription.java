package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Prescription extends AppCompatActivity {
    private Button submitPrescription;
    private EditText fullname,  disease, date,weight,age,bp,hr,pmedicine,exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        fullname=(EditText) findViewById(R.id.patientname);
        age=(EditText) findViewById(R.id.patientage);
        weight=(EditText) findViewById(R.id.patientweight);
        date=(EditText) findViewById(R.id.date);
        disease=(EditText) findViewById(R.id.disease);
        bp=(EditText) findViewById(R.id.bp);
        hr=(EditText) findViewById(R.id.hr);
        pmedicine=(EditText) findViewById(R.id.patientmedicine);
        exam=(EditText) findViewById(R.id.exam);




        submitPrescription=(Button) findViewById(R.id.submitPrescription);


        final DBHandler db1=new DBHandler(this);


        submitPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String patientname=fullname.getText().toString();
                String patientage=age.getText().toString();
                String patientweight=weight.getText().toString();
                String patientdate=date.getText().toString();
                String patientdisease=disease.getText().toString();
                String patientbp=bp.getText().toString();
                String patienthr=hr.getText().toString();
                String patientmedicine=pmedicine.getText().toString();
                String patientexam=exam.getText().toString();
                //Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();



                if(patientname.equals("") || patientage.equals("") || patientweight.equals("")   || patientdate.equals("")  || patientdisease.equals("") || patientbp.equals("")|| patienthr.equals("")|| patientmedicine.equals("")|| patientexam.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();

                    db1.PrescriptionInsert(new PatientPrescription(patientname, patientage, patientweight,patientdate,patientdisease,patientbp,patienthr, patientmedicine, patientexam));
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();
                }
//                Intent donor_to_searchordonor=new Intent(DonorRegistrationActivity.this,SearchOrDonor.class);
//                startActivity(donor_to_searchordonor);




            }
        });

    }
}
