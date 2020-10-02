<%-- 
    Document   : edit_success
    Created on : Dec 16, 2016, 4:02:18 PM
    Author     : Seeum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String email=(String)session.getAttribute("email");
            //session.setAttribute("email", email);
            System.out.println(email + "IN EDIT");
            
         %>
        <h1>Your changes have been recorded :)</h1>
       <a href="Home.jsp">Back to home</a>
        
    </body>
</html>
