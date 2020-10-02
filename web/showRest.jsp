<%-- 
    Document   : showRest
    Created on : Dec 14, 2016, 10:56:57 PM
    Author     : Seeum
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <h1>Here are the restaurents in your selected area:</h1>
        <font color="black" face="ARIAL" size="5">
        <%
             String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "see";
        String db_password = "see";
        Connection conn=null;
        String here = null;
            
        Class.forName("oracle.jdbc.OracleDriver");
        conn = DriverManager.getConnection(dbURL, username, db_password);
        System.out.println("HERE1");
        if(conn!=null) System.out.println("Connection successfully established.");
        else System.out.println("Could not establish connection");
        
            String area=(String)session.getAttribute("area");
            ArrayList<String>list=(ArrayList<String>)(session.getAttribute("list"));
            int i;
            
            ArrayList<Integer>res_id=(ArrayList<Integer>)(session.getAttribute("res_id"));
            ArrayList<Float>rating=new ArrayList<Float>();
           ArrayList<Integer>rev_count=new ArrayList<Integer>();
            String query="Select RATING from REVIEW where RESTAURENT_ID=?";
            PreparedStatement stmt=conn.prepareStatement(query);
                
            
            for(i=0;i<res_id.size();i++){
                
                stmt.setInt(1,res_id.get(i));
                ResultSet rs=stmt.executeQuery();
                int cnt=0;
                float sum=0;
                while(rs.next()){
                    String s=rs.getString("RATING");
                    Float f=new Float(0);
                    f=Float.parseFloat(s);
                    sum+=f;
                    cnt++;
                 }
                
                if(cnt!=0)
                {
                float final_rev=(sum/cnt);
                rating.add(final_rev);
                rev_count.add(cnt);
                }
                else{
                    rating.add(sum);
                    rev_count.add(cnt);
                }
                
              }
            
            for(i=0;i<list.size();i++){
                System.out.println(list.get(i)+" "+res_id.get(i)+" "+rating.get(i)+" "+rev_count.get(i)+" "+"in show rest");
            }
            %>
            
            <table>
            <tr>
                <th>Restaurent</th>
                <th>Rating(Out of 5)</th>
            </tr>
            <%
            
    
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            for(i=0;i<list.size();i++)
            {
                 %>
                 <tr>
                     <td> <a href="ShowFood?area=<%=area%>&res=<%=list.get(i)%>"><%=list.get(i)%></a></td>
                     <td><%=rating.get(i)%>(<%=rev_count.get(i)%> Reviews)</td>
                 </tr>
                <%
                
            }
            
            
            
        %>
            </table>
        
        </font>
        
    </body>
</html>
