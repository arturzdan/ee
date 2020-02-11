<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="com.accenture.flowershop.fe.dto.FlowerDto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.accenture.flowershop.fe.dto.UserDto"%>
<html>
<head>
    <p style = "margin-left: 50px; font-size: 50px; color:rgb(190, 5, 248)"><b>Flower Shop</b></p>
</head>
 <style>
	body {
   	   background: rgb(230, 230, 230);
   }
      td {
       text-align: center;
      }
   </style>
    <body>
    <form action="searchServlet" method="post">
        Search <input type="text" name="search">
        Min <input type="number" name="min" min="1" max="1000" value="1" step="1">
        Max <input type="number" name="max" min="1" max="1000" value="1" step="1">
        <button type="submit" name="btn">Go</button>
    </form>
        <p>
        <%
        UserDto user = (UserDto)session.getAttribute("userDto");%>
        Hello, <%=user.getLogin()
        %>.
        <form action="flowersServlet" method="post">
            <table border="1" width="50%" cellpadding="1">
                <tr>
                    <th><b>NAME</b></th>
                    <th><b>COUNT</b></th>
                    <th><b>VALUE</b></th>
                    <th><b>Buy</b></th>
                </tr>
        <%
            List<FlowerDto> flowerDtoList = (List<FlowerDto>)request.getAttribute("flowersList");
                for (FlowerDto it: flowerDtoList) {
        %>

              <tr>
                <td><%=it.getName()%></td>
                <td><%=it.getCount()%></td>
                <td><%=it.getValue()%></td>
                <td>
                <input type="number" name="count" min="1" max="1000" value="1" step="1">
                <button type="submit" name="idFlower" value=<%=it.getId()%>>-></button>
                </td>
            </tr>
        <%}%>
    <p>

        </table>
        </form>
    <p>
        <a href="index.jsp">Catalog</a>
        <a href="index.jsp">Cart</a>
    </body>
    <p>
        <a href="index.jsp">HOME</a>
</html>