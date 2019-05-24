<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-4">

	<div class="container">
		<a class="navbar-brand" href="index.jsp"> Top10 List </a>

		<div class="collapse navbar-collapse" id="mobile-nav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item">
					<a class="nav-link" href="list"> ALL LISTS </a>
				</li>
				
				<c:if test="${sessionScope.username != null }">
					<li class="nav-item">
						<a class="nav-link" href="userLists"> MY LISTS </a>
					</li>
				</c:if>
			</ul>
	
			<ul class="navbar-nav ml-auto">
			
				<c:if test="${sessionScope.username == null }">
				
					<li class="nav-item">
						<a class="nav-link" href="user?action=signup"> REGISTER </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="user?action=login"> LOGIN </a>
					</li>
				
				</c:if>
				
				<c:if test="${sessionScope.username != null }">
				
					<li class="nav-item">
						<a class="nav-link" href="addList"> ADD NEW LIST </a>
					</li>
				
					<li class="nav-item">
						<span class="nav-link"> Logged as: ${sessionScope.username} </span>
					</li>
				
					<li class="nav-item">
						<a class="nav-link" href="logout"> LOGOUT </a>
					</li>
				
				</c:if>
				
			</ul>
			
		</div>
	</div>

</nav>