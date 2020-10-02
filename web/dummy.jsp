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
<<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        table {
            width:100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        table#t01 tr:nth-child(even) {
            background-color: #eee;
        }
        table#t01 tr:nth-child(odd) {
           background-color:#fff;
        }
        table#t01 th {
            background-color: black;
            color: white;
        }
        </style>
    </head>
    <body>
        <h1>Here is your order...</h1>
        <table>
            <tr>
                <th>Food</th>
                <th>Price</th>
            </tr>
        </table>
    </body>
</html>