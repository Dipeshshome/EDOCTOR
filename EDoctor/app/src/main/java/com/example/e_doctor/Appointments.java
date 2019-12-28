package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


import static com.example.e_doctor.MyDatabaseHelper.TABLE_NAME1;
import static com.example.e_doctor.MyDatabaseHelper.TABLE_NAME3;

public class Appointments extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="Appointments";
    private TextView mDisplayDate,dateofbirthEdit,result,result2;
    private TextView departmentEdit,doctorEdit,timeEdit;
    SharedPreferences prf;
    Intent intent;
    ImageButton logout;

     private Button confirm,ShowValues;
    String str;
    Spinner spinnerEdit,spinnerEdit1,spinnerEdit2;
    MyDatabaseHelper myDatabaseHelper;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    ArrayAdapter<CharSequence> adapter,adapter1,adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        myDatabaseHelper = new MyDatabaseHelper(this);
        spinnerEdit = new Spinner(this);
        spinnerEdit1 = new Spinner(this);
        spinnerEdit2 = new Spinner(this);
        SQLiteDatabase sqLiteDatabase =myDatabaseHelper.getWritableDatabase();
        SQLiteDatabase sqLiteDatabase2=myDatabaseHelper.getReadableDatabase();
        result = (TextView)findViewById(R.id.resultView);//id
        result2 = (TextView)findViewById(R.id.resultViewid);//name


        prf = getSharedPreferences("user_details",MODE_PRIVATE);

        result2.setText(prf.getString("username",null));
       String s=prf.getString("username",null);

        Cursor cur=  sqLiteDatabase2.rawQuery( "SELECT * FROM " + TABLE_NAME1 + " WHERE     USERNAME=?",new String[]{s} );
        if (cur.moveToFirst()) // data?
            str=cur.getString(0);

        cur.close();
        result.setText(str);

        dateofbirthEdit=(TextView)findViewById(R.id.DOB);
        confirm=(Button) findViewById(R.id.confirmid);
        ShowValues = (Button)findViewById(R.id.list);
        logout=findViewById(R.id.reg);

        confirm.setOnClickListener(this);
        ShowValues.setOnClickListener(this);


        mDisplayDate=(TextView) findViewById(R.id.DOB);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        Appointments.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                SharedPreferences SM = getSharedPreferences("userrecord", 0);
                SharedPreferences.Editor edit = SM.edit();
                edit.putBoolean("userlogin", false);
                edit.commit();
                Intent intent = new Intent(Appointments.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        });
        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet:mm/dd/yyy: "+ month +"/"+day+"/"+year);
                String date = month +"/"+day+"/"+year;
                mDisplayDate.setText(date);

            }
        };

        spinnerEdit=(Spinner)findViewById(R.id.spinner);
        adapter= ArrayAdapter.createFromResource(this,R.array.doctor_department,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit.setAdapter(adapter);
        spinnerEdit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(20);


                String sselected=parent.getItemAtPosition(position).toString();
                //  Toast.makeText(parent.getContext(), "You selected: " + sselected, Toast.LENGTH_LONG).show();
                departmentEdit=(TextView)findViewById(R.id.deptEdit);
                departmentEdit.setText(sselected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerEdit1=(Spinner)findViewById(R.id.spinner1);
        adapter1= ArrayAdapter.createFromResource(this,R.array.doctor_names,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit1.setAdapter(adapter1);
        spinnerEdit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view, int position1, long id1) {
                ((TextView) parent1.getChildAt(0)).setTextSize(20);


                String sselected1=parent1.getItemAtPosition(position1).toString();
                //Toast.makeText(parent1.getContext(),sselected1,Toast.LENGTH_SHORT).show();
                doctorEdit=(TextView)findViewById(R.id.doctorEdit);
                doctorEdit.setText(sselected1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinnerEdit2=(Spinner)findViewById(R.id.spinner2);
        adapter2= ArrayAdapter.createFromResource(this,R.array.appointment_time,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit2.setAdapter(adapter2);
        spinnerEdit2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(20);


                String sselected=parent.getItemAtPosition(position).toString();
                //  Toast.makeText(parent.getContext(), "You selected: " + sselected, Toast.LENGTH_LONG).show();
                timeEdit=(TextView)findViewById(R.id.timeEdit);
                timeEdit.setText(sselected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        String userid=result2.getText().toString();
        String username=result.getText().toString();
        String department=departmentEdit.getText().toString();
        String date=dateofbirthEdit.getText().toString();
        String time=timeEdit.getText().toString();
        String doctor=doctorEdit.getText().toString();
        SQLiteDatabase sqLiteDatabaseR=myDatabaseHelper.getReadableDatabase();
        if(view.getId()==R.id.confirmid) {

            Cursor cursor=  sqLiteDatabaseR.rawQuery( "SELECT * FROM " + TABLE_NAME3 + " WHERE     APPOINTDATE=? AND APPOINTTIME=? AND DOCTOR_USERNAME=?", new String[]{date,time,doctor});
            if(cursor.getCount() > 0){
                Toast.makeText(getApplicationContext(),"Appointment Not Available on this Date",Toast.LENGTH_LONG).show();
            }
            else{
                long rowId= (long) myDatabaseHelper.insertData_appointment(userid,username,doctor,department,date,time);
                if(rowId==-1){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(getApplicationContext(),"Appointment Confirmed",Toast.LENGTH_LONG).show();
                }
            }


        }

        if (view.getId()==R.id.list){

           // Cursor cursor=  sqLiteDatabaseR.rawQuery( "SELECT * FROM " + TABLE_NAME3 , null);
           Cursor cursor=myDatabaseHelper.displayAllData();

            if(cursor.getCount()==0){
                showData("Error ","No Data Found");
                return;
            }

            StringBuffer stringBuffer= new StringBuffer();
            while(cursor.moveToNext()){
                stringBuffer.append("Appointmnet_ID:"+cursor.getString(0)+"\n");
                stringBuffer.append("PatientName:"+cursor.getString(1)+"\n");
                stringBuffer.append("Department:"+cursor.getString(3)+"\n");
                stringBuffer.append("DoctorName:"+cursor.getString(4)+"\n");
                stringBuffer.append("Appointmnet_Time:"+cursor.getString(6)+"\n");
                stringBuffer.append("Appointmnet_Date:"+cursor.getString(5)+"\n\n");
                stringBuffer.append("-----------------------------------------\n");
            }
    showData("Your Appointments",stringBuffer.toString());

        }


    }

    public void showData(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

}
