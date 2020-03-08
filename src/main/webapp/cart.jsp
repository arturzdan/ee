<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="com.accenture.flowershop.fe.dto.UserDto"%>
<%@ page import="com.accenture.flowershop.fe.dto.OrderItemDto"%>
<%@ page import="java.util.List" %>
<html>
<head>
    <p style = "margin-left: 50px; font-size: 50px; color:rgb(190, 5, 248)"><b>Flower Shop</b></p>
</head>
 <style>
	body {
   	   background: rgb(220, 220, 220);
   }
         td {
          text-align: center;
         }
   </style>
    <body>
        <p>
        <form action="" method="post">
        <% UserDto user = (UserDto)session.getAttribute("userDto");%>
        Hello, <%=user.getLogin()%>.
        <p>
        </form>
<form action="orderServlet" method="post">
            <table border="1" width="10%" cellpadding="1">
                <tr>
                    <th><b>NAME</b></th>
                    <th><b>COUNT</b></th>
                </tr>
        <%List<OrderItemDto> cartList = (List<OrderItemDto>)session.getAttribute("cartList");
                for (OrderItemDto it: cartList){%>
              <tr>
                <td><%=it.getFlowerDto().getName()%></a></td>
                <td><input type="number" name="count" min="0" max="1000" value=<%=it.getCount()%> step="1"></td>
              </tr>
        <%}%>
        </table>
        <p>
        <td><button type="submit" name="btnOrder" value="value">Go order</button></td>
        </form>
</body>
</html>

