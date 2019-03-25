<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%
HttpSession Session = request.getSession();
User user = (User) session.getAttribute("user");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
       
       <link type="text/css" rel="stylesheet" href="css/css.css"/>
       <style>
       table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
body{
background-color: #BC8F8F;
}
    </style>
    </head>
    <body>
        <h1>Hello <% out.println(user.getEmail()); %> </h1>
      
        <img src="https://i.imgur.com/ofrZWOn.jpg" alt="Smiley face" height="300" width="300">

          <h2>see your orders </h2>
  
      <form method="POST" action="FrontController">
          <input type="hidden" name="command" value="invoices">
  <button 
      type="submit" class="btn 
      btn-success">invoices
  
  </button>
 </form>
        
    <tr><td><br><br>Enter Your Mesurments<br><br></td>
                <td>
                    <form name="lego" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="CalculateLego">
                        width<br>
                        <input type="text" name="width" value="10">
                        <br>
                        depth<br>
                        <input type="text" name="depth" value="10">
                        <br>
                        hight<br>
                        <input type="text" name="hight" value="10">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <% if(session.getAttribute("LegoHouse") != null )
                {
                    LegoHouse house = (LegoHouse) session.getAttribute("LegoHouse");
                    HashMap map = (HashMap) session.getAttribute("bricks");
                     
 if (Session.getAttribute("inputError") == null)
 {
     
     %>
                    <h3> you want a house with the width of <% out.println(house.getWidth()); %> dots and the depth of <% out.println(house.getDepth()); %> dots and the hight <% out.println(house.getHight()); %> hight </h3>
                    
<h2>Bricks needed for your Lego house:</h2>

<table>
  <tr>
    <th>type</th>
    <th>side 1 pr row</th>
    <th>side 2 pr row</th>
    <th>side 3 pr row</th>
    <th>side 4 pr row</th>
    <th>tilsammen pr row</th>
    <th>tilsammen</th>
  </tr>
  <tr>
    <td> 2x4 </td>
    <td><% out.println(map.get("firstFour")); %></td>
    <td><% out.println(map.get("secondFour")); %></td>
    <td><% out.println(map.get("firstFour")); %></td>
    <td><% out.println(map.get("secondFour")); %></td>
    <td><% out.println(map.get("allFour")); %></td>
    <td><% out.println(map.get("allFourWithHight")); %></td>
  </tr>
  <tr>
    <td>2x2</td>
    <td><% out.println(map.get("firstTwo")); %></td>
    <td><% out.println(map.get("secondTwo")); %></td>
    <td><% out.println(map.get("firstTwo")); %></td>
    <td><% out.println(map.get("secondTwo")); %></td>
    <td><% out.println(map.get("allTwo")); %></td>
    <td><% out.println(map.get("allTwoWithHight")); %></td>
  </tr>
  <tr>
    <td>2x1</td>
    <td><% out.println(map.get("firstOne")); %></td>
    <td><% out.println(map.get("secondOne")); %></td>
    <td><% out.println(map.get("firstOne")); %></td>
    <td><% out.println(map.get("secondOne")); %></td>
    <td><% out.println(map.get("allOne")); %></td>
    <td><% out.println(map.get("allOneWithHight")); %></td>
  </tr>

  
</table>
  
  <div class="container">
  <h2>place your order</h2>
  
      <form method="POST" action="FrontController">
          <input type="hidden" name="command" value="Order">
  <button 
      type="submit" class="btn 
      btn-success">order now!
  
  </button>
 </form>
    
   

</div>
  
                    
                  <%  
                }
                else
 {
 out.println(Session.getAttribute("inputError"));
 Session.setAttribute("inputError", null);
 }
                }
                  %>
    </body>
</html>