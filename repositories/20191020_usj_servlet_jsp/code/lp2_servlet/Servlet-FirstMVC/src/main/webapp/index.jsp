<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Tarefas</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>

<body>

	<!-- user session? -->
	<c:if test="${user != null}">
		<c:redirect url="UI.jsp" />
	</c:if>
	<!-- user session? -->

	<section class="authJSP">
		<div class="authentication">
			<h1>Login:</h1>
			<form action="Login" method="post">
				<div><input name="uname" class="inputText" onfocus="this.value=''" type="text" value="L O G I N"></div>
				<div><input name="pass" class="inputText" onfocus="this.value=''; this.type='password' " type="text"
						value="P A S S W O R D"></div>
				<div><input name="Submit" class="inputBtn" value="login" type="Submit"></div>
			</form>
		</div>
		<div class="newUSer">
			<form action="">
				<input class="inputBtn" type="button" value="New User" name="New User">
			</form>
		</div>
	</section>
</body>

</html>