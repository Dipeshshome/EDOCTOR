package com.example.e_doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class BlogShow extends AppCompatActivity {
    private TextView displayBlog;
    Button blog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_show);

              displayBlog=(TextView) findViewById(R.id.displayBlog) ;
        blog=findViewById(R.id.bid);
        displayBlog.setMovementMethod(new ScrollingMovementMethod());
        final DBHandler db=new DBHandler(this);




        List<BlogInsert> blogList=db.getBlogs();
        String result ="";
        for(BlogInsert blogs : blogList)
        {
            result +="Heading : "+blogs.getHeading()+"\n"+"Experience : "+blogs.getExperience()+"\n"+"Motivation : "+blogs.getMotivation()+"\n"+"Advice : "+blogs.getAdvice();
            result +="\n\n";

        }
        if(blogList.size()  == 0)
        {
            result = "No blog to display.";
        }
        displayBlog.setText(result);


        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Starting Your Journey",Toast.LENGTH_LONG).show();

                intent=new Intent(BlogShow.this,blog.class);

                    startActivity(intent);

            }
        });




    }
}
