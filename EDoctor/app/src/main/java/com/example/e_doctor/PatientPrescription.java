package com.example.e_doctor;

public class PatientPrescription {

    int _id;
    String fullname;
    String age;
    String weight;
    String date,disease,bp,hr,medicine,exam;

    public PatientPrescription(int _id, String fullname, String age, String weight, String date, String disease, String bp, String hr, String medicine, String exam) {
        this._id = _id;
        this.fullname = fullname;
        this.age = age;
        this.weight = weight;
        this.date = date;
        this.disease = disease;
        this.bp = bp;
        this.hr = hr;
        this.medicine = medicine;
        this.exam = exam;
    }



    public PatientPrescription(String fullname, String age, String weight, String date, String disease, String bp, String hr, String medicine, String exam) {

        this.fullname = fullname;
        this.age = age;
        this.weight = weight;
        this.date = date;
        this.disease = disease;
        this.bp = bp;
        this.hr = hr;
        this.medicine = medicine;
        this.exam = exam;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}
