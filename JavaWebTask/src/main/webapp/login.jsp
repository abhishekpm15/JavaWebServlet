<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>

<% if(request.getAttribute("fieldEmpty") != null && request.getAttribute("fieldEmpty").equals("true")){ %>
	
	<div class="modal">
		<div class="detailsError">Fill all the details !</div>
	</div>

<% }%>
		<div id="formDivMain">
			<form action="LoginServlet" method="post">
			<h1>Login Page</h1>
					<div class="inputs">
						<div class="field field1">
							<label for="loginID">Login ID: &nbsp;</label> 
							<input type="text" id="customerID" name="customerID" placeholder="Enter Login ID" class="inps">
						</div>
						<div class="field">
							<label for="password">Password:</label> 
							<input type="password" id="password" name="password" placeholder="Enter Password" class="inps">
						</div>

					</div>
					<div class="btn">						
						<button id="sub">Login</button>
					</div>
					<%
				String status = (String) request.getAttribute("status");
				if (status != null)
					if (status.equals("wrongPassword")) {
				%>
				<div id="error">Invalid Username or password..!</div>
				<%
				}
				%>
				<div class="alreadyLog">New User ? <a href="<%= request.getContextPath() %>/register.jsp">Register</a> </div>				
			</form>
	</div>
</body>
</html>

