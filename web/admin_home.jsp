<%-- 
    Document   : admin_home
    Created on : Dec 18, 2016, 6:01:02 PM
    Author     : Seeum
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome Admin</h1>
        <%
            
        String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "see";
        String password = "see";
    
    
        Connection conn = null;
    
        
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            System.out.println("HERE1");
            if(conn!=null) System.out.println("Connection successfully established.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

        String Command = "Select ORDER_ID from ORDERS where EMPLOYEE_ID=?";
        PreparedStatement stmt = conn.prepareStatement(Command);
        
        stmt.setInt(1,0);
        ResultSet rs=stmt.executeQuery();
        ArrayList<Integer>pending=new ArrayList<Integer>();
        while(rs.next())
        {
            int here=rs.getInt("ORDER_ID");
            System.out.println(here);
            pending.add(here);
        }
        
        String Command1="Select EMPLOYEE_ID from EMPLOYEE where AVAILABILITY=?";
        PreparedStatement stmt1=conn.prepareStatement(Command1);
        stmt1.setInt(1, 1);
        ResultSet rs1=stmt1.executeQuery();
        ArrayList<Integer>available_emp=new ArrayList<Integer>();
        
        while(rs1.next()){
            int here=rs1.getInt("EMPLOYEE_ID");
            System.out.println(here);
            available_emp.add(here);
        }
        
        String Command2="Select EMPLOYEE_ID from EMPLOYEE where AVAILABILITY=?";
        PreparedStatement stmt2=conn.prepareStatement(Command2);
        stmt2.setInt(1, 0);
        ResultSet rs2=stmt2.executeQuery();
        ArrayList<Integer>busy_emp=new ArrayList<Integer>();
        
        while(rs2.next()){
            int here=rs2.getInt("EMPLOYEE_ID");
            System.out.println(here);
            busy_emp.add(here);
        }
        
        %>
        
         <form method="post" action="assign_order">
             Pending Orders:

            <select name="pending">

                <%
            int i=0;
            for(i=0;i<pending.size();i++){
                %>
                <option value="<%= pending.get(i)%>"><%= pending.get(i)%></option>
                <%
                
            }
 
        %>
            </select>
         
            
            <br><br>
                Available Employee:
                
                 <select name="available_emp">

                <%
                 int k=0;
                for(k=0;k<available_emp.size();k++){
                %>
                <option value="<%= available_emp.get(k)%>"><%=available_emp.get(k)%></option>
                <%
                
            }
 
        %>
            </select>
         
            <input type="submit"/>
        </form>
            <br><br>
            <form method="post" action="process_free">
             Free employee:
             
           <select name="free">

                <%
                for(i=0;i<busy_emp.size();i++){
                %>
                <option value="<%= busy_emp.get(i)%>"><%= busy_emp.get(i)%></option>
                <%
                
            }
 
        %>
            </select>
             <input type="submit"/>
        </form>
            <br><br>
             <form method="post" action="admin_home.jsp">
         <input type="submit" value="Refresh"/>  
         
                
                
                
                
                
                
                
                
                
                
                
           
        
        
        
        

            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
        
        
        
        
        
        
        
        
        
    </body>
</html>
