<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

	<style>
		.page {
			max-width: 1024px;
			margin: 1em auto;
		}

		.header {
			padding: 0.5em;
			display: flex;
			justify-content: space-between;
		}

		.main {
			margin: auto;
		}

		.changeWeek {
			width: 1005;
			display: flex;
		}

		.nextWeek {
			margin: 0.05em auto;
		}

		.container {
			margin: 0.15em;
		}

		.accordion {
			margin-bottom: 0.75em;
			;
		}
	</style>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>

	<header class="page">
		<section class="header">
			<div class="data">
				<!-- data.get -->
				<h2>12/12/2019</h2>
			</div>
			<div class="cadastro">
				<form action="">
					<!-- Call an Servlet -->
					<input class="btn btn-primary btn-lg" type="button" value="Cadastrar Hospede">
				</form>
			</div>
		</section>
	</header>


	<main class="page">
		<section class="main">


			<!-- CLICK :: OPEN -->
			<!-- IFs -->
			<!-- Tabela com 6 linhas (quartos) -->
			<!-- |QUARTO| |NOME| |PRECO| |CANCELAR| -->
			<!-- |QUARTO| |____| |_____| |RESERVAR| -->
			<!-- CLICK :: CLOSE -->

			<!-- LOOP List<Reserva> reservas-->
			<!-- SHOW AN FULL WEEK -->
			<!-- SEMANA -->


			<div class="accordion" id="accordionExample">

				<!-- DIA 1-->
				<div class="card">
					<div class="card-header" id="headingOne" data-toggle="collapse" data-target="#collapseOne"
						aria-controls="collapseOne" role="button" aria-expanded="false">
						<h2 class="mb-0">
							12/12/2019
						</h2>
					</div>


					<!-- COMPONENTE HIDDEN -->
					<div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
						data-parent="#accordionExample">

						<!-- container -->
						<div class="card-body">
							<div class="container">
								<ul class="list-group list-group-horizontal">
									<li class="list-group-item flex-fill">
										01
									</li>
									<li class="list-group-item flex-fill">
										NOME
									</li>
									<li class="list-group-item flex-fill">
										PRECO
									</li>
									<li class="list-group-item flex-fill">
										<form action="">
											<input class="btn btn-danger btn-block" type="button" value="CANCELAR">
										</form>
									</li>
								</ul>
							</div>
							<!-- container -->
							<div class="container">
								<ul class="list-group list-group-horizontal">
									<li class="list-group-item flex-fill">
										02
									</li>
									<li class="list-group-item flex-fill">
										NOME
									</li>
									<li class="list-group-item flex-fill">
										PRECO
									</li>
									<li class="list-group-item flex-fill">
										<form action="">
											<input class="btn btn-danger btn-block" type="button" value="CANCELAR">
										</form>
									</li>
								</ul>
							</div>
							<!-- container -->
						</div>

					</div>
					<!-- COMPONENTE HIDDEN -->
				</div>
			</div>


			<!-- TESTE -->
			<!-- TESTE -->
			<!-- TESTE -->
			<!-- TESTE -->


			<div class="accordion" id="accordionExample">

				<!-- DIA 1-->
				<div class="card">
					<div class="card-header" id="headingOn" data-toggle="collapse" data-target="#collapseOn"
						aria-controls="collapseOn">
						<h2 class="mb-0">
							12/12/2019
						</h2>
					</div>


					<!-- COMPONENTE HIDDEN -->
					<div id="collapseOn" class="collapse show" aria-labelledby="headingOn"
						data-parent="#accordionExample" role="button" aria-expanded="false">

						<!-- container -->
						<div class="card-body">
							<div class="container">
								<ul class="list-group list-group-horizontal">
									<li class="list-group-item flex-fill">
										01
									</li>
									<li class="list-group-item flex-fill">
										NOME
									</li>
									<li class="list-group-item flex-fill">
										PRECO
									</li>
									<li class="list-group-item flex-fill">
										<form action="">
											<input class="btn btn-danger btn-block" type="button" value="CANCELAR">
										</form>
									</li>
								</ul>
							</div>
							<!-- container -->
							<div class="container">
								<ul class="list-group list-group-horizontal">
									<li class="list-group-item flex-fill">
										02
									</li>
									<li class="list-group-item flex-fill">
										NOME
									</li>
									<li class="list-group-item flex-fill">
										PRECO
									</li>
									<li class="list-group-item flex-fill">
										<form action="">
											<input class="btn btn-danger btn-block" type="button" value="CANCELAR">
										</form>
									</li>
								</ul>
							</div>
							<!-- container -->
						</div>

					</div>
					<!-- COMPONENTE HIDDEN -->
				</div>


			</div>


			<!-- TESTE -->
			<!-- TESTE -->
			<!-- TESTE -->
			<!-- TESTE -->






		</section>

		<footer>
			<div class="changeWeek">
				<div class="nextWeek">
					<form action="">
						<!-- Call an Servlet -->
						<input class="btn btn-primary btn-sm btn-block" type="button" value="Semana anterior" disabled>
					</form>
				</div>
				<div class="nextWeek">
					<form action="">
						<!-- Call an Servlet -->
						<input class="btn btn-primary btn-sm btn-block" type="button" value="Próxima semana" disabled>
					</form>
				</div>
			</div>
		</footer>

	</main>







	<div class="accordion" id="accordionExample">
			<div class="card">
			  <div class="card-header" id="headingOne">
				<h2 class="mb-0">
				  <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					Collapsible Group Item #1
				  </button>
				</h2>
			  </div>
		  
			  <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">
				  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				</div>
			  </div>
			</div>
			<div class="card">
			  <div class="card-header" id="headingTwo">
				<h2 class="mb-0">
				  <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					Collapsible Group Item #2
				  </button>
				</h2>
			  </div>
			  <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
				<div class="card-body">
				  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				</div>
			  </div>
			</div>
			<div class="card">
			  <div class="card-header" id="headingThree">
				<h2 class="mb-0">
				  <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
					Collapsible Group Item #3
				  </button>
				</h2>
			  </div>
			  <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
				<div class="card-body">
				  Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				</div>
			  </div>
			</div>
		  </div>


</body>

</html>