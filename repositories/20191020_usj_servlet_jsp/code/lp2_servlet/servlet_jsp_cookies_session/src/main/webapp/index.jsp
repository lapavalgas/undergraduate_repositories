<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>

<body>
	<h1>Hello World!</h1>
	<c:if test="${not empty param.name}">
		<p>Name: ${param.name}</p>
	</c:if>

	<h1>This webpage...</h1>


	<div style="background-color:antiquewhite; margin: 3px; padding: 5px;">
		<p style="margin: 3px; padding: 5px;">
			<h2>1</h2>
			<p>Form method GET | to speed </p>

			<form action="Add" method="get">
				Enter 1st number : <input style="margin: 3px; padding: 5px;" type="text" name="t1"><br>
				Enter 1st number : <input style="margin: 3px; padding: 5px;" type="text" name="t2"><br>
				<input type="submit" value="Add">
			</form>
		</p>
	</div>


	<div style="background-color:aqua; margin: 3px; padding: 5px;">
		<p style="margin: 3px; padding: 5px;">
			<h2>2</h2>
			<p>Form method POST | to security</p>

			<form action="Add" method="post">
				Enter 1st number : <input style="margin: 3px; padding: 5px;" type="text" name="t1"><br>
				Enter 1st number : <input style="margin: 3px; padding: 5px;" type="text" name="t2"><br>
				<input type="submit" value="Add">
			</form>
		</p>
	</div>


	<div style="background-color:azure; margin: 3px; padding: 5px;">
		<p style="margin: 3px; padding: 5px;">
			<h2>3</h2>
			<p>Form action AN_SERVLET_HERE : no methods| to navigate</p>

			<form action="FirstServlet">
				<input type="submit" value="Ok"> 
			</form> <br>
		</p>
	</div>


	<div style="background-color:aliceblue; margin: 3px; padding: 5px;">
		<h2>4</h2>
		<p style="margin: 3px; padding: 5px;">
			<p>An request to persist Data. </p>

			<form action="ThirdServlet">
				Enter ur name : <input style="margin: 3px; padding: 5px;" type="text" name="n1"><br>
				<input type="submit" value="Ok">
			</form>
		</p>
	</div>


		<div style="background-color:slategrey; margin: 3px; padding: 5px;">
		<p style="margin: 3px; padding: 5px;">
			<h2>5</h2>
			<p>This send a cookie, after can test if the cookie match with name_request (number 3) </p>

			<form action="FourCookie">
				Enter ur name : <input style="margin: 3px; padding: 5px;" type="text" name="n1"><br>
				<input type="submit" value="Ok">
			</form>
		</p>
	</div>

</body>

</html>