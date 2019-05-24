<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">


<script
	src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="/fragments/header.jsp"></jsp:include>

	<div class="container" style="text-align:center;">

	<h3>Sing up</h3>
	
	<p style="color:red;">${error}</p>

	<form method="post" action="user?action=signup" style="display:inline-block;">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
				<td><p style="color:red;">${error_username}</p></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
				<td><p style="color:red;">${error_password}</p></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Sign up">
				</td>
			</tr>
		</table>
	</form>

</div>
</body>
</html>