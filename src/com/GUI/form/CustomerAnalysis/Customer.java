


package com.GUI.form.CustomerAnalysis;

import java.util.Date;


public class Customer {
    private boolean gender;
    private int age;
    private Date date;

    public Customer() {
    }

    public Customer(boolean gender, int age, Date date) {
        this.gender = gender;
        this.age = age;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    
}
