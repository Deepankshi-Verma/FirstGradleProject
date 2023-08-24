package services;

import entity.Student;
import java.sql.Connection;

// buisness logic
public interface StudentServices {

    Student create(StudentRequest request);

    Student search(SearchStudentRequest request);
    Student update(UpdateStudentRequest request);
    void display();

    Connection connectingToDb();
    void createTableInDb();
}
