<%-- 
    Document   : invoices
    Created on : 20-03-2019, 19:22:21
    Author     : benja
--%>

<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="java.util.ArrayList"%>
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
            <p> You ordered a house with the width of <% out.println(house.getWidth()); %>  
                dots and the depth of <% out.println(house.getDepth()); %> 
                dots and the hight <% out.println(house.getHight()); %> hight.
                your order has <b> <% if (house.getShippingStatus()) {
                        out.println("been shipped");
                    } else {
                        out.println("unfortunatly not been shipped yet");
                    }
                %>
                </b>

            </p>
             <form method="POST" action="FrontController">
            <input type="hidden" name="command" value="partsForOrder">
             
            <input type="hidden" name="email" value="<% out.println(user.getEmail()); %>">
            <input type="hidden" name="password" value="<% out.println(user.getPassword()); %>">
              <input type="hidden" name="seeParts" value="<% out.println(house.getId()); %>">
              
            <button 
                type="submit" class="btn 
                btn-success">see parts

            </button>
        </form>
            

            
            <% 
               
                }
            %>

    </body>
</html>
