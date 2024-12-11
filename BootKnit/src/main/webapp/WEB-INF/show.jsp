<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kat's Knitting Stuff</title>
<%@  include file="bootstraphead.jsp" %>
</head>
<body>

<div class="container">
	<div class="row">
		<a href="index.do"> Home</a>
		<br>
		<br>
		<c:choose>
			<c:when test="${! empty needleOrHook }">
		 		<h5>
		 			Id: ${needleOrHook.id}<br>
			  		Material: ${needleOrHook.material} <br>
			  		Type: ${needleOrHook.type} <br> 
			  		Length: ${needleOrHook.length } inches<br>
			  		US Size: ${needleOrHook.usSize} <br>
			  		Metric Size: ${needleOrHook.metricSize}<br>
			  		Quantity: ${needleOrHook.quantity}
			  	</h5>
			  	<br>
			  	<br>
			  	<br>
			  	<br>
			  	 <div id="outer">
					<div class="inner">
					<form action="deleteHookOrNeedle.do">
						<input type="hidden" id="id" name="id" value="${needleOrHook.id}" />
						<input type="submit" value="Delete the Needle, Hook or Cable"/>
					</form>
					</div>
					<br>
					<div class="inner">
					<form action="updateNeedleOrHookGetInfo.do">
						<input type="hidden" id="id" name="id" value="${needleOrHook.id}" />
						<input type="submit" value="Update the Needle's, Hook's or Cable's information"/><br>
					</form>
					</div>
					<br>
		 </div>
		 	</c:when>
		 	<c:otherwise>
		 			<h3>Needle Or Hook not found!</h3>
		 	</c:otherwise>
		 </c:choose>
		
	</div>
</div>
<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>