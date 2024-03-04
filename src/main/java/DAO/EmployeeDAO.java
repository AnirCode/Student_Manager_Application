
package DAO;

import entities.Employee;
import helper.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
    
    
    public static void displayAllEmployees(){
        
        
        //List<Employee> employees = new ArrayList<>();
        
        try{
            Connection con = ConnectionProvider.getConnection();

            String query = "SELECT * FROM EMPLOYEE";

            Statement stmt = con.createStatement();
            
            ResultSet set = stmt.executeQuery(query);
            
            while(set.next()){
                System.out.println(set.getInt("eid"));
                System.out.println(set.getString("eName"));
                System.out.println(set.getString(3));
                System.out.println(set.getString(4));
                System.out.println(set.getString(5));
                
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
}
