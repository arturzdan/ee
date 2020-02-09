<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="com.accenture.flowershop.fe.dto.FlowerDto" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <p style = "margin-left: 50px; font-size: 50px; color:rgb(190, 5, 248)"><b>Flower Shop</b></p>
</head>
 <style>
	body {
   	   background: rgb(230, 230, 230);
   }
   </style>
    <body>
            <table border="1" width="50%" cellpadding="1">
                <tr>
                    <th><b>NAME</b></th>
                    <th><b>COUNT</b></th>
                    <th><b>VALUE</b></th>
                </tr>
    <%
        List<FlowerDto> flowerDtoList = (List<FlowerDto>)request.getAttribute("flowersList");
        for (FlowerDto it: flowerDtoList
             ) {
             %>

              <tr>
                <td><%=it.getName()%></td>
                <td><%=it.getCount()%></td>
                <td><%=it.getValue()%></td>
            </tr>
        <%}%>
    <p>

        </table>
    <p>
        <a href="index.jsp">Catalog</a>
        <a href="index.jsp">Cart</a>
    </body>
    <p>
        <a href="index.jsp">HOME</a>
</html>