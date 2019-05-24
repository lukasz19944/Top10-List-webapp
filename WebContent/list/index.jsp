<%@page import="web.dao.UserDao"%>
<%@page import="web.entity.User"%>
<%@page import="web.entity.ListVote"%>
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

		<h3>All Lists</h3>

		<c:forEach var="list" items="${lists}">
			<div class="list">

				<div class="list_name">
					<a href="list?action=detail&id=${list.id}"> ${list.name} </a>
				</div>
				<div style="float:left;padding-left:3px;width:20px;">

					<a href="rateList?id=${list.id}&vote=up">

						<div
							style="width: 0; height: 0; border-left: 5px solid transparent; border-right: 5px solid transparent; border-bottom: 10px solid green; margin-bottom: 5px; margin-top: 5px; position: relative;">
						</div>

					</a> <a href="rateList?id=${list.id}&vote=down">
						<div
							style="width: 0; height: 0; border-left: 5px solid transparent; border-right: 5px solid transparent; border-top: 10px solid red;">
						</div>
					</a>
					
					
					<div class="rating">${list.calculateRating()}</div>
						

				</div>
				<div class="list_desc" style="float:left;margin-left:14px;">
					${list.description}</div>

				<div style="clear: both"></div>

				<div class="list_author">Added by: ${list.author.username}</div>
				<div class="list_date">${list.publishDate}</div>
				<div class="clear"></div>

			</div>
		</c:forEach>

	</div>


	<jsp:include page="/fragments/footer.jsp"></jsp:include>

</body>
</html>