/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.learn.java.student_manager_application;

import DAO.EmployeeDAO;
import DAO.StudentDAO;
import entities.Student;
import helper.ConnectionProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Anir
 */
public class Student_Manager_Application {

    public static void main(String[] args) throws IOException {
        
        EmployeeDAO.displayAllEmployees();
        
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op,id;
        String name = "", city="", phone="";
        boolean status = false;

        while (true){
            System.out.println("Hello! Welcome to Student Management App");
            System.out.println("Enter 1 to Display all the students");
            System.out.println("Enter 2 to Insert all the students");
            System.out.println("Enter 3 to Update all the students");
            System.out.println("Enter 4 to Delete all the students");
            System.out.println("Enter 5 to Exit");

            op = Integer.parseInt(br.readLine());

            if (op == 1)
            {
                //display
                StudentDAO.displayStudent();

            }
            else if(op == 2)
            {
                //insert
                System.out.println("Enter the name of the Student : ");
                name = br.readLine();
                System.out.println("Enter the phone number of the Student : ");
                phone = br.readLine();
                System.out.println("Enter the city of the Student : ");
                city = br.readLine();

                Student st = new Student(name, phone, city);
                status = StudentDAO.insertStudentToDB(st);
                if (status)
                {
                    System.out.println("Success!");
                }
                else
                {
                    System.out.println("Something went wrong!");
                }
            }
            else if(op == 3)
            {
                //update
                System.out.println("We suggest you to kindly display all the students for confirming the student id, whom to be updated!");
                System.out.println("Enter the Student Id");
                id = Integer.parseInt(br.readLine());

                System.out.println("Enter 1 to Update Name");
                System.out.println("Enter 2 to Update Phone");
                System.out.println("Enter 3 to Update City");

                op = Integer.parseInt(br.readLine());

                if (op==1)
                {
                    System.out.println("Enter the new Name : ");
                    name = br.readLine();
                    status = StudentDAO.updateStudent(id, op, name);
                    if (status)
                    {
                        System.out.println("Success!");
                    }
                    else
                    {
                        System.out.println("Something went wrong!");
                    }
                }
                else if (op==2)
                {
                    System.out.println("Enter the new Phone Number : ");
                    phone = br.readLine();
                    status = StudentDAO.updateStudent(id, op, phone);
                    if (status)
                    {
                        System.out.println("Success!");
                    }
                    else
                    {
                        System.out.println("Something went wrong!");
                    }
                }
                else if (op==3)
                {
                    System.out.println("Enter the new City : ");
                    city = br.readLine();
                    status = StudentDAO.updateStudent(id, op, city);
                    if (status)
                    {
                        System.out.println("Success!");
                    }
                    else
                    {
                        System.out.println("Something went wrong!");
                    }
                }
                else
                {
                    System.out.println("Please enter the right option and try again");
                    continue;
                }

            }
            else if (op ==4)
            {
                //delete
                System.out.println("we suggest you to kindly display all the students for confirming the student id, whom to be deleted!");
                System.out.println("Enter the Student Id");
                id = Integer.parseInt(br.readLine());

                status = StudentDAO.deleteStudent(id);
                if (status)
                {
                    System.out.println("Success!");
                }
                else
                {
                    System.out.println("Something went wrong!");
                }
            }
            else if (op == 5)
            {
                System.out.println("Thanks for using our application!");
                break;
            }
        }
    }
}
