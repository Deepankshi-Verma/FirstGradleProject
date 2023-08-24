package services;

public class SearchStudentRequest {
    public SearchStudentRequest(){

    }
    public SearchStudentRequest( String name) {
        this.name = name;
    }

    String rollNo;
    public String getRollNo() {
        return rollNo;
    }
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
