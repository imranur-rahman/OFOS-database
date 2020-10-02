<%-- 
    Document   : admin_login
    Created on : Dec 18, 2016, 3:57:31 PM
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
        <h1>Please provide your password...</h1>
        <form method="post"  action="admin_login">
           Password <input type="password" name="password" /><br>
            <input type="submit"/>
        </form>
    </body>
</html>
