<%-- 
    Document   : rate
    Created on : Dec 20, 2016, 12:40:39 AM
    Author     : Seeum
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <font color="black" face="ARIAL" size="5">
        Give Your Rating...<br><br>
    <%
            
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
            %>
            
             <form method="post"  action="process_rating">
             Please choose your restaurent

            <select name="res">
                <%
            int i=0;
            for(i=0;i<res.size();i++){
                %>
                <option value="<%= res.get(i)%>"><%= res.get(i)%></option>
                <%
                
            }
 
        %>
            </select>
            
            <br><br>
            Give Your Rating 
            <input type="number" name="rating" step="0.1" min="0" max="5" required><br>
            
         
            <input type="submit"/>
        </form>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            </font>        
    </body>
</html>
