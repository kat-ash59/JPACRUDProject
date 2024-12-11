<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Needle Or Hook Information</title>
<%@  include file="bootstraphead.jsp" %>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/allknittingcrochetstuff.jpg");
}
</style>
</head>
<body>
	<div class="container">
	<h1>Needle Or Hook Information</h1>
	<div class="row">
		<c:choose>
		<c:when test="${! empty needleOrHook }">
			<form action="updateNeedleOrHook.do">
				<br>
				<h4>Please Enter the requested information for the Needle, Hook, or Cable information you wish to update the database.</h4>
				<input type="hidden" id="id" name="id" value="${needleOrHook.id}">
				
				Current Material: ${needleOrHook.material} <br>
				<label for="material">Material</label><br>
				<select name="material">
				  	<option selected>${needleOrHook.material}</option>
				    <option value="bamboo">Bamboo</option>
				    <option value="composite">Composite</option>
				    <option value="graphite">Graphite</option>
				    <option value="metal">Metal</option>
				    <option value="plastic">Plastic</option>
				    <option value="rosewood">Rose Wood</option>
				</select>
				<br>
				<br>
				Current Type: ${needleOrHook.type} <br>
				<label for="type">Type</label><br>
				<select name="type">
					<option selected>${needleOrHook.type}</option>
				    <option value="straight">Straight</option>
				    <option value="circular">Circular</option>
				    <option value="interchangeable">Interchangeable</option>
				    <option value="double point">Double Pointed</option>
				    <option value="crochet hook">Crochet Hook</option>
				    <option value="cable">Cable</option>
				</select>
				<br>
				<br>
				Current Length: ${needleOrHook.length } <br>
				<label for="type">Length</label><br>
				<input type="text" id="length" name="length" value="0"/>
				<br>
				<br>
				Current US Size: ${needleOrHook.usSize} <br>
				<label for="type">US Size</label><br>
				<input type="text" id="usSize" name="usSize" value=""/>
				<br>
				<br>
				Current Metric Size: ${needleOrHook.metricSize}<br>
				<label for="type">Metric Size</label><br>
				<input type="text" id="metricSize" name="metricSize" value=""/>
				<br>
				<br>
				Current Quantity: ${needleOrHook.quantity}
				<label for="type">Quantity</label><br>
				<input type="number" id="quantity" name="quantity" value="0"/><br>
				<br>
				<input type="submit" value="Update the Needle, Hook or Cable information in the Database">
			</form>
			</c:when>
		<c:otherwise>
				<h6>No such Needle, Hook or Cable found to update!</h6>
		</c:otherwise>
	</c:choose>
	</div>
	</div>
</body>	

<head>

	
<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>