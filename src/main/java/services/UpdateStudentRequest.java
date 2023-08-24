package services;

public class UpdateStudentRequest {

    String name;
    String address;
    String gender;
    String rollNo;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public UpdateStudentRequest(){

    }

    public UpdateStudentRequest(String name, String address, String gender) {
        this.name = name;
        this.address = address;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }



}
