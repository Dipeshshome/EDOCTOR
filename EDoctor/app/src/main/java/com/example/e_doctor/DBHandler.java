package com.example.e_doctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="prescription2";
//	private static final String TABLE_NAME="Sign_Up";


//admin reg
    private static final String TABLE_NAME1="Admin_Reg";

    private static final String KEY_Address="address";

    private static final String KEY_ID="id";
    private static final String KEY_FirstNAME="firstname";
    private static final String KEY_LastNAME="lastname";
    //	private static final String KEY_Blood="";
  
    private static final String KEY_Age="age";

    private static final String KEY_CONTACTNO="phoneNo";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";
    //blog insert


    private static final String TABLE_NAME2="blog_insert";

    private static final String KEY_BlogId="BlogId";

    private static final String KEY_BlogHeading="BlogHeading";
    private static final String KEY_Experience="Experience";
    private static final String KEY_Motivate="Motivation";
    private static final String KEY_Advice="advice";
//general remedy insert

    private static final String TABLE_NAME3="generalRemedy_insert";

    private static final String KEY_RemedyId="RemedyId";

    private static final String KEY_RemedyHeading="RemedyHeading";
    private static final String KEY_RemedySymptomps="Symptoms";
    private static final String KEY_RemedyDescription="Description";
    private static final String KEY_RemedyMedicine="Medicine";


    //prescription insert

    private static final String TABLE_NAME4="prescription_insert";
    private static final String KEY_PrescriptionId="PrescriptionId";

    private static final String KEY_PatientNAME="FULLNAME";
    private static final String KEY_PatientAGE="AGE";
    private static final String KEY_PatientWeight="Weight";
    private static final String KEY_Date="Date";
    private static final String KEY_Disease="Disease";
    private static final String KEY_BP="BloodPressure";
    private static final String KEY_HR="HeartRate";
    private static final String KEY_Medicine="Medicine";
    private static final String KEY_Exam="Exam";



    Context context;

    public DBHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Toast.makeText (context,"create table",Toast.LENGTH_LONG).show();

        String sql1= "CREATE TABLE "+TABLE_NAME1+" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,  "+KEY_FirstNAME+" TEXT, "+KEY_LastNAME+" TEXT,"+KEY_Age+" TEXT,"+KEY_Address+" TEXT, "+KEY_CONTACTNO+" TEXT,"+KEY_EMAIL+" TEXT,"+KEY_PASSWORD+" TEXT);";
        sqLiteDatabase.execSQL(sql1);

        String sql2= "CREATE TABLE "+TABLE_NAME2+" ("+KEY_BlogId+" INTEGER PRIMARY KEY AUTOINCREMENT,  "+KEY_BlogHeading+" TEXT, "+KEY_Experience+" TEXT,"+KEY_Motivate+" TEXT, "+KEY_Advice+" TEXT);";
        sqLiteDatabase.execSQL(sql2);

        String sql3= "CREATE TABLE "+TABLE_NAME3+" ("+KEY_RemedyId+" INTEGER PRIMARY KEY AUTOINCREMENT,  "+KEY_RemedyHeading+" TEXT, "+KEY_RemedySymptomps+" TEXT,"+KEY_RemedyDescription+" TEXT, "+KEY_RemedyMedicine+" TEXT);";
        sqLiteDatabase.execSQL(sql3);


        String sql4= "CREATE TABLE "+TABLE_NAME4+" ("+KEY_PrescriptionId+" INTEGER PRIMARY KEY AUTOINCREMENT,  "+KEY_PatientNAME+" TEXT, "+KEY_PatientAGE+" TEXT,"+KEY_PatientWeight+" TEXT, "+KEY_Date+" TEXT ,"+KEY_Disease+" TEXT ,"+KEY_BP+" TEXT,"+KEY_HR+" TEXT ,"+KEY_Medicine+" TEXT,"+KEY_Exam+" TEXT);";

       // ,"+KEY_Disease+" TEXT,"+KEY_BP+"TEXT, "+KEY_HR+"TEXT, "+KEY_Medicine+" TEXT,"+KEY_Exam+"TEXT
        sqLiteDatabase.execSQL(sql4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean loginCheck(String adminemail, String adminpassword)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        Boolean result=false;
        while (cursor.moveToNext())
        {
            String uemail=cursor.getString(6);
            String upassword=cursor.getString(7);
            if(uemail.equals(adminemail) && upassword.equals(adminpassword))
            {
                result=true;
                break;
            }
        }

        return result;
    }

    public void addAdmin(admin admin) {
        SQLiteDatabase db = this.getWritableDatabase();

//		Log.d("myTag",  admin.get_fname());

        ContentValues value1=new ContentValues();
        value1.put(KEY_FirstNAME, admin.get_fname());
        value1.put(KEY_LastNAME, admin.get_lname());
        value1.put(KEY_Age, admin.get_age());
        value1.put(KEY_Address,admin.get_address());
        value1.put(KEY_CONTACTNO,admin.get_phoneNumber());

        value1.put(KEY_EMAIL, admin.get_email());
        value1.put(KEY_PASSWORD, admin.get_password());

        db.insert(TABLE_NAME1, null,value1);

        db.close();


    }


