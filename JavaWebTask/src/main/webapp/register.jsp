

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="register.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
	rel="stylesheet">
<!-- 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 -->
</head>
<body>

	<%
	String status = (String) request.getAttribute("status");
	if (status != null) {
		if (status.equals("success")) {
	%>
	<div class="modal">
		<div class="registerSuccess">
			Registered Successfully: <span class="idSpan"> <%=request.getAttribute("customerID")%>
			</span>
		</div>
		<span class="paraSuccess">Now you may Login </span>
	</div>
	<%
	} else if (status.equals("emailError")) {
	%>
	<div class="modal">
		<div class="detailsError">Email validation failed !</div>
	</div>
	<%
	} else if (status.equals("passwordError")) {
	%>
	<div class="modal">
		<div class="detailsError">Password validation failed !</div>
	</div>
	<%
	} else if (status.equals("fillDetails")) {
	%>
	<div class="modal">
		<div class="detailsError">Fill all the details !</div>
	</div>

	<%
	} else {
	%>
	<div class="modal">
		<div class="registerError">Could not register User !</div>
	</div>
	<%
	}
	}
	%>
	<div class="bodyContent">
		<div class="leftContent">
			<h1>Customer Registration</h1>
		</div>
		<div class="rightContent">
			<form action="RegisterServlet" method="post">
				<div class="formDiv">
					<div class="inputs">
						<label>Customer ID: </label> <input class="field" id="id"
							type="text" value="" name="id"
							placeholder="Customer ID: Auto Generated" readonly="true" />
						<div class="btnClass">
							<button id="generateBtn1" onclick="generateBtn(event)">Generate</button>
						</div>
						<label>Customer Name: </label> <input class="field" type="text"
							name="name" placeholder="Customer Name" /> <label>Customer
							Email: </label> <input class="field" type="text" name="email"
							placeholder="Customer Email" /> <label>Customer
							Password: </label> <input class="field" type="password" name="password"
							placeholder="Password" /> <label>Customer Address: </label>
						<textarea class="field" placeholder="Address" name="address"
							rows="3" cols="50"></textarea>
						<label>Customer Contact: </label> <input class="field" type="text"
							name="contact" placeholder="Contact Details" />
					</div>
					<span class="alreadyLog">Already registered ? <a
						href="<%=request.getContextPath()%>/login.jsp">Login</a>
					</span> <input id="submit" type="submit" value="Register" />
				</div>
			</form>
		</div>
	</div>
	<script src="script.js"></script>
</body>

</html>

