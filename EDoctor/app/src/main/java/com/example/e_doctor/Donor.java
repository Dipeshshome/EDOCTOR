package com.example.e_doctor;

public class Donor {
    int _id;
    String _fname,_lname;
    String _phoneNumber;
    String _address;
    String _age,_password,_email,_weight;
    String _bloodgroup;





    public Donor(int Id, String FirstName , String LastName , String Bloodgroup, String Age , String Weight, String Address, String PhoneNumber, String Email, String Password )
    {


        this._id=Id;
        this._fname=FirstName;
        this._lname=LastName;
        this._phoneNumber=PhoneNumber;
        this._address=Address;
        this._bloodgroup=Bloodgroup;
        this._age=Age;
        this._weight=Weight;
        this._password=Password;
        this._email=Email;

    }

    public Donor(String FirstName , String LastName , String Bloodgroup, String Age , String Weight, String Address, String PhoneNumber, String Email, String Password )
    {

        this._fname=FirstName;
        this._lname=LastName;
        this._phoneNumber=PhoneNumber;
        this._address=Address;
        this._bloodgroup=Bloodgroup;
        this._age=Age;
        this._weight=Weight;
        this._password=Password;
        this._email=Email;
//        Toast.makeText (context.getApplicationContext(),_fname,Toast.LENGTH_SHORT).show();

    }


//    public Donor(String Name , String PhoneNumber)
//    {
//
//        this._name=Name;
//        this._phoneNumber=PhoneNumber;
//
//    }
//    public Donor(String Name ,String Blood_grp, String PhoneNumber)
//    {
//        this._bloodgroup=Blood_grp;
//        this._name=Name;
//        this._phoneNumber=PhoneNumber;
//
//
//    }
//
//
//    public Donor(String Name ,String Blood_grp, String PhoneNumber,  String Address)
//    {
//        this._bloodgroup=Blood_grp;
//        this._name=Name;
//        this._phoneNumber=PhoneNumber;
//        this._address=Address;
//
//    }



    public Donor()
    {

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
    public String get_fname() {
        return _fname;
    }

    public void set_fname(String _fname) {
        this._fname = _fname;
    }

    public String get_lname() {
        return _lname;
    }

    public void set_lname(String _lname) {
        this._lname = _lname;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_weight() {
        return _weight;
    }

    public void set_weight(String _weight) {
        this._weight = _weight;
    }



    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_age() {
        return _age;
    }

    public void set_age(String _age) {
        this._age = _age;
    }

    public String get_bloodgroup() {
        return _bloodgroup;
    }

    public void set_bloodgroup(String _bloodgroup) {
        this._bloodgroup = _bloodgroup;
    }



}
