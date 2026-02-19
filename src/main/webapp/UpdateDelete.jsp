<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Action</title>
</head>
<body>
    <%
        String action = request.getParameter("action");
        String userId = request.getParameter("id");
        String title = (action != null && action.equalsIgnoreCase("update")) ? "Update User" : "Delete User";
    %>
    <h2><%= title %> (ID: <%= userId %>)</h2>

    <form action="UpdateDelete" method="post">
    <input type="hidden" name="action" value="<%=action%>"> 
    <input type="hidden" name="id" value="<%=userId %>">
    
    
    <% if ("update".equalsIgnoreCase(action)) { %>
    
    <select name="columnName">
        <option value="name">Name</option>
        <option value="mail">Email</option>
        <option value="city">City</option>
    </select>
        <input type="text" name="newData" placeholder="Enter new value" required>
    <% } else { %>
        <p style="color:red; display:inline;">Are you sure you want to delete this user?</p>
    <% } %>
    <button type="submit">Execute</button>
</form>
</body>
</html>