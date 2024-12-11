<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kat's Knitting Stuff</title>
<%@  include file="bootstraphead.jsp" %>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.9), rgba(255, 255, 255, 0.9)),
                  url("images/allknittingcrochetstuff.jpg");
}
</style>
</head>
<body>
<div class="container">
<div class="row">
	<a href="index.do"> Home</a>
	<br>
	<br>
</div>
<div class="row">
	<c:choose>
		<c:when test="${! empty needlesAndHooks }">
		<table class="table-bordered">
			<tr>
				<th>Id</th>
				<th>Material</th>
				<th>Type</th>
				<th>Length</th>
				<th>US Size</th>
				<th>Metric Size</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${needlesAndHooks}" var="needleOrHook">
				 <tr>
				 	<td>${needleOrHook.id}</td>
			  		<td>${needleOrHook.material}</td>
			  		<td>${needleOrHook.type} </td>
			  		<td>${needleOrHook.length }</td>
			  		<td>${needleOrHook.usSize}</td>
			  		<td>${needleOrHook.metricSize}</td>
			  		<td>${needleOrHook.quantity}</td>
				</tr>
			</c:forEach>
		</table>
	 	</c:when>
	 	<c:otherwise>
	 			<h3>No Needles or Hooks were found!</h3>
	 	</c:otherwise>
	 </c:choose>
</div>
</div>
</body>
</html>