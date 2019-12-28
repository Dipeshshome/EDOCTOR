package com.example.e_doctor;

public class BlogInsert {
    int _id;
    String heading;
    String experience;
    String motivation;
    String advice;


    public BlogInsert(int _id, String heading, String experience, String motivation, String advice) {
        this._id = _id;
        this.heading = heading;
        this.experience = experience;
        this.motivation = motivation;
        this.advice = advice;
    }
    public BlogInsert( String heading, String experience, String motivation, String advice) {

        this.heading = heading;
        this.experience = experience;
        this.motivation = motivation;
        this.advice = advice;
    }


    public int get_id() {
        return _id;
    }

    public String getHeading() {
        return heading;
    }

    public String getExperience() {
        return experience;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getAdvice() {
        return advice;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}

