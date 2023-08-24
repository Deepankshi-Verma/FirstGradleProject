package services;
import java.sql.Connection;

import entity.Student;
import repository.StudentRepo;


public class StudentServiceImpl implements StudentServices{

    String sDob;
    StudentRepo str = new StudentRepo();
    Student student = new Student();

    Connection conn;
    public Student create(StudentRequest request){
        String sName= request.getsName();
        if(!sName.matches("(?:[A-Z][a-z]*)") ){
            System.out.println("please enter a valid name with capital or small alphabets.");
            System.exit(0);
        }

        String sGender=request.getsGender();
        if(!sGender.matches("(?:m|M|male|Male|f|F|female|Female|FEMALE|MALE|Not prefer to say$)")) {
            System.out.println("Enter either m,M,male,Male,f,F,female,Female,FEMALE,MALE,Not prefer to say");
            System.exit(0);
        }


        sDob=request.getDob();
        if(!sDob.matches("^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$")) {
            System.out.println("Enter valid date in format dd/mm/yyyy");
            System.exit(0);
        }

        String sAddress=request.getsAddress();

       student = new Student(sName,sDob,sGender,sAddress);
        str.insert(conn,"student_info",sName,sDob,sAddress,sGender);

        return student ;
    }

    public Student search(SearchStudentRequest request1){

        String roll= request1.getRollNo();
        String name = request1.getName();

       // if(!name.equals("") && !roll.equals("")){
            str.searchInDbByBoth(conn,"student_info",roll,name);
//        }else if(!roll.equals("")){
//            str.searchInDbByRoll(conn,"student_info",roll);
//        }else if(!name.equals("") ){
//            str.searchInDbByName(conn,"student_info",name);
//        }
        // display
        return student ;
    }

    public Student update(UpdateStudentRequest request){

        String sRoll= request.getRollNo();
        String sName= request.getName();
        String sGender= request.getGender();
        String sAddress= request.getAddress();

        student = new Student(sRoll,sName,sGender,sAddress);
        str.updateDb(conn,"student_info",sName,sRoll,sGender,sAddress);
        return student;
    }

    public void display(){
        str.displayingDataDb(conn,"student_info");
    }


    public Connection connectingToDb(){
        conn=  str.connectToDb();
        return conn;
    }

    public void createTableInDb(){
        str.createTable(conn,"student_info");
    }


}

