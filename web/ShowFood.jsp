<%-- 
    Document   : showFood
    Created on : Dec 15, 2016, 2:16:26 AM
    Author     : Shimul
--%>
 
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><style>
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
        <h1>Here are the foods in your selected restaurent:</h1>
 
        <%
            ArrayList<String>list=(ArrayList<String>)(session.getAttribute("list"));
            session.setAttribute("list", list);
            int i;
 
 
 
            //session.setAttribute("area", session.getAttribute("area"));
 
        %>
        <form method="post"  action="checked_food">
        <table id="t01">
            <tr>
              <th>Check box</th>
              <th>Name</th>
              <th>Price</th> 
              <th>Time Needed (min)</th>
              
            </tr>
 
            <%
            for(i = 0; i < list.size(); i += 4){
                System.out.println("asss");
                %>
                <tr>
                  <td><input type="checkbox" name="id" value="<%=i%>"/></td>
                  <td><%out.println(list.get(i));%></td>
                  <td><%out.println(list.get(i + 1));%></td>
                  <td><%out.println(list.get(i + 2));%></td>
                  <td> <br>
                </tr>
                <%
            }
            %>
        </table>    
 
 
        <%
            /*
            String[] now = request.getParameterValues("id");
            
            if(now != null  &&  now.length != 0){
                for(int j = 0; j < now.length; ++j)
                       System.out.println(now[i]);
                       
            }
            else{
                System.out.println(now.length);
            }
            */
 
        %>
 
        
            <input type="submit"/>
        </form>
 
 
 
    </body>
</html>