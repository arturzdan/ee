<!DOCTYPE html>
<head>
    <p style = "margin-left: 50px; font-size: 50px; color:rgb(190, 5, 248)"><b>Flower Shop</b></p>
</head>
 <style>
	body {
   	   background: rgb(230, 230, 230);
   }
   </style>
    <body>
        <form action="register" method="post">
        <p style = "margin-left: 35px; font-size: 35px">Create account</p>
        <label for="last_name">Last name </label>
        <input type="text" name="last_name" required>
        <p>
        <label for="first_name">First name </label>
        <input type="text" name="first_name" required>
        <p>
        <label for="middle_name">Middle name </label>
        <input type="text" name="middle_name" required>
        <p>
        <label for="address">Address</label>
        <input type="text" name="address" required>
        <p>
        <label for="mobile">Mobile</label>
        <input type="text" name="mobile" required>
        <p>
        <label for="name">Login</label>
        <input type="text" name="login" required>
        <p>
        <label for="password">Password</label>
        <input type="password" name="password" required>
        <p>
        <button type="submit">OK</button>
        <p>
    </body>
        <a href="index.jsp">HOME</a>
</html>