package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AdminRegistration extends AppCompatActivity {

    private Button submitAdmin;
    private EditText fname,lname,age,address,number,sign_up_email,sign_up_password,a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);





        submitAdmin = (Button) findViewById(R.id.submitAdmin);
        fname=(EditText) findViewById(R.id.firstname);
        lname=(EditText) findViewById(R.id.lastname);
        age=(EditText) findViewById(R.id.age) ;
        address=(EditText)findViewById(R.id.address) ;
        number=(EditText) findViewById(R.id.number) ;
        sign_up_password = (EditText) findViewById(R.id.sign_up_password);
        sign_up_email = (EditText) findViewById(R.id.sign_up_email);


        final DBHandler db=new DBHandler(this);

        submitAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _fname=fname.getText().toString();
                String _lname=lname.getText().toString();

                String _age=age.getText().toString();

                String _address=address.getText().toString();
                String _number=number.getText().toString();
                String userPasswordValue= sign_up_password.getText().toString();
                String userEmailValue= sign_up_email.getText().toString();


                if(_fname.equals("") || _lname.equals("") || _age.equals("")   || _address.equals("") || _number.equals("") || userEmailValue.equals("") || userPasswordValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addAdmin(new admin(_fname,_lname,_age,_address,_number,userEmailValue,userPasswordValue));
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();
                }
//                Intent donor_to_searchordonor=new Intent(DonorRegistrationActivity.this,SearchOrDonor.class);
//                startActivity(donor_to_searchordonor);




            }
        });



    }
}
