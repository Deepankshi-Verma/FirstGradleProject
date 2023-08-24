package entity;

import java.io.Serializable;

// defining student POJO
public class Student implements Serializable {

    private String rollNo;
    private String name;
    private String dob;
    private String gender;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(){

    }

    public Student(String name, String dob, String gender, String address) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return  rollNo+" "+name+ " "+ dob +" "+ gender+" "+address;
    }


}

