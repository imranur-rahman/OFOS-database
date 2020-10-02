<%-- 
    Document   : take_quantity
    Created on : Dec 17, 2016, 7:43:30 PM
    Author     : Seeum
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <font color="black" face="ARIAL" size="5">
        Provide quantity for your selected foods below...<br><br>
        <%
            //String[] selectedfood=(String[])session.getAttribute("selectedfood");
            ArrayList<String>list=new ArrayList<String>();
            list=(ArrayList<String>)session.getAttribute("list");
            session.setAttribute("list",list);
            
            ArrayList<Integer>selectedid=new ArrayList<Integer>();
            selectedid=(ArrayList<Integer>)session.getAttribute("selectedid");
            session.setAttribute("selectedid",selectedid);
            /*request.setAttribute("selectedfoods", here);
            RequestDispatcher rd = request.getRequestDispatcher("Process_quantity");
            rd.forward(request, response);*/
            
          %>
          <form method="post" action="Process_quantity">
          <%
                    
                    for(int i=0;i<selectedid.size();i++){
                        
                       
                        System.out.println("take" + list.get(selectedid.get(i)));
            %>
            <%=list.get(selectedid.get(i))%><br>
            <input type="number" name="qty" min="1" required><br>
              
                        
                <%        
                }
                    
                    
                    
                    
                    
           %>
         
            
           
           <br><br>
           Provide Your Area Here...<br>
           <textarea rows="5" cols="15" name="area" required></textarea>
        
            <input type="submit" name="Change"/>
        </form>
            
           </font>
    </body>
</html>
