<%-- 
    Document   : Home
    Created on : Dec 4, 2016, 11:27:59 AM
    Author     : Seeum
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <%
            
            String email = (String) session.getAttribute("email");
            String name=(String) session.getAttribute("lastname");
            session.setAttribute("email", email);
            
            
            
            System.out.println("IN HOME"+" "+email);
            
            if(email.equals(""))
            {
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            }           
        %>
        <h1>Welcome</h1>
         <a href="ViewProfile?email=<%=email%>">View Profile</a><br>
         <a href="SelectArea.jsp">Order Your Food</a><br>
         <a href="LoginProcess.jsp">Log Out</a><br><br>
         <form method="post" action="rate.jsp">
         <input type="submit" value="Rate Restaurent"/>  
         </form>
         
    </body>
</html>
