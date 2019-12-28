package com.example.e_doctor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "E-DOCTOR.db";
    public static final String TABLE_NAME1 = "patientreg_details";
    public static final String TABLE_NAME2 = "doctor_details";
    public static final String TABLE_NAME3 = "appointment_details";
    private static final String User_ID = "user_id";
    private static final String DOCTOR_ID = "doctor_id";
    private static final String BMA_REGISTER_NO = "bma_register_no";
    private static final String FULLNAME = "fullName";
    private static final String USERNAME = "userName";
    private static final String DOCTOR_USERNAME = "doctor_userName";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String DATEOFBIRRTH = "dateofBirth";
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";
    private static final String BLOODGROUP = "bloodgroup";
    private static final String DEPARTMENT = "department";
    private  static final String GENDER="gender";
    private static final String CITY = "city";
    private static final String CONTACTNO = "contactno";
    private static final String APPOINT_ID  = "appoint_id";
    private static final String APPOINTDATE  = "appointdate";
    private static final String APPOINTTIME  = "appointtime";



    private static final int DATABASE_VERSION_NO = 2;

    private static final String CREATE_TABLE_REG= "CREATE TABLE "+TABLE_NAME1+"("+User_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FULLNAME+" VARCHAR(255),"+USERNAME+" VARCHAR(255),"+EMAIL+" VARCHAR(255),"+PASSWORD+" VARCHAR(255),"+GENDER+" VARCHAR(255),"+WEIGHT+" VARCHAR(255),"+HEIGHT+" VARCHAR(255),"+DATEOFBIRRTH+" VARCHAR(255),"+BLOODGROUP+" VARCHAR(255),"+CITY+" VARCHAR(255),"+CONTACTNO+" VARCHAR(255))";
private static final String DROP_TABLE1="DROP TABLE IF EXISTS "+TABLE_NAME1;
    private static final String CREATE_TABLE_DOCTOR= "CREATE TABLE "+TABLE_NAME2+"("+DOCTOR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+FULLNAME+" VARCHAR(255),"+DOCTOR_USERNAME+" VARCHAR(255),"+EMAIL+" VARCHAR(255),"+PASSWORD+" VARCHAR(255),"+GENDER+" VARCHAR(255),"+BMA_REGISTER_NO+" TEXT UNIQUE,"+DEPARTMENT+" TEXT UNIQUE,"+DATEOFBIRRTH+" VARCHAR(255),"+BLOODGROUP+" VARCHAR(255),"+CITY+" VARCHAR(255),"+CONTACTNO+" VARCHAR(255))";
    private static final String DROP_TABLE2="DROP TABLE IF EXISTS "+TABLE_NAME2;
    private static final String CREATE_TABLE_APPOINT= "CREATE TABLE "
            + TABLE_NAME3 + "(" + APPOINT_ID + " INTEGER PRIMARY KEY, "
            + User_ID + " TEXT, " + USERNAME + " TEXT, " + DOCTOR_USERNAME + " TEXT, "+ DEPARTMENT + " TEXT, "
            + APPOINTDATE + " VARCHAR(255), " + APPOINTTIME + " VARCHAR(255))";
    private static final String SELECT_ALL="SELECT * FROM " + TABLE_NAME3;
    private static final String DROP_TABLE3="DROP TABLE IF EXISTS "+TABLE_NAME3;



    private Context context;
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION_NO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"onCreate is called",Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE_REG);
            db.execSQL(CREATE_TABLE_DOCTOR);
            db.execSQL(CREATE_TABLE_APPOINT);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"onUpgrade is called",Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE1);
            db.execSQL(DROP_TABLE2);
            db.execSQL(DROP_TABLE3);
            onCreate(db);
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }

    }

    public long insertData_reg(String fullname, String username, String email, String password, String gender,String height,String weight,String dateofbirth,String bloodgroup,String city,String contactno){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(FULLNAME,fullname);
        contentValues.put(USERNAME,username);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(GENDER,gender);
        contentValues.put(DATEOFBIRRTH,dateofbirth);
        contentValues.put(BLOODGROUP,bloodgroup);
        contentValues.put(HEIGHT,height);
        contentValues.put(WEIGHT,weight);
        contentValues.put(CITY,city);
        contentValues.put(CONTACTNO,contactno);
        long rowId = sqLiteDatabase.insert(TABLE_NAME1,null,contentValues);
        return rowId;




    }

    public long insertData_doc(String fullname, String doctor_username, String email, String password, String gender, String bma_reg_no, String department, String dateofbirth, String bloodgroup, String city, String contactno){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(FULLNAME,fullname);
        contentValues.put(DOCTOR_USERNAME,doctor_username);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(GENDER,gender);
        contentValues.put(DATEOFBIRRTH,dateofbirth);
        contentValues.put(BLOODGROUP,bloodgroup);
        contentValues.put(BMA_REGISTER_NO,bma_reg_no);
        contentValues.put(DEPARTMENT,department);
        contentValues.put(CITY,city);
        contentValues.put(CONTACTNO,contactno);
        long rowId = sqLiteDatabase.insert(TABLE_NAME2,null,contentValues);
        return rowId;
    }




    public long insertData_appointment(String user_ID, String username, String doctor_username, String department, String appointdate,String appointtime){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(User_ID,user_ID);
        contentValues.put(USERNAME,username);
        contentValues.put(DOCTOR_USERNAME,doctor_username);
        contentValues.put(DEPARTMENT,department);
        contentValues.put(APPOINTDATE,appointdate);
        contentValues.put(APPOINTTIME,appointtime);
        long rowId = sqLiteDatabase.insert(TABLE_NAME3,null,contentValues);
        return rowId;
    }



    public Boolean loginCheck(String name,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        Boolean result=false;
        while (cursor.moveToNext())
        {

            String uemail=cursor.getString(2);
            String upassword=cursor.getString(4);
            if(uemail.equals(name) && upassword.equals(password))
            {
                result=true;
                break;
            }
        }

        return result;

    }
    public Boolean loginCheck2(String name,String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME2,null);
        Boolean result=false;
        while (cursor.moveToNext())
        {

            String uemail=cursor.getString(2);
            String upassword=cursor.getString(4);
            if(uemail.equals(name) && upassword.equals(password))
            {
                result=true;
                break;
            }
        }

        return result;

    }

  public Cursor displayAllData(){
      SQLiteDatabase db=this.getWritableDatabase();
      Cursor cursor=db.rawQuery(SELECT_ALL,null);
        return cursor;
    }
}
