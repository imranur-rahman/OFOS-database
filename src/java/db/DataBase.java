package db;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seeum
 */
public class DataBase {
    
    String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String username = "see";
    String password = "see";
    /*Calendar calendar = Calendar.getInstance();
    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());*/
    
    /*long time = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(time);*/
    
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    
    /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date ourJavaDateObject=sdf.parse(new java.sql.Date(calendar.getTime().getTime()));*/
    //Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
    
    int id_gen = 0;

    Connection conn = null;
    public DataBase()
    {
        
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("HERE1");
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int createAccount(String firstName, String lastName, String email, String contact, 
            String password)
    {
        try
        {
            String query="Select * from CUSTOMER";
            PreparedStatement stmt1 = conn.prepareStatement(query);
            ResultSet rs=stmt1.executeQuery();
            
            int count1=0;
           while(rs.next())
           {
               ++count1;
           }
           int id=1000+count1;
           System.out.println(count1);
            /*String query1 = "select count(*) from CUSTOMER";
            PreparedStatement stmt2 = conn.prepareStatement(query1);
            ResultSet rs2 = stmt2.executeQuery();
            System.out.println(rs2.getRow());*/
            
            String insertCommand = "insert into CUSTOMER values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            
            stmt.setInt(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setDate(4, sqlDate );
            stmt.setString(5, email);
            stmt.setString(6, contact);
            stmt.setString(7, password);
            int count = stmt.executeUpdate();
            String update="update CUSTOMER set REGISTRATION_DATE=trunc(REGISTRATION_DATE)";
            PreparedStatement stmt3=conn.prepareStatement(update);
            int count2=stmt3.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
        
        
        
    }
    
    public boolean existuser(String email,String password)
    {
        try
        {
            String query="select * from CUSTOMER where email_id = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
                    
        }
        
         catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
      }
    
}
