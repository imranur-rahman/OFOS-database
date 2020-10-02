<%-- 
    Document   : edit_profile
    Created on : Dec 16, 2016, 1:20:57 AM
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
            String first_name=(String)session.getAttribute("first_name");
            String last_name=(String)session.getAttribute("second_name");
            String contact=(String)session.getAttribute("contact");
            String email=(String)session.getAttribute("email");
            Integer id=(Integer)session.getAttribute("id");
            session.setAttribute("id", id);
            
            
            
            
            
            
            %>
        <h1>Edit Your Info</h1>
         <form method="post"  action="process_edit">
            First Name <input type="text" name="firstname" value="<%=first_name%>" /><br>
            Last Name <input type="text" name="lastname" value="<%=last_name%>"/><br>
            Contact no. <input type="text" name="contact" value="<%=contact%>"/><br>
            Email <input type="text" name="email" value="<%=email%>"/><br>
            <input type="hidden" name="mydata" value="<%=id%>">/<br>
            <input type="submit" name="Change"/>
        </form>
    </body>
</html>
