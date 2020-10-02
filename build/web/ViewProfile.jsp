<%-- 
    Document   : ViewProfile
    Created on : Dec 14, 2016, 2:33:52 PM
    Author     : Seeum
--%>

<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
             System.out.println("IN VIEWPROJSP ");
            String first_name=(String)session.getAttribute("first_name");
            String second_name=(String)session.getAttribute("second_name");
            String contact=(String)session.getAttribute("contact_no");
            Date d=(Date)session.getAttribute("Date");
            String email=(String)session.getAttribute("email");
            Integer cus_id=(Integer)session.getAttribute("id");
            //HttpSession ses=request.getSession();
            session.setAttribute("first_name", first_name);
            session.setAttribute("second_name",second_name);
            session.setAttribute("contact", contact);
            session.setAttribute("email", email);
            session.setAttribute("id", cus_id);
            
            System.out.println("IN VIEWPROJSP "+cus_id);
            
         
           
            
            
            
            
          %>
        <font color="black" face="ARIAL" size="5">
        First Name- <%=first_name %><br>       
        Last Name-  <%=second_name %><br>
        Contact no.- <%=contact %><br>
        Registration Date-<%=d %><br>
        <a href="edit_profile.jsp?first_name=<%=first_name%> & last_name=<%=second_name%> & contact=<%=contact%>">Edit Profile</a>
         </font>
    </body>
</html>
