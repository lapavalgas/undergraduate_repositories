<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="Model.* "%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="Model.User" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Lista de Tarefas</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>

<body>
	<!-- user session? -->
	<c:if test="${user == null}">
		<c:redirect url="index.jsp" />
	</c:if>
	<!-- user session? -->

	<section class="UI">
		<section class="user">
			<div class="userAttributes">
				<div class="logout">
					<form action="Logout" method="post">
						<input type="submit" value="logout">
					</form>
				</div>
				<div class="user__name">
					<span style="margin-left: 1em;">
						${user.name}
					</span>
				</div>
			</div>

			<div class="user__schedules">
				<c:forEach var="schedule" items="${schedules}">
					<c:if test="${schedule.name != null}">
						<form action="Schedule" method="GET">
							<a href="Schedule?schedule=${schedule.name}">
								<input style="margin-left: 0.5em;" class="schedule__card" type="text"
									value="${schedule.name}" disabled>
							</a>
						</form>
					</c:if>
				</c:forEach>
				</style="margin-left:>
				<c:forEach var="noSchedule" begin="${fn:length(schedules)}" end="5" step="1">
					<form method="GET">
						<div>
							<span>
								<input style="margin-left: 0.5em; border: 1px dashed;" class="schedule__card"
									type="text" value="Nova agenda" name="newSchedule" onfocus="this.value=''">
							</span>
						</div>
						<input type="submit" formaction="ScheduleAdd" value="Criar">
					</form>
				</c:forEach>

			</div>
		</section>

		<section class="theSchedule">
			<div class="schedule">
				<div class="schedule__config" style="display: flex; justify-content: space-between;">
					<div class="title">
						<form method="GET">
							<input style="margin-left: 0.5em; border: 1px dashed;" class="schedule__title" type="text"
								value="${pointerSchedule.name}" name="newScheduleName">
					</div>
					<div class="icons">
						<button type="submit" formaction="ScheduleEdit"><img class="iconsImg" src="img/edit.png"
								alt="Editar tarefa" style="width: 16px; height: 16px;"></button>

						<button type="submit" formaction="ScheduleDelet"><img class="iconsImg" src="img/trash.png"
								alt="Deletar tarefa" style="width: 16px; height: 16px;"></button>
						</form>
					</div>
				</div>

				<c:forEach var="task" items="${tasks}">
					<c:if test="${task.name != null}">
						<div class="task__card">
							<div class="title">
								<form method="GET">
									<input style="margin-left: 0.5em; border: 1px dashed;" class="schedule__title"
										type="text" value="${task.name}" name="newTaskName">
							</div>
							<div class="icons">
								<button type="submit" formaction="TaskEdit"><img class="iconsImg" src="img/edit.png"
										alt="Editar tarefa" style="width: 16px; height: 16px;"></button>

								<button type="submit" formaction="TaskDelet"><img class="iconsImg"
										src="img/trash.png" alt="Deletar tarefa"
										style="width: 16px; height: 16px;"></button>
								</form>
							</div>



							<!-- <a href="">
								<div class="title">
									<h4>${task.name}</h4>
								</div>
								<div class="icons">
									<a href=""><img class="iconsImg" src="img/edit.png" alt="Editar tarefa"
											style="width: 16px; height: 16px;"> </a>
									<a href=""><img class="iconsImg" src="img/trash.png" alt="Deletar tarefa "
											style="width: 16px; height: 16px;"> </a>
								</div>
							</a> -->
						</div>
					</c:if>
				</c:forEach>

			</div>
		</section>

		<section class="task">
			<div class="title">
				<h2>TASK_TITLE</h2>
			</div>
			<div class="task__description">
				<p>task__description</p>



				A <br>
				${schedules} <br>
				B <br>
				${user.schedules} <br>
				C <br>
				${tasks} <br>
				D<br>
				${pointerSchedule} <br>


			</div>
		</section>
	</section>

</body>

</html>