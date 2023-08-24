package repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class StudentRepo {

    public StudentRepo() {
    }

    Properties prop;

    {
        try {
            prop = readPropertiesFile("db.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection connectToDb() {
        Connection conn = null;
        try {
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("db_url"), prop.getProperty("user"), prop.getProperty("password"));
            if (conn != null) {
                System.out.println("Connection established with db");
            } else {
                System.out.println("Connection failed with db");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String tableName) {
        Statement statement;
        try {
            String query = "create table " + tableName + "(student_roll SERIAL, name varchar(200) ,dob varchar(11),gender varchar(9), address varchar(200),primary key(student_roll));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insert(Connection conn, String tableName, String name, String dateOfBirth, String address, String gender) {
        Statement statement;
        try {
            String query = String.format("insert into %s(name,dob,gender,address) values('%s','%s','%s','%s');", tableName, name, dateOfBirth, gender, address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("insert method ended");
    }

    public void searchInDbByRoll(Connection conn, String tableName, String studentRoll) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where  student_roll =%s ", tableName, studentRoll);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("student_roll") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("dob") + " ");
                System.out.print(rs.getString("gender") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchInDbByName(Connection conn, String tableName, String name) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where  name = '%s' ", tableName, name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("student_roll") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("dob") + " ");
                System.out.print(rs.getString("gender") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchInDbByBoth(Connection conn, String tableName, String studentRoll, String name) {
        Statement statement;
        ResultSet rs = null;
        try {
            //String query = String.format("select * from %s where  student_roll =%s  AND name = '%s' ", tableName, studentRoll, name);
             String query = String.format("select * from %s where (student_roll = %s  OR  %s = NULL) " +
                                                                 "AND (name = '%s'  OR name =' ')", tableName,studentRoll,studentRoll, name);

            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("student_roll") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("dob") + " ");
                System.out.print(rs.getString("gender") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateDb(Connection conn, String tableName, String name, String roll, String gender, String address) {
        Statement statement;
        try {
            String query = String.format("update %s set name= CASE WHEN '%s' = '' THEN name ELSE '%s' END where student_roll='%s';", tableName, name, name, roll);
            String query1 = String.format("update %s set gender= CASE WHEN '%s'=''THEN gender ELSE '%s' END where student_roll='%s';", tableName, gender, gender, roll);
            String query2 = String.format("update %s set address= CASE WHEN '%s'=''THEN address ELSE '%s' END where student_roll='%s';", tableName, address, address, roll);

            statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            System.out.println("table updated");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void displayingDataDb(Connection conn, String tableName) {
        Statement statement;
        ResultSet rs = null;

        try {
            String query = String.format("select * from %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("student_roll") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("dob") + " ");
                System.out.print(rs.getString("gender") + " ");
                System.out.println(rs.getString("address") + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream("./src/main/resources/" + fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}


