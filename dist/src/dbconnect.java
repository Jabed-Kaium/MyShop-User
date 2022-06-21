
import java.sql.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class dbconnect {
    public static Connection connect(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/myshop_bazar", "jabedkaium", "12345678");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
