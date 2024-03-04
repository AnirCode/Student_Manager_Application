/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.protocol.Resultset;
import entities.Student;
import helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentDAO 
{
    public static boolean insertStudentToDB(Student student)
     
    {
        boolean status=false;
        try
        {
            Connection con =ConnectionProvider.getConnection();
            DatabaseMetaData meta = con.getMetaData();
            ResultSet set= meta.getTables(null, null, "student", null);
            if(set.next())
            {
                //insert Table....
                 String insertQuery="INSERT INTO Student(sName,sNumber,sCity) values(?,?,?)";
               PreparedStatement preparedStatement =con.prepareStatement(insertQuery);
                       
               preparedStatement.setString(1,student.getName());
               preparedStatement.setString(2,student.getNumber());
               preparedStatement.setString(3,student.getCity());
               
               
               preparedStatement.executeUpdate();
            }
            else
            {
               // Create Table...
               String createTable="create table student(sid int primary key auto_increment,sName varchar(256) not null,sNumber varchar(20) not null,sCity varchar(100) not null);";
               Statement statement=con.createStatement();
               statement.executeUpdate(createTable);
               // Now insert the Table.....
               String insertQuery="INSERT INTO Student(sName,sNumber,sCity) values(?,?,?)";
               PreparedStatement preparedStatement =con.prepareStatement(insertQuery);
                       
               preparedStatement.setString(1,student.getName());
               preparedStatement.setString(2,student.getNumber());
               preparedStatement.setString(3,student.getCity());
               
               
               preparedStatement.executeUpdate();
               status =true;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return status;
        }
        return status;
    }
    
        
    public static boolean updateStudent(int sid, int option, String val)
        
    {
        boolean status = false;

        try{
            Connection con = ConnectionProvider.getConnection();
            if (option==1)
            {
                //Update name
                String query = "Update Student set sName = ? where sid =?";
                PreparedStatement preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);

                preparedStatement.executeUpdate();

            }
            else if (option==2)
            {
                //Update phone number
                String query = "Update Student set sNumber = ? where sid =?";
                PreparedStatement preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);

                preparedStatement.executeUpdate();

            }
            else
            {
                //Update city
                String query = "Update Student set sCity = ? where sid =?";
                PreparedStatement preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, val);
                preparedStatement.setInt(2, sid);

                preparedStatement.executeUpdate();

            }
            status = true;

        }
        catch (Exception e){
            e.printStackTrace();
            return status;
        }
        return status;
    }
    
     public static  boolean deleteStudent(int sid){
        boolean status = false;

        try {
            Connection con = ConnectionProvider.getConnection();

            String query = "DELETE from student where sid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, sid);

            preparedStatement.executeUpdate();

            status = true;

        }
        catch(Exception e){
            e.printStackTrace();
            return status;
        }
        return status;
    }
     
     public static void displayStudent() {

        try {
            Connection con = ConnectionProvider.getConnection();
            String query = "Select * from student";
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(query);

            int c=0;
            while (set.next())
            {
                c++;
                System.out.println("Student Id = "+ set.getInt(1));
                System.out.println("Student Name = "+ set.getString(2));
                System.out.println("Student Number = "+ set.getString(3));
                System.out.println("Student City = "+ set.getString(4));
                System.out.println("---------------------------------------------------------------------------------");
            }
            if(c==0)
            {
                System.out.println("Sorry! No data found. Please insert some data first to display.");
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
        
}
