/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Seeum
 */
@WebServlet(name = "ViewProfile", urlPatterns = {"/ViewProfile"})
public class ViewProfile extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
     response.setContentType("text/html;charset=UTF-8");
    String email=request.getParameter("email");
    
    String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String username = "see";
    String password = "see";
    
    
    Connection conn = null;
    
        
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
        
         CallableStatement callableStatement = null;
         String query="{call my_profile(?,?,?,?,?,?)}";
         
        callableStatement=conn.prepareCall(query);
        callableStatement.setString(1,email);
        callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
        callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
        callableStatement.registerOutParameter(5, java.sql.Types.DATE);
        callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
         callableStatement.executeUpdate();
         
         String first_name=callableStatement.getString(2);
         String second_name=callableStatement.getString(3);
         String contact=callableStatement.getString(4);
         Date d=callableStatement.getDate(5);
         int cus_id=callableStatement.getInt(6);
         

         
         HttpSession session=request.getSession();
         session.setAttribute("first_name", first_name);
         session.setAttribute("second_name", second_name);
         session.setAttribute("contact_no", contact);
         session.setAttribute("Date", d);
         session.setAttribute("email",email);
         session.setAttribute("id", cus_id);
         System.out.println("EKHANE "+first_name+" "+cus_id);
         RequestDispatcher rd = request.getRequestDispatcher("ViewProfile.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ViewProfile.class.getName()).log(Level.SEVERE, null, ex);
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
