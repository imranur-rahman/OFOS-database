/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seeum
 */
@WebServlet(name = "post_order", urlPatterns = {"/post_order"})
public class post_order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        int cus_id=(Integer)request.getSession().getAttribute("id");
        String area=(String)request.getSession().getAttribute("area");
        int total=(Integer)request.getSession().getAttribute("total");
        
        System.out.println(cus_id+area+total+"post");
        
        String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "see";
        String db_password = "see";
        Connection conn=null;
        String here = null;
            
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection(dbURL, username, db_password);
        System.out.println("HERE1");
        if(conn!=null) System.out.println("Connection successfully established.");
        else System.out.println("Could not establish connection");
        
        
        ArrayList<Integer>finalquantity=(ArrayList<Integer>)request.getSession().getAttribute("finalquantity");
        ArrayList<Integer>finalid=(ArrayList<Integer>)request.getSession().getAttribute("finalid");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        String query="Select * from ORDERS";
        PreparedStatement stmt1 = conn.prepareStatement(query);
        ResultSet rs=stmt1.executeQuery();
            
       int count1=0;
       while(rs.next())
       {
           ++count1;
       }
       int order_id=7000+count1;
       
       int i=0;
       
      
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       Date date=new Date();
       String s=String.format("%tr",date);
           
      Date date1=new Date();
      String s1=String.format("%tF",date1);
           
       String mn=s1+" "+s;
       
       String insertCommand = "insert into ORDERS values(?,?,?,?,?,?)";
       PreparedStatement stmt = conn.prepareStatement(insertCommand);
        
        stmt.setInt(1,order_id);
        stmt.setInt(2,0);
        stmt.setInt(3, total);
        stmt.setString(4, mn);
        stmt.setString(5, area);
        stmt.setInt(6, cus_id);
        System.out.println("IN "+order_id);
        int count = stmt.executeUpdate();
        
        
         String insert="INSERT INTO ORDERED_FOOD values(?,?,?)";
       PreparedStatement stmt2=conn.prepareStatement(insert);
       
       for(i=0;i<finalquantity.size();i++){
           
           stmt2.setInt(1,order_id);
           stmt2.setInt(2,finalid.get(i));
           stmt2.setInt(3,finalquantity.get(i));
          
           int cnt=stmt2.executeUpdate();
           
           
           
           
       }
        
        /*String insertCommand2 = "insert into DELIVERED_ORDER values(?,?)";
        PreparedStatement stmt2=conn.prepareStatement(insertCommand2);
        
        stmt2.setInt(1,cus_id);
        stmt2.setInt(2, order_id);
        
        int count2=stmt2.executeUpdate();*/
        
         RequestDispatcher rd = request.getRequestDispatcher("Order_complete.jsp");
        rd.forward(request, response); 
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(post_order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(post_order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(post_order.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(post_order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
