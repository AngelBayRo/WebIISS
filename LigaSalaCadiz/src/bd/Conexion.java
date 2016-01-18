/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.DriverManager;
import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hackro
 */
public class Conexion
{
    
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String HOST = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "ligacadiz";
    public static final String CLASSNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://"+ HOST +":"+PORT+"/"+DATABASE;
    
     public java.sql.Connection con;
     
       public Conexion() {
  
        try {
           Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Falta clase");
        } catch (SQLException e) {
            System.out.println("Error");
        }
}
       
       
}