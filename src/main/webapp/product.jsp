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
        <% UserDto user = (UserDto)session.getAttribute("userDto");%>
        Hello, <%=user.getLogin()%>.
        <% FlowerDto flower = (FlowerDto)request.getAttribute("flowers");%>
        <%=flower.getName()%>.
</body>
</html>

