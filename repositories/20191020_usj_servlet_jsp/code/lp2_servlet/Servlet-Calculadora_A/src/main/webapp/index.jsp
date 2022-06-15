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
		form {
			width: 40%;
			margin: 5px auto;
			padding: 10px;
		}
		fieldset {
			width: 80%;
			margin: 10px auto;
			padding: 10px;
		}
		input {
			width: 100%;
			margin: 5px auto;
			padding: 5px;
		}
	</style>
</head>

<body>
	<div style="display: inline;">
		<div style="float: left;">
			<form action="Soma">
				<fieldset>
					<legend>Somar</legend>
					<label for="a">valor a:</label>
					<input type="text" name="a" id="a" />
					<br />
					<label for="b">valor b:</label>
					<input type="text" name="b" id="b" />
					<br />
					<input type="submit" valor="Somar" />
					<br />
				</fieldset>
			</form>
		</div>
		<div style="float: left;">
			<form action="Subtracao">
				<fieldset>
					<legend>Subtrair</legend>
					<label for="subtracao_a">valor a:</label>
					<input type="text" name="a" id="subtracao_a" />
					<br />
					<label for="subtracao_b">valor b:</label>
					<input type="text" name="b" id="subtracao_b" />
					<br />
					<input type="submit" valor="Subtrair" />
					<br />
				</fieldset>
			</form>
		</div>

	</div>
	<div style="display: inline;">
		<div style="float: left;">
			<form action="Multiplicacao">
				<fieldset>
					<legend>Multiplicar</legend>
					<label for="multiplicar_a">valor a:</label>
					<input type="text" name="a" id="multiplicar_a" />
					<br />
					<label for="multiplicar_b">valor b:</label>
					<input type="text" name="b" id="multiplicar_b" />
					<br />
					<input type="submit" valor="Multiplicar" />
					<br />
				</fieldset>
			</form>
		</div>
		<div style="float: left;">
			<form action="Divisao">
				<fieldset>
					<legend>Divisao</legend>
					<label for="divisao_a">valor a:</label>
					<input type="text" name="a" id="divisao_a" />
					<br />
					<label for="divisao_b">valor b:</label>
					<input type="text" name="b" id="divisao_b" />
					<br />
					<input type="submit" valor="Dividir" />
					<br />
				</fieldset>
			</form>
		</div>
	</div>
</body>

</html>