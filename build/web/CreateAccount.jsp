<%-- 
    Document   : CreateAccount
    Created on : Dec 3, 2016, 12:21:57 PM
    Author     : Seeum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>CreateAcc</title>
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
        <h1>Create Your Account</h1>
        <div class="container">
         <font color="black" face="Comic Sans MS" size="5">
        <form method="post"  action="CreateAccount">
            First Name <input type="text" name="firstname" /><br>
            Last Name <input type="text" name="lastname" /><br>
            Email <input type ="text" name ="email" /><br>
            Contact no. <input type="text" name="contact"/><br>
            Password <input type="password" name="password" /><br>
            <input type="submit"/>
        </form>
         </font>
          </div>
    </body>
</html>
