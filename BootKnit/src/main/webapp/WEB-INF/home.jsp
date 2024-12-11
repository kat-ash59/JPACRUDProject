<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Kat's Knitting Stuff</title>
<%@  include file="bootstraphead.jsp" %>
<style >
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.8), rgba(255, 255, 255, 0.8)),
                  url("images/knit.png");
}
</style>
</head>
<body>
<h1 style="text-align: center">Kat's Knitting Stuff Application</h1>
<br>
<div class="container">
	<div class="row">
		This application provides a means to store all of my knitting needles, crochet hooks and cables
		in a database.  It provides the ability to add new knitting needles, crochet hooks and cables, as well
		as the ability to update and delete individual needles. 
		<br>
		<br>
		<br>
		
		<strong>Get a list of all the knitting needles, crochet hooks and cables</strong>
		<br>
		<br>
		<form action="getAllNeedlesAndHooks.do" method="GET">
	  		<input type="submit" value="Show a list of all Needles And Hooks and Cables" />
		</form>
		<br>
		<br>
		<br>
		<strong>Find the knitting needle, crochet hook or cable by it's id</strong>
		<br>
		<br>
			<form action="getNeedleOrHookById.do" method="GET">
	 		 Needle ID: <input type="number" name="needleOrHook" />
	  		<input type="submit" value="Show Needle, Hook or Cable" />
		</form>
		<br>
		<br>
		<br>
		<br>
		<div class="row">
		<strong>Find a list of needles, hooks or cable containing the keyword in the type:<br>
		If nothing is entered or found it will return an error</strong><br>
		<form action="findItemsByKeyword.do" >
			<br>
			<label for="keyword">Enter Keyword Here: </label><br>
			<input type="text" id="keyword" name="keyword" value="">
			<input type="submit" value="Find all items that have the keyword in the type">
			<br>
			<br>
			<br>
		</form>
		</div>
		
		<strong>Add a knitting needle, crochet hook or cable to the database</strong>
		<br>
		You will be asked to enter the material (optional), type (must have), length (must have), US Size (optional),
		Metric Size (optional), and quantity (optional) for the kntting needle, crochet hook or cable
		 you wish to add.
		<br>
		<form action="createNeedleHookOrCable.do" >
			<br>
				<label for="material">Material</label><br>
				<select name="material">
				    <option value="bamboo">Bamboo</option>
				    <option value="composite">Composite</option>
				    <option value="graphite">Graphite</option>
				    <option value="metal">Metal</option>
				    <option value="plastic">Plastic</option>
				    <option value="rosewood">Rose Wood</option>
				</select>
				<br>
				<label for="type">Type</label><br>
				<select name="type">
				    <option value="straight">Straight</option>
				    <option value="circular">Circular</option>
				    <option value="interchangeable">Interchangeable</option>
				    <option value="double point">Double Pointed</option>
				    <option value="crochet hook">Crochet Hook</option>
				    <option value="cable">Cable</option>
				 </select>
				<br>
				<label for="type">Length</label><br>
				<input type="text" id="length" name="length" value="0"/>
				<br>
				<label for="type">US Size</label><br>
				<input type="text" id="usSize" name="usSize" value=""/>
				<br>
				<label for="type">Metric Size</label><br>
				<input type="text" id="metricSize" name="metricSize" value=""/>
				<br>
				<label for="type">Quantity</label><br>
				<input type="number" id="quantity" name="quantity" value="0"/>
				<br>
				<br>
				<input type="submit" value="Add the Needle, Hook or Cable information into the Database">
			<br>
			<br>
			<br>
		</form>

	</div>
</div>	
<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>