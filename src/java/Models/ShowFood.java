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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Shimul
 */
@WebServlet(name = "ShowFood", urlPatterns = {"/ShowFood"})
public class ShowFood extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "see";
        String password = "see";
        Connection conn=null;
        
        String resName = request.getParameter("res");
        String area = request.getParameter("area");
        System.out.println(resName);
        System.out.println(area);
        System.out.println(resName);
        System.out.println(area);
        
        CallableStatement callableStatement = null;
        
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
        
        
        String query = "{call foods_in_res(?,?,?)}";
        
        
        callableStatement=conn.prepareCall(query);
        System.out.println(resName + area + "ASDSD");
        callableStatement.setString(1,resName);
        callableStatement.setString(2, area);
        callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
        boolean isResultset=callableStatement.execute();
        ResultSet rs=(ResultSet)callableStatement.getObject(3);
        int i=1;
        ArrayList<String>l=new ArrayList<String>();
        ArrayList<Integer>cost=new ArrayList<Integer>();
        while(rs.next()){
            String food=rs.getString(1);
            String price=rs.getString(2);
            String time=rs.getString(3);
            String food_id=rs.getString(4);
            l.add(food);
            l.add(price);
            l.add(time);
            l.add(food_id);
            System.out.println(food + price + time + food_id + "IN SHOW FOOD");
            cost.add(Integer.parseInt(price));
         }
        
        System.out.println(l.size()+"ABBA");
        HttpSession session = request.getSession();
        session.setAttribute("list", l);
        
        
        
        RequestDispatcher rd = request.getRequestDispatcher("ShowFood.jsp");
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
            Logger.getLogger(ShowFood.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ShowFood.class.getName()).log(Level.SEVERE, null, ex);
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
