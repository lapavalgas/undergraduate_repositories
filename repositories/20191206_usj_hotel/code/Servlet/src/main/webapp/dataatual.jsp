<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>HOTEL DAHORA</title>
	<script src="scripts.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<style>
		.page {
			max-width: 1024px;
			margin: 0.5em auto;
		}

		.header {
			padding: 0.5em;
			margin-bottom: 1.5em;
		}

		.controller {
			display: flex;
			justify-content: space-between;
		}

		.main {
			margin: auto;
		}

		.list-group {
			margin-bottom: 1em;

		}

		.list-group h4 {
			padding-top: 10px;

		}

		.list-group-horizontal {
			border-left: none;
			border-top: none;
			border-right: none;
		}

		.list-group-item {
			border-left: none;
			border-top: none;
			border-right: none;
		}
	</style>

</head>
<!-------------------------------------------------------------------------------------------------------------------------->

<body>
	<header class="page">

		<section class="header" style="border-bottom: 1px dashed black;">
			<div class="logo">
				<h1>HOTEL DAHORA</h1>
			</div>

			<div class="controller">
				<div class="data">
					<div style="display: flex;">
						<form action="SistemaDataAtual" method="post" style="display: flex;">
							<input id="day" type="date" name="data" placeholder="date" value="${data}"
								class="form-control" style="min-width: 250px">
							<button type="submit" class="btn btn-primary">OK</button>
						</form>
						<form action="SistemaDataAtual" method="post">
							<button type="submit" class="btn btn-info">Data atual</button>
							<input type="hidden" name="data" value="dataAtual">
						</form>
					</div>
				</div>

				<div class="cadastro" style="padding-right: 10px;">
					<form action="SistemaCadastroController" method="post">
						<input name="cadastrar" type="Submit" value="Cadastros" class="btn btn-primary btn-lg"
							style="width: 208px;">
					</form>
				</div>

			</div>

		</section>

	</header>

	<!-------------------------------------------------------------------------------------------------------------------------->

	<main class="page">

		<section class="main">

			<div class="rooms">

				<c:forEach var="i" begin="1" end="5">

					<!-- EXISTE REGISTRO -->
					<c:if test="${not empty list[i]}">
						<form action="ReservaController" method="post">
							<input type="hidden" name="data" value="${data}">
							<ul class="list-group list-group-horizontal">
								<li class="list-group-item flex-fill ">
									<input type="hidden" name="quarto" value="0${i}">
									<h4 style="text-align: right;">ROOM: ${list[i].quarto}</h4>
								</li>
								<li class="list-group-item flex-fill " style="width: 313px;">
									<input type="text" class="form-control" value="${list[i].hospede.nome}"
										style="margin-bottom: 5px;" disabled>
									<input type="text" class="form-control" id="hospedeCpf" placeholder=""
										value="${list[i].hospede_cpf}" autocomplete="off" name="customer['cpf']"
										oninput="mascara(this, 'cpf')" disabled>
								</li>
								<li class="list-group-item flex-fill" style="width: 157px;">
									<input type="text" name="preco" class="form-control" placeholder="" value="${list[i].preco}"
										disabled>
								</li>
								<li class="list-group-item" style="border: none;">
									<button type="submit" name="update" value="cancelar" class="btn btn-primary"
										style="width: 208px;">Cancelar</button>
								</li>

							</ul>
						</form>
					</c:if>

					<!-- NÂO EXISTE REGISTRO -->
					<c:if test="${empty list[i]}">
						<form action="ReservaController" method="post">
							<input type="hidden" name="data" value="${data}">
							<ul class="list-group list-group-horizontal">
								<li class="list-group-item flex-fill ">
									<input type="hidden" name="quarto" value="0${i}">
									<h4 style="text-align: right;">ROOM: 0${i}</h4>
								</li>
								<li class="list-group-item flex-fill " style="width: 313px;">
									<input type="text" class="form-control" placeholder="Nome do hospede" value=""
										style="margin-bottom: 5px;" disabled>
									<input type="text" class="form-control" id="hospedeCpf"
										placeholder="Ex.:   xxx.xxx.xxx-xx" autocomplete="off" name="customer['cpf']"
										oninput="mascara(this, 'cpf')">
								</li>
								<li class="list-group-item flex-fill" style="width: 157px;">
									<input type="text" name="preco" class="form-control" placeholder="Ex.:   R$ 127,48" value="">
								</li>
								<li class="list-group-item" style="border: none;">
									<button type="submit" name="update" value="reservar" class="btn btn-success btn-lg"
										style="width: 208px;">Reservar</button>
								</li>
							</ul>
						</form>
					</c:if>
				</c:forEach>

			</div>

		</section>

</body>

</html>