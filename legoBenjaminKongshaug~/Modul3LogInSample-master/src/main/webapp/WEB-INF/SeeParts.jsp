<%-- 
    Document   : SeeParts
    Created on : 22-03-2019, 16:08:16
    Author     : benja
--%>

<%@page import="java.util.HashMap"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ordered parts</title>
        
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
        <%
         LegoHouse house = (LegoHouse) session.getAttribute("LegoHouse");
                    HashMap map = (HashMap) session.getAttribute("bricks");
                    %>
          <h3> you ordered a house with the width of <% out.println(house.getWidth()); %> dots and the depth of <% out.println(house.getDepth()); %> dots and the hight <% out.println(house.getHight()); %> hight </h3>
                    
<h2>Below you see what bricks are on the way for your Lego house:</h2>

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
  
  
 <h2>back to invoices </h2>
  
      <form method="POST" action="FrontController">
          <input type="hidden" name="command" value="invoices">
  <button 
      type="submit" class="btn 
      btn-success">invoices
  
  </button>
 </form>
    
    </body>
</html>
