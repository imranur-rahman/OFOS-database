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
 * @author Seeum
 */
@WebServlet(name = "SelectArea", urlPatterns = {"/SelectArea"})
public class SelectArea extends HttpServlet {

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
        String area=request.getParameter("area");
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
        
        CallableStatement callableStatement = null;
        String query="{call view_res(?,?)}";
        callableStatement=conn.prepareCall(query);
        callableStatement.setString(1,area);
        
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        boolean isResultset=callableStatement.execute();
        ResultSet rs=(ResultSet)callableStatement.getObject(2);
        int i=1;
        ArrayList<String>l=new ArrayList<String>();
        ArrayList<Integer>res_id=new ArrayList<Integer>();
        while(rs.next()){
            String s=rs.getString(1);
            l.add(s);
            String m=rs.getString(2);
            Integer c=new Integer(0);
            c=Integer.parseInt(m);
            res_id.add(c);
            
            System.out.println(s+" "+c+" "+"in selec area");
         }
        HttpSession session = request.getSession();
        session.setAttribute("list", l);
        session.setAttribute("area", area);
        session.setAttribute("res_id", res_id);
        RequestDispatcher rd = request.getRequestDispatcher("showRest.jsp");
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
            Logger.getLogger(SelectArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelectArea.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SelectArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelectArea.class.getName()).log(Level.SEVERE, null, ex);
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
