package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class GeneralRemedyShow extends AppCompatActivity {
    private TextView displayGR;
    private EditText Remedyshow;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_remedy_show);

        Remedyshow=(EditText) findViewById(R.id.SearchGR) ;
        displayGR=(TextView) findViewById(R.id.displayGR) ;
        displayGR.setMovementMethod(new ScrollingMovementMethod());
        final DBHandler db=new DBHandler(this);

        search=(Button) findViewById(R.id.showGR);



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                List<GeneralRemedy> remedyList=db.getRemedies(Remedyshow.getText().toString());
                String result ="";
                for(GeneralRemedy gr : remedyList)
                {
                    result +="Disease Name : "+gr.getHeading()+"\n"+"Symptoms : "+gr.getSymtomps()+"\n"+"Description : "+gr.getDescription()+"\n"+"Medicine : "+gr.getMedicine();
                    result +="\n\n";

                }
                if(remedyList.size()  == 0)
                {
                    result = "No remedy to display.";
                }
                displayGR.setText(result);



            }
        });




    }
}