//blog insert

    public void BlogInsert(BlogInsert blogInsert) {
        SQLiteDatabase db1 = this.getWritableDatabase();

//		Log.d("myTag",  admin.get_fname());

        ContentValues value1=new ContentValues();
        value1.put(KEY_BlogHeading, blogInsert.getHeading());
        value1.put(KEY_Experience, blogInsert.getExperience());
        value1.put(KEY_Motivate, blogInsert.getMotivation());
        value1.put(KEY_Advice,blogInsert.getAdvice());


        db1.insert(TABLE_NAME2, null,value1);

        db1.close();


    }
//remedy insert

    public void RemedyInsert(GeneralRemedy gr) {
        SQLiteDatabase db = this.getWritableDatabase();

//		Log.d("myTag",  admin.get_fname());

        ContentValues value1=new ContentValues();
        value1.put(KEY_RemedyHeading, gr.getHeading());
        value1.put(KEY_RemedySymptomps, gr.getSymtomps());
        value1.put(KEY_RemedyDescription, gr.getDescription());
        value1.put(KEY_RemedyMedicine,gr.getMedicine());


        db.insert(TABLE_NAME3, null,value1);

        db.close();


    }
//prescription insert


    public void PrescriptionInsert(PatientPrescription prescription) {
        SQLiteDatabase db = this.getWritableDatabase();

//		Log.d("myTag",  admin.get_fname());

        ContentValues value1=new ContentValues();
        value1.put(KEY_PatientNAME, prescription.getFullname());
        value1.put(KEY_PatientAGE, prescription.getAge());
        value1.put(KEY_PatientWeight, prescription.getWeight());
        value1.put(KEY_Date, prescription.getDate());
        value1.put(KEY_Disease, prescription.getDisease());
        value1.put(KEY_BP, prescription.getBp());
        value1.put(KEY_HR, prescription.getHr());
        value1.put(KEY_Medicine, prescription.getMedicine());
        value1.put(KEY_Exam, prescription.getExam());



        db.insert(TABLE_NAME4, null,value1);

        db.close();


    }




//blog show
    public List<BlogInsert> getBlogs()
    {
        List<BlogInsert> BlogList=new ArrayList<>();


        String selectquery="SELECT * FROM "+TABLE_NAME2+"";
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                BlogInsert blogshow= new BlogInsert(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                BlogList.add(blogshow);
            }while(cursor.moveToNext());
        }

        return BlogList;
    }









    //remedy show
    public List<GeneralRemedy> getRemedies(String remedy)
    {
        List<GeneralRemedy> remedyList=new ArrayList<>();


        String selectquery="SELECT * FROM "+TABLE_NAME3+" WHERE "+KEY_RemedyHeading+" LIKE '%"+remedy+"%'";
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                GeneralRemedy grshow= new GeneralRemedy(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                remedyList.add(grshow);
            }while(cursor.moveToNext());
        }

        return remedyList;
    }








}
