<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="home.css"/>
</head>
<body>
<div class="content">
	<h2> Welcome home <span class="userName"> <%=session.getAttribute("customerName") %> </span></h2>
</div>
</body>
</html>