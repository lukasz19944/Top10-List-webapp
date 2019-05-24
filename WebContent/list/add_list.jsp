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
	

</head>
<body>

	<jsp:include page="/fragments/header.jsp"></jsp:include>
	
	<div class="container">

		<h3>List informations</h3>
		
		<hr>
		
		<div class="list_add">
			<form method="post" action="addList?action=add">
			
				<table>
					<tr>
						<td>Name</td>
						<td>
							<input type="text" name="list_name" class="item_name">
						</td>
					</tr>
					<tr>
						<td>Description</td>
						<td>
							<textarea name="list_description" rows="5" cols="40"></textarea>
						</td>
					</tr>
				</table>
				
				<hr>
				
				<h3>Items</h3>
				
				<hr>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">1.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item1_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item1_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">2.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item2_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item2_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">3.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item3_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item3_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">4.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item4_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item4_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">5.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item5_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item5_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">6.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item6_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item6_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">7.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item7_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item7_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">8.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item8_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item8_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">9.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item9_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item9_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
				<div class="" style="float:left;font-size:40px;width:40px;text-align:right;">10.</div>
				<div class="" style="float:left;">
				
					<table>
						<tr>
							<td>Name</td>
							<td>
								<input type="text" name="item10_name" class="item_name">
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<textarea name="item10_description" rows="3" cols="40"></textarea>
							</td>
						</tr>
						
						<tr>
							<td></td>
							<td>
								<input type="submit" value="Send">
							</td>
						</tr>
					</table>
				
				</div>
				
				<div class="" style="clear:both;"></div>
				
			</form>
			
		</div>

	</div>

	<jsp:include page="/fragments/footer.jsp"></jsp:include>

</body>
</html>