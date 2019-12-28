package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Userprofile extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="Userprofile";
    private TextView mDisplayDate,dateofbirthEdit,cityEdit,bloodgroupEdit;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner spinnerEdit,spinnerEdit1;
    private EditText fullnameEdit,usernameEdit,emailEdit,passwordEdit,contactnoEdit,heightEdit,weightEdit;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private RadioGroup genderGroup;
    private RadioButton genderButton;
    private Button button;
    String gender;
    MyDatabaseHelper myDatabaseHelper;
    ArrayAdapter<CharSequence> adapter,adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        myDatabaseHelper = new MyDatabaseHelper(this);
        spinnerEdit = new Spinner(this);
        spinnerEdit1 = new Spinner(this);
        SQLiteDatabase sqLiteDatabase=myDatabaseHelper.getWritableDatabase();
        fullnameEdit=(EditText)findViewById(R.id.fullnameid);
        usernameEdit=(EditText)findViewById(R.id.usernameid);
        emailEdit=(EditText)findViewById(R.id.emailid);
        passwordEdit=(EditText)findViewById(R.id.passwordid);
        heightEdit=(EditText)findViewById(R.id.heightEdit);
        weightEdit=(EditText)findViewById(R.id.weightEdit);
        passwordEdit=(EditText)findViewById(R.id.passwordid);
        genderGroup= (RadioGroup) findViewById(R.id.genderid);
        button= (Button) findViewById(R.id.registerid);
        button.setOnClickListener(this);
        dateofbirthEdit=(TextView)findViewById(R.id.DOB);

       contactnoEdit=(EditText)findViewById(R.id.contact) ;




        mDisplayDate=(TextView) findViewById(R.id.DOB);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month= cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        Userprofile.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();



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
        adapter= ArrayAdapter.createFromResource(this,R.array.blood_groups,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit.setAdapter(adapter);
        spinnerEdit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sselected=parent.getItemAtPosition(position).toString();
              //  Toast.makeText(parent.getContext(), "You selected: " + sselected, Toast.LENGTH_LONG).show();
                bloodgroupEdit=(TextView)findViewById(R.id.blood);
                bloodgroupEdit.setText(sselected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerEdit1=(Spinner)findViewById(R.id.spinner1);
        adapter1= ArrayAdapter.createFromResource(this,R.array.city_names,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEdit1.setAdapter(adapter1);
        spinnerEdit1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent1, View view, int position1, long id1) {
                String sselected1=parent1.getItemAtPosition(position1).toString();
               //Toast.makeText(parent1.getContext(),sselected1,Toast.LENGTH_SHORT).show();
                cityEdit=(TextView)findViewById(R.id.city);
                cityEdit.setText(sselected1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    @Override
    public void onClick(View view) {

        String fullname=fullnameEdit.getText().toString();
        String username=usernameEdit.getText().toString();
        String email=emailEdit.getText().toString();
        String password=passwordEdit.getText().toString();
        gender=genderButton.getText().toString();
        String dateofbirth=dateofbirthEdit.getText().toString();
        String bloodgroup=bloodgroupEdit.getText().toString();
        String height=heightEdit.getText().toString();
        String weight=weightEdit.getText().toString();
        String city=cityEdit.getText().toString();
        String contactno=contactnoEdit.getText().toString();

   boolean res=false;

        if(view.getId()==R.id.registerid){
            if (emailEdit.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(),"Email is Empty",Toast.LENGTH_SHORT).show();
            }
            else {
                if (emailEdit.getText().toString().trim().matches(emailPattern)) {
                    //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                    res=true;
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                }
            }

             if(res==true){
                 long rowId= (long) myDatabaseHelper.insertData_reg(fullname,username,email,password,gender,height,weight,dateofbirth,bloodgroup,city,contactno);
                 if(rowId==-1){
                     Toast.makeText(getApplicationContext(),"Yor are not registered",Toast.LENGTH_LONG).show();
                 }
                 else {
                     Toast.makeText(getApplicationContext(),"Yor are now registered",Toast.LENGTH_LONG).show();
                 }
             }

        }

    }

    public void checkButton(View view) {

        int radioId=genderGroup.getCheckedRadioButtonId();
        genderButton=findViewById(radioId);
        gender=genderButton.getText().toString();
    }
}
