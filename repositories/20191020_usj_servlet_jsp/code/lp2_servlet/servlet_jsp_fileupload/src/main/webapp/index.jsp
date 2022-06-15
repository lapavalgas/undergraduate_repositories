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


	<div style="background-color:beige">
		<p>
			one file
		</p>
		<form action="FileUpload" method="post" enctype="multipart/form-data">
			<input type="file" name="file">
			<input type="submit">
		</form>
	</div>

	<div style="background-color:burlywood">
		<p>
			multiple files
		</p>
		<form action="FileUpload" method="post" enctype="multipart/form-data">
			<input type="file" name="file"  multiple >
			<input type="submit" value="Press">
		</form>

	</div>


		<div style="background-color:blue">
		<p>
			Go My First JSP page
		</p>
		<form action="MyFirstJSP">
			<input type="submit" value="Press">
		</form>

	</div>


</body>

</html>