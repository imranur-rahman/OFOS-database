package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class admin_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Welcome Admin</h1>\n");
      out.write("        ");

            
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
        

        String Command = "Select ORDER_ID from ORDERS where EMPLOYEE_ID=?";
        PreparedStatement stmt = conn.prepareStatement(Command);
        
        stmt.setInt(1,0);
        ResultSet rs=stmt.executeQuery();
        ArrayList<Integer>pending=new ArrayList<Integer>();
        while(rs.next())
        {
            int here=rs.getInt("ORDER_ID");
            System.out.println(here);
            pending.add(here);
        }
        
        String Command1="Select EMPLOYEE_ID from EMPLOYEE where AVAILABILITY=?";
        PreparedStatement stmt1=conn.prepareStatement(Command1);
        stmt1.setInt(1, 1);
        ResultSet rs1=stmt1.executeQuery();
        ArrayList<Integer>available_emp=new ArrayList<Integer>();
        
        while(rs1.next()){
            int here=rs1.getInt("EMPLOYEE_ID");
            System.out.println(here);
            available_emp.add(here);
        }
        
        String Command2="Select EMPLOYEE_ID from EMPLOYEE where AVAILABILITY=?";
        PreparedStatement stmt2=conn.prepareStatement(Command2);
        stmt2.setInt(1, 0);
        ResultSet rs2=stmt2.executeQuery();
        ArrayList<Integer>busy_emp=new ArrayList<Integer>();
        
        while(rs2.next()){
            int here=rs2.getInt("EMPLOYEE_ID");
            System.out.println(here);
            busy_emp.add(here);
        }
        
        
      out.write("\n");
      out.write("        \n");
      out.write("         <form method=\"post\" action=\"assign_order\">\n");
      out.write("             Pending Orders:\n");
      out.write("\n");
      out.write("            <select name=\"pending\">\n");
      out.write("\n");
      out.write("                ");

            int i=0;
            for(i=0;i<pending.size();i++){
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( pending.get(i));
      out.write('"');
      out.write('>');
      out.print( pending.get(i));
      out.write("</option>\n");
      out.write("                ");

                
            }
 
        
      out.write("\n");
      out.write("            </select>\n");
      out.write("         \n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("                Available Employee:\n");
      out.write("                \n");
      out.write("                 <select name=\"available_emp\">\n");
      out.write("\n");
      out.write("                ");

                 int k=0;
                for(k=0;k<available_emp.size();k++){
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( available_emp.get(k));
      out.write('"');
      out.write('>');
      out.print(available_emp.get(k));
      out.write("</option>\n");
      out.write("                ");

                
            }
 
        
      out.write("\n");
      out.write("            </select>\n");
      out.write("         \n");
      out.write("            <input type=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("            <br><br>\n");
      out.write("            <form method=\"post\" action=\"process_free\">\n");
      out.write("             Free employee:\n");
      out.write("             \n");
      out.write("           <select name=\"free\">\n");
      out.write("\n");
      out.write("                ");

                for(i=0;i<busy_emp.size();i++){
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( busy_emp.get(i));
      out.write('"');
      out.write('>');
      out.print( busy_emp.get(i));
      out.write("</option>\n");
      out.write("                ");

                
            }
 
        
      out.write("\n");
      out.write("            </select>\n");
      out.write("             <input type=\"submit\"/>\n");
      out.write("        </form>\n");
      out.write("            <br><br>\n");
      out.write("             <form method=\"post\" action=\"admin_home.jsp\">\n");
      out.write("         <input type=\"submit\" value=\"Refresh\"/>  \n");
      out.write("         \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("           \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
