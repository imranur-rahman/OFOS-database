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
@WebServlet(name = "process_rating", urlPatterns = {"/process_rating"})
public class process_rating extends HttpServlet {

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
        
        
        String[] res=request.getParameterValues("res");
        String res_name="";
        for(String s:res)
            res_name=s;
        
        String[] rating=request.getParameterValues("rating");
        Float rate = null;
        for(String s:rating)
            rate=Float.parseFloat(s);
        
        System.out.println(res_name+" "+rate+" "+"process");
        
        String query="Select * from REVIEW";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs=stmt.executeQuery();
            
       int count1=0;
       while(rs.next())
       {
           ++count1;
       }
       int review_id=2000+count1;
       
       String query1="Select RESTAURENT_ID from RESTAURENT where RESTAURENT_NAME=?";
       PreparedStatement stmt1=conn.prepareStatement(query1);
       stmt1.setString(1, res_name);
       ResultSet rs1=stmt1.executeQuery();
       
       int res_id=0;
       while(rs1.next()){
           String s=rs1.getString(1);
           res_id=Integer.parseInt(s);
       }
       
       System.out.println(res_id+"process");
       
       String insert="Insert into REVIEW values(?,?,?)";
       PreparedStatement stmt2=conn.prepareStatement(insert);
       
       stmt2.setFloat(1, rate);
       stmt2.setInt(2,review_id);
       stmt2.setInt(3,res_id);
       
       int cn=stmt2.executeUpdate();
       
       RequestDispatcher rd = request.getRequestDispatcher("rate_finish.jsp");
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
            Logger.getLogger(process_rating.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(process_rating.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(process_rating.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(process_rating.class.getName()).log(Level.SEVERE, null, ex);
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
