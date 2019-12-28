package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class blog extends AppCompatActivity {


    private Button submitBlog;
    private EditText blogHeading,blogExperience,blogMotivation,blogAdvice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);


        blogHeading=(EditText) findViewById(R.id.blogHeading);
        blogExperience=(EditText) findViewById(R.id.blogExperience);
        blogMotivation=(EditText) findViewById(R.id.blogMotivation);
        blogAdvice=(EditText) findViewById(R.id.blogAdvice);

        submitBlog=(Button) findViewById(R.id.submitBlog);


        final DBHandler db=new DBHandler(this);


        submitBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String heading=blogHeading.getText().toString();
                String experience=blogExperience.getText().toString();
                String motivation=blogMotivation.getText().toString();
                String advice=blogAdvice.getText().toString();




                if(heading.equals("") || experience.equals("") || motivation.equals("")   || blogAdvice.equals("") )
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.BlogInsert(new BlogInsert(heading,experience,motivation,advice));
                    Toast.makeText (getApplicationContext(),"New Data Is Added.",Toast.LENGTH_SHORT).show();
                }
//                Intent donor_to_searchordonor=new Intent(DonorRegistrationActivity.this,SearchOrDonor.class);
//                startActivity(donor_to_searchordonor);




            }
        });
    }
}
