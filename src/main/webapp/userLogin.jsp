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
	background-image:url("https://getwallpapers.com/wallpaper/full/2/9/e/1224127-cool-plain-hd-wallpapers-1920x1080-for-iphone-6.jpg");
	background-repeat:no-repeat;
	align-items: center;
	height: 600px;
}

.addiv {
	background-color: transparent;
	padding: 30px;
	width: 100%;
	max-width: 350px;
}

#user_name, #password {
	padding: 10px;
	margin: 5px
}

#aloginbtn {
	margin-left: 80px;
	padding: 5px;
}

h1 {
	margin-left: 10px;
}

.message {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<form action="UserLogin" method="post">
		<div class="addiv">
			<%
			String status = (String) request.getAttribute("status");
			if ("invalid".equals(status)) {
			%>
			<p class="message">Invalid login details</p>
			<%
			} else if ("error".equals(status)) {
			%>
			<p class="message">error in login</p>
			<%
			}
			%>
			<h1>User Login</h1>
			<input type="text" placeholder="enter username" name="user_name" id="user_name"><br> 
			<input type="password" placeholder="enter password" name="password" id="password"><br>
			<input type="submit" value="login" id="aloginbtn"><br> 
			<a href="userRegistration.jsp">New User?</a><br> 
			<a href="adminLogin.jsp">Admin?</a>
		</div>
	</form>
</body>
</html>