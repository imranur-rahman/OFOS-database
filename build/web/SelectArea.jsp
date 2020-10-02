<%-- 
    Document   : showFood
    Created on : Dec 15, 2016, 2:16:26 AM
    Author     : Shimul
--%>
 
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Select an area:</h1>
        <font color="black" face="arial" size="3">
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
        String query="Select AREA_NAME from AREA";
        PreparedStatement stmt1 = conn.prepareStatement(query);
        ResultSet rs=stmt1.executeQuery();
        ArrayList<String>ara=new ArrayList<String>();
        while(rs.next()){
            String i=rs.getString(1);
            System.out.println(i);
            ara.add(i);
        }
            
            //session.setAttribute("area", session.getAttribute("area"));
            %>
            <form method="post"  action="SelectArea">
            <select name="area">
                <%
            int i=0;
            for(i=0;i<ara.size();i++){
                %>
                <option value="<%= ara.get(i)%>"><%= ara.get(i)%></option>
                <%
                
            }
 
        %>
            </select>
         
            <input type="submit"/>
        </form>
        
 
        </font>
    </body>
</html>