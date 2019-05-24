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
		
		
	<style type="text/css">
	
		.item {
			margin-bottom:15px;
			background-color: #f2efef;
			padding: 8px;
		}
		
		.item_name {
			float: left:
		}
		
		.item_index {
			float: left;
		}
		
		.item_desc {
			padding-left: 12px;
		}
		
	
	</style>
	
</head>
<body>


	<jsp:include page="/fragments/header.jsp"></jsp:include>

	<div class="container">
	

		<h3><a href="list" style="text-decoration:none;color:black;">All Lists</a> &lt;&lt; ${list.name}</h3> 
	
	
		<div class="list">

			<div class="list_name">
				${list.name}
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
		
		<div class="items">
			<c:forEach var="item" items="${list.items}" varStatus="i">
				<div class="item">
					
					<div class="item_index">
						${i.index + 1}. 
					</div>
					<div class="item_name">
						${item.name}
					</div>
					<div class="clear"></div>
					<div class="item_desc">
						${item.description}
					</div>
					
				</div>
			</c:forEach>
		</div>
	
	</div>
	

	<jsp:include page="/fragments/footer.jsp"></jsp:include>

	<%-- <c:if test="${sessionScope.username == null }">
		<a href="account?action=login">Login to post your reviews</a>
	</c:if>

	<c:if test="${sessionScope.username != null }">
	
		<form method="post" action="product?action=send">
			<table>
				<tr>
					<td>Rating</td>
					<td>
						<div id="rating"></div>
						<input type="hidden" name="hdrating" id="hdrating">
					</td>
				</tr>
				<tr>
					<td valign="top">Content</td>
					<td>
						<textarea name="content" rows="5" cols="20"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Send">
						<input type="hidden" name="productId" value="${product.id}">
					</td>
				</tr>
			</table>
		</form>
		
	</c:if> --%>


</body>
</html>