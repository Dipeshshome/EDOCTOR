package com.example.e_doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class AdminActivity extends AppCompatActivity {


    private Button signUp_,signIn_;
    private EditText admin_email_,admin_password_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        signUp_=(Button) findViewById(R.id.sign_up);
        signIn_=(Button) findViewById(R.id.sign_in);
        admin_email_=(EditText) findViewById(R.id.admin_email) ;
        admin_password_=(EditText) findViewById(R.id.admin_password) ;

        final DBHandler db=new DBHandler(this);



        signIn_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String signInadminemail=admin_email_.getText().toString();
                String signInadminpassword=admin_password_.getText().toString();

                if(signInadminemail.equals("")|| signInadminpassword.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing", Toast.LENGTH_SHORT).show();
                }
                else {

                    Boolean result=db.loginCheck(signInadminemail,signInadminpassword);
                    if(result==true)
                    {
                        Toast.makeText (getApplicationContext(),"log in successfully.", Toast.LENGTH_SHORT).show();
//                        Intent home_to_searchordonor=new Intent(HomeActivity.this,SearchOrDonor.class);
//                        startActivity(home_to_searchordonor);
                    }
                    else
                        Toast.makeText (getApplicationContext(),"username & password didn't match.", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}
