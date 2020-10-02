package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class rate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <font color=\"black\" face=\"ARIAL\" size=\"5\">\n");
      out.write("        Give Your Rating...<br><br>\n");
      out.write("    ");

            
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
             
            String query="Select RESTAURENT_NAME from RESTAURENT";
            PreparedStatement stmt1 = conn.prepareStatement(query);
            ResultSet rs=stmt1.executeQuery();
            ArrayList<String>res=new ArrayList<String>();
            while(rs.next()){
                String i=rs.getString(1);
                System.out.println(i);
                res.add(i);
                System.out.println(i+" "+"RATE");
            }
            
      out.write("\n");
      out.write("            \n");
      out.write("             <form method=\"post\"  action=\"process_rating\">\n");
      out.write("             Please choose your restaurent\n");
      out.write("\n");
      out.write("            <select name=\"res\">\n");
      out.write("                ");

            int i=0;
            for(i=0;i<res.size();i++){
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( res.get(i));
      out.write('"');
      out.write('>');
      out.print( res.get(i));
      out.write("</option>\n");
      out.write("                ");

                
            }
 
        
      out.write("\n");
      out.write("            </select>\n");
      out.write("            \n");
      out.write("            <br><br>\n");
      out.write("            Give Your Rating \n");
      out.write("            <input type=\"number\" name=\"rating\" step=\"0.1\" min=\"0\" max=\"5\" required><br>\n");
      out.write("            \n");
      out.write("         \n");
      out.write("            <input type=\"submit\"/>\n");
      out.write("        </form>\n");
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
      out.write("            \n");
      out.write("            </font>        \n");
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
