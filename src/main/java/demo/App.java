package demo;

import java.util.*;
import services.*;

public class App {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int c;
        StudentServices  studentService= new StudentServiceImpl();
        studentService.connectingToDb();
       // studentService.createTableInDb();

        StudentRequest studentRequest= new StudentRequest();
        SearchStudentRequest searchStudentRequest = new SearchStudentRequest();
        UpdateStudentRequest updateStudentRequest= new UpdateStudentRequest();


        String sName;
        do{
            System.out.println("1.Insert");
            System.out.println("2.Search");
            System.out.println("3.Update");
            System.out.println("4.Display");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            c= Integer.parseInt(s.nextLine());

            switch(c){

                case 1: // insert
                    System.out.print("Enter name: ");
                    sName= s.nextLine();
                    studentRequest.setsName(sName);

                    System.out.print("Enter date of birth in dd/mm/yyyy : ");
                    String sDob= s.nextLine();
                    studentRequest.setDob(sDob);

                    System.out.print("Enter gender: ");
                    String sGender= s.nextLine();
                    studentRequest.setsGender(sGender);

                    System.out.print("Enter address: ");
                    String sAddress= s.nextLine();
                    studentRequest.setsAddress(sAddress);

                    studentService.create(studentRequest);
                    break;

                case 2:// search
                    System.out.println("Enter Roll number to be searched");
                    searchStudentRequest.setRollNo(s.nextLine());

                    System.out.println("Enter name  to be searched");
                    searchStudentRequest.setName(s.nextLine());

                    studentService.search(searchStudentRequest);
                    break;

                case 3:// update
                    System.out.println("enter the roll no. to be updated.");
                    String roll= s.nextLine();
                    updateStudentRequest.setRollNo(roll);

                    System.out.print("Enter name: ");
                    sName= s.nextLine();
                    updateStudentRequest.setName(sName);

                    System.out.print("Enter gender: ");
                    sGender= s.nextLine();
                    updateStudentRequest.setGender(sGender);

                    System.out.print("Enter address: ");
                    sAddress= s.nextLine();
                    updateStudentRequest.setAddress(sAddress);

                    studentService.update(updateStudentRequest);
                    break;

                case 4: // display
                    studentService.display();
                    break;

                default:System.exit(0);
                    break;
            }
        }while(c!=0);

        s.close();
    }
}
