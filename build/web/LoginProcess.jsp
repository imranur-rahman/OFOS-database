<%-- 
    Document   : LoginProcess
    Created on : Dec 4, 2016, 11:01:27 AM
    Author     : Seeum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>login</title>
    <style type="text/css">
    .container {
        width: 500px;
        clear: both;
    }
    .container input {
        width: 100%;
        clear: both;
    }

    </style>
</head>
    <body>
         <h1>Please provide Email and Password...</h1>
         <div class="container">
         <font color="black" face="Comic Sans MS" size="5">
        <form method="post"  action="LoginProcess">
            Email <input type ="text" name ="email" /><br>
            Password <input type="password" name="password" /><br>
            <input type="submit"/>
        </form>
        </font>
        </div>
    </body>
</html>
