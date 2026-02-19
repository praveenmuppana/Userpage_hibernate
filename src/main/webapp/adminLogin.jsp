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
	background-image: url("https://wallup.net/wp-content/uploads/2017/11/17/242833-simple_background.jpg");
	background-repeat: no-repeat;
	align-items: center;
	height: 600px;
}

.div1 {
	background-color: transparent;
	padding: 30px;
	width: 100%;
	max-width: 350px;
}

.message {
	color: red;
	font-weight: bold;
}

#admin_name, #aPassword {
	align-items: center;
	padding: 10px;
	margin: 5px;
}

#alogin {
	margin-left: 80px;
	padding: 5px;
}

h1 {
	margin-left: 10px;
}
</style>
</head>
<body>
	<form action="UserAdmin" method="post">
		<div class="div1">
			<% String status=(String)request.getAttribute("status");
			 if("invalid".equals(status)){%>
			<p class="message">>Invalid login details</p>
			<%}else if("error".equals(status)){ %>
			<p class="message">Error in login</p>
			<%} %>
			<h1>Admin login</h1>
			<input type="text" placeholder="Enter admin name" name="admin_name"id="admin_name"><br> 
			<input type="password" placeholder="Enter Password" name="aPassword" id="aPassword"><br>
			<input type="submit" value="Login" id=alogin> <br>
			<a href="userLogin.jsp">User?</a> <br>
			<a href="userRegistration.jsp">New User?</a>
		</div>
	</form>
</body>
</html>