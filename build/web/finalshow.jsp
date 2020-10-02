<%-- 
    Document   : finalshow
    Created on : Dec 17, 2016, 10:57:55 PM
    Author     : Seeum
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <font color="black" face="ARIAL" size="5">
        <%
            
            ArrayList<String>finalfoods=new ArrayList<String>();
            ArrayList<Integer>finalquantity=new ArrayList<Integer>();
            ArrayList<Integer>finalprice=new ArrayList<Integer>();
            
            finalfoods=(ArrayList<String>)session.getAttribute("finalfoods");
            finalquantity=(ArrayList<Integer>)session.getAttribute("finalquantity");
            finalprice=(ArrayList<Integer>)session.getAttribute("finalprice");
            
            //total=(int)session.getAttribute("total");
            String area=(String)session.getAttribute("area");
            int total=(Integer)session.getAttribute("total");
            
            session.setAttribute("total",total);
            session.setAttribute("area", area);
            
            int cus_id=(Integer)session.getAttribute("id");
            
            System.out.println(cus_id+" IN FINAL");
            
            
            
          %>  
        
        
        
        <h1>Here is your order...</h1>
        <form method="post" action="post_order">
        <table>
            <tr>
                <th>Food</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            
            <%
                 int i;
                 for(i=0;i<finalfoods.size();i++)
                 {
                     %>
                     <tr>
                         <td><%=finalfoods.get(i)%></td>
                         <td><%=finalprice.get(i)%></td>
                         <td><%=finalquantity.get(i)%></td>
                     </tr>
                    
                     
                   <%  
                     
                 }
                
                
                
                
                
                
                
                
                
                
                
                
                
                %>
          </table>
          <br><br>
                Area<br>
                <input type="text" value="<%=area%>" readonly><br><br>
                Total payment<br>
                <input type="text" value="<%=total%>" readonly><br>
                <input type="submit" name="Change" value="Confirm"/>
        </form>
          </font>
    </body>
</html>
