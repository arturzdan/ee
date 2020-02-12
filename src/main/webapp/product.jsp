<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="com.accenture.flowershop.fe.dto.UserDto"%>
<%@ page import="com.accenture.flowershop.fe.dto.FlowerDto"%>
<html>
<head>
    <p style = "margin-left: 50px; font-size: 50px; color:rgb(190, 5, 248)"><b>Flower Shop</b></p>
</head>
 <style>
	body {
   	   background: rgb(220, 220, 220);
   }
   </style>
    <body>
        <p>
        <form action="addCartServlet" method="post">
        <% UserDto user = (UserDto)session.getAttribute("userDto");%>
        Hello, <%=user.getLogin()%>.
        <p>
        <% FlowerDto flower = (FlowerDto)session.getAttribute("flowerDto");%>
        Name flower: <%=flower.getName()%>,
        <%int x = flower.getCount();%>
        count: <%=x%>
        <p>
        Enter count <input type="number" name="count" min="0" max=<%=x%> value="0" step="1">
        <p>
        <button type="submit" name="button" value="button1">Buy</button>
        </form>
</body>
</html>

