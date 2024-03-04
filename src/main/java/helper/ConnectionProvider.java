/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;





public class ConnectionProvider {
    private static Connection con;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String userName="root";
            String pwd="8372038023";
            String url="jdbc:mysql://localhost:3306/SMA";
            
            con=DriverManager.getConnection(url,userName,pwd);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
}
