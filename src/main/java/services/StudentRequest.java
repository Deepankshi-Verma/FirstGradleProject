package services;


public class StudentRequest {

    String sName;
    String dob;
    String sGender;
    String sAddress;
    String sRoll;
    public StudentRequest(){

    }

    public StudentRequest(String sName, String dob, String sGender, String sAddress, String sRoll) {
        this.sName = sName;
        this.dob = dob;
        this.sGender = sGender;
        this.sAddress = sAddress;
        this.sRoll = sRoll;
    }
    public String getsName() {
        return sName;
    }
    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsGender() {
        return sGender;
    }
    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getsAddress() {
        return sAddress;
    }
    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }


    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

}
