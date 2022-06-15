<%--
  vscode
  Rafael Lapa Valgas
  Date: 06/11/2019
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
	<title>Calculadora</title>
	<style>
		body {
			width: 50%;
			margin: 0 auto;
			padding: 10px;
		}
		.text_field{
			width: 85%;
			margin: 10px auto;
			padding: 10px;
		}
		.button{
			width: 100%;
			height: 50px;
			margin: 5px auto;
		}
	</style>
</head>

<body>
	<div>
		<div>
			<form action="Calc" target="result">
				<fieldset>
					<legend>Calcular</legend>
					<label for="a">Number one:</label>
					<input class="text_field" type="text" name="num1" id="num1" />
					<br />
					<label for="b">Number two:</label>
					<input class="text_field" type="text" name="num2" id="num2" /> 
					<br /> <br>
					<input type="radio" value="Somar" name="operador" checked> Somar <br>
					<input type="radio" value="Subtrair" name="operador"> Subtrair <br>
					<input type="radio" value="Dividir" name="operador"> Dividir <br>
					<input type="radio" value="Multiplicar" name="operador"> Multiplicar <br> <br>
					<input class="button" type="submit" value="submit" />
				</fieldset>
			</form>
		</div>
		<div>
			<fieldset>
				<iframe name="result" src="result.jsp" height="150" frameborder="0"></iframe>
			</fieldset>
		</div>
	</div>

</body>
</html>