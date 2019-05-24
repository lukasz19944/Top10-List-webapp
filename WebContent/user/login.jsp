<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath}/assets/css/style.css"
	rel="stylesheet" type="text/css">
	
		<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">


	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
		

</head>
<body>

	<jsp:include page="/fragments/header.jsp"></jsp:include>
	
	<div class="container" style="text-align:center;">

		<h3>Login</h3>
	
		<p style="color:red;">${error}</p>
	
		<form method="post" action="user?action=login" style="display:inline-block;" >
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Login">
						<br>
						<a href="user?action=signup">Do not have an account? Sign up</a>
					</td>
				</tr>
			</table>
		</form>
		
		<jsp:include page="/fragments/footer.jsp"></jsp:include>
	
	</div>

</body>
</html>