<%-- 
    Document   : allInvoices
    Created on : 20-03-2019, 20:33:02
    Author     : benja
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>invoice page</title>
    </head>
    <body>
       
        <% User user = (User) session.getAttribute("user");
            ArrayList<LegoHouse> orders = (ArrayList) session.getAttribute("orders");
            ; %>
       
        You are now logged in as a EMPLOYEE of our wonderful site.
            <h1>welcome to the invoice page</h1>


        <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="login">
            <input type="hidden" name="email" value="<% out.print(user.getEmail()); %>">
            <input type="hidden" name="password" value="<% out.print(user.getPassword()); %>">
            <button 
                type="submit" class="btn 
                btn-success">home

            </button>
              </form>

            <%
                for (LegoHouse house : orders) {

            %>
            <p> <% out.println(house.getEmail()); %> ordered a house with the width of <% out.println(house.getWidth()); %>  
                dots and the depth of <% out.println(house.getDepth()); %> 
                dots and the hight <% out.println(house.getHight()); %> hight. </p>
                 <b> <% if (house.getShippingStatus()) {
                        out.println("The order has been shipped");
                    } else {
                        out.println("ship the order: ");
                        
                        %>
                        
                        
                        
                         <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="shipOrder">
            <input type="hidden" name="houseId" value="<% out.print(house.getId()); %>">
            <input type="hidden" name="email" value="<% out.print(user.getEmail()); %>">
            <input type="hidden" name="password" value="<% out.print(user.getPassword()); %>">
             
            <button 
                type="submit" class="btn 
                btn-success">ship

            </button>
                         </form>
                            
                        <%
                    }
                %>
                </b>

            </p>

            <%
                }
            %>

    </body>
</html>
