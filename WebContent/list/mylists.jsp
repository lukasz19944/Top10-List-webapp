<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	
	<style>
	.list {
		margin-bottom: 30px;
		background-color: #f2efef;
		padding: 8px;
	}
	
	.list_name a {
		text-decoration: none;
		color: black;
	}
	
	.list_desc {
		min-height: 60px;
		padding-left: 10px;
	}
	
	.list_author {
		float: left;
		font-size: 12px;
	}
	
	.list_date {
		float: right;
		font-size: 12px;
	}
	
	.clear {
		clear: both;
	}
</style>

</head>
<body>

	<jsp:include page="/fragments/header.jsp"></jsp:include>
	
	
	<div class="container">

		<h3>My Lists</h3>
		
		<c:forEach var="list" items="${my_lists}">
			<div class="list">

				<div class="list_name">
					<a href="list?action=detail&id=${list.id}">
						${list.name}
					</a>
				</div>
				<div class="list_desc">
					${list.description}
				</div>
				<div class="list_author">
					Added by: ${list.author.username}
				</div>
				<div class="list_date">
					${list.publishDate}
				</div>
				<div class="clear"></div>

			</div>
		</c:forEach>

	</div>
	

	<jsp:include page="/fragments/footer.jsp"></jsp:include>

</body>
</html>