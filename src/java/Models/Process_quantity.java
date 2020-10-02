/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Process_quantity", urlPatterns = {"/Process_quantity"})
public class Process_quantity extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("IN PRO");
        
        ArrayList<Integer>finalquantity=new ArrayList<Integer>();
        
        String[] q=request.getParameterValues("qty");
       for(String s:q){
           finalquantity.add(Integer.parseInt(s));
       }
       
       ArrayList<String>list=new ArrayList<String>();
        list=(ArrayList<String>)request.getSession().getAttribute("list");
        
        
       ArrayList<Integer>selectedid=new ArrayList<Integer>();
        selectedid=(ArrayList<Integer>)request.getSession().getAttribute("selectedid");
       
       
       ArrayList<String>finalfoods=new ArrayList<String>();
       ArrayList<Integer>finalprice=new ArrayList<Integer>();
       int i;
       
       ArrayList<Integer>finalid=new ArrayList<Integer>();
       
       for(i=0;i<selectedid.size();i++){
           finalfoods.add(list.get(selectedid.get(i)));
           int idx=selectedid.get(i)+1;
           int price=Integer.parseInt(list.get(idx));
           finalprice.add(price);
           int id=Integer.parseInt(list.get(idx+2));
           finalid.add(id);
       }
       int total=0;
       for(i=0;i<finalfoods.size();i++)
       {
           System.out.println(finalfoods.get(i)+" "+finalquantity.get(i)+" "+finalprice.get(i)+" "+finalid.get(i));
           total+=(finalquantity.get(i)*finalprice.get(i));
       }
       
       String area=request.getParameter("area");
       System.out.println(area);
      
       System.out.println(total);
       
       
       
       HttpSession session=request.getSession();
       session.setAttribute("finalfoods", finalfoods);
       session.setAttribute("finalquantity", finalquantity);
       session.setAttribute("finalprice", finalprice);
       session.setAttribute("finalid", finalid);
       session.setAttribute("total", total);
       session.setAttribute("area", area);
       
       
      RequestDispatcher rd = request.getRequestDispatcher("finalshow.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
