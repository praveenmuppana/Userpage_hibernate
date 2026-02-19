<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List,com.user.webpage.User" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Admin Dashboard</title>
<link href="AdminDashboard.css"rel="stylesheet">
</head>
<body class="bg-light">
	
	<div class="container mt-5">
	<!-- side section -->
	<aside class="side_section">
		<div class="top">
			<div class="logo">
				<h2>Admin Dashboard</h2>
			</div>
		</div>
	</aside>
	<!-- Side section end -->
	<!-- main section -->
	<main>
		<div class="table-container">
		<h3>User details</h3>
		<table>
			<thead>
				<tr>
					<th>SNo</th>
					<th>ID</th>
					<th>Name</th>
					<th>UserName</th>
					<th>Email</th>
					<th>City</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%List<User> uList=(List<User>)request.getAttribute("allUsers");
				  if(uList!=null && !uList.isEmpty()){
					  int dId=1;
				  	for(User u:uList){
				  %>
				<tr>
				<td><%=dId++ %></td>
				<td><%=u.getId() %></td>
				<td><%=u.getName() %></td>
				<td><%=u.getUser_name() %></td>
				<td><%=u.getMail() %></td>
				<td><%=u.getCity() %></td>
				<td><a href="UpdateDelete.jsp?action=update&id=<%=u.getId()%>"class="action-update">Update</a>
				<a href="UpdateDelete.jsp?action=delete&id=<%=u.getId()%>"class="action-delete">Delete</a></td>
				</tr>
				<%}
				  	}else{ %>
				<tr><td colspan="6" class="text-center">No users found in database.</td></tr>
				<%} %>
			</tbody>
		</table></div>
		</main>
		<!-- main section end -->
		
		
	</div>
</body>
</html>