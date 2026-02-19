<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	display: flex;
	justify-content: center;
	background-color:aqua;
	align-items: center;
	height: 600px;
}

.div1 {
	background-color: transparent;
	padding: 30px;
	width: 100%;
	max-width: 350px;
}

.smessage {
	color: green;
	font-weight: bold;
}

.message {
	color: red;
	font-weight: bold;
}

#user_name, #password, #name, #mail, #city {
	padding: 10px;
	margin: 5px;
}

#register {
	margin-left: 80px;
	padding: 5px;
}

h1 {
	margin-left: 10px;
}
</style>
</head>
<body>
	<form action="UserRegistration" method="post">
		<div class="div1">
			<% String status=(String)request.getAttribute("status");
			 if("success".equals(status)){%>
			<p class="smessage">Successfully Registered</p>
			<%}else if("exists".equals(status)){ %>
			<p class="message">UserName already Exists</p>
			<%}else if("invalid".equals(status)){ %>
			<p class="message">Please fill in all Fields</p>
			<%}else if("error".equals(status)){ %>
			<p class="message">Failed to register</p>
			<%} %>
			<h1>User Registration</h1>
			<input type="text" placeholder="Enter user_name" name="user_name"id="user_name"><br> 
			<input type="password" placeholder="Enter Password" name="password" id="password"><br>
			<input type="text" placeholder="Enter your name" name="name" id="name"><br> 
			<input type="email"	placeholder="Enter Email" name="mail" id="mail"><br> 
			<input type="text" placeholder="Enter your city" name="city" id="city"><br>
			<input type="submit" value="Register" id="register"> <br>
			<a href="userLogin.jsp">User?</a><br> 
			<a href="adminLogin.jsp">Admin?</a>
		</div>
	</form>
</body>
</html>