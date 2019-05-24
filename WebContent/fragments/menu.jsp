<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menu" style="width:100%;height:20px;background-color:#d1cfcf;">

	<div class="bar"
		style="width: 70%; margin-left: auto; margin-right: auto">
		
		<div class="navbar">
			<div class="all_lists" style="float:left;padding-right:20px">
				<a href="list" style="text-decoration:none;color:black;">ALL LISTS</a>
			</div>
			
			<c:if test="${sessionScope.username != null }">
				<div class="my_lists" style="float:left;padding-right:20px">
					<a href="userLists" style="text-decoration:none;color:black;">MY LISTS</a>
				</div>
			</c:if>
		</div>
		
		<c:if test="${sessionScope.username == null }">
			<div class="register_bar" style="float:right;">
				<a href="user?action=signup" style="text-decoration:none;color:black;">REGISTER</a>
			</div>
			
			<div class="login_bar" style="float:right;padding-right:20px">
				<a href="user?action=login" style="text-decoration:none;color:black;">LOGIN</a>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.username != null }">
			<div class="username" style="float:right;">
				Logged as: ${sessionScope.username}
			</div>
			<div class="logout" style="float:right;padding-right:20px">
				<a href="logout" style="text-decoration:none;color:black;">LOGOUT</a>
			</div>
			<div style="clear:both"></div>
			<div class="add_list" style="margin-left:auto;margin-right:auto;
				width:100px;text-align:center;background-color:white;color: black; 
				border:2px solid #E0E0E0;">
				<a href="addList" style="text-decoration:none;color:black;font-size:18px;">ADD NEW</a>
			</div>
		</c:if>

	</div>


</div>

<div style="clear:both"></div>

<hr style="margin:0">