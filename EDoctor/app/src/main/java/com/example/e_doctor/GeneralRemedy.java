package com.example.e_doctor;

public class GeneralRemedy {
    int _id;
    String heading;
    String symtomps;
    String description;
    String medicine;

    public GeneralRemedy(int _id, String heading, String symtomps, String description, String medicine) {
        this._id = _id;
        this.heading = heading;
        this.symtomps = symtomps;
        this.description = description;
        this.medicine = medicine;
    }

    public GeneralRemedy( String heading, String symtomps, String description, String medicine) {

        this.heading = heading;
        this.symtomps = symtomps;
        this.description = description;
        this.medicine = medicine;
    }

    public int get_id() {
        return _id;
    }

    public String getHeading() {
        return heading;
    }

    public String getSymtomps() {
        return symtomps;
    }

    public String getDescription() {
        return description;
    }

    public String getMedicine() {
        return medicine;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setSymtomps(String symtomps) {
        this.symtomps = symtomps;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
