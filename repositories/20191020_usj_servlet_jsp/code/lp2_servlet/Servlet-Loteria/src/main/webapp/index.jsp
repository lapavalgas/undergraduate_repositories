<%--
  vscode
  Rafael Lapa Valgas
  Date: 06/11/2019
--%>


<%@ page import="java.util.Random" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
	<title> LOTERIA </title>
	<style>
		body {
			width: 50%;
			margin: 10px auto;
		}
	</style>

</head>

<body>
	<section>
		<%! 
			public boolean check(int number, int[] mega) {
				boolean pass = true;
				if (number == -1){
					pass = false;
				} else {
					for (int i=0; i<6; i++){
						if (mega[i] == number){
							pass = false;
						}
					}
				}
				return pass;
			}
		 %>
		<%! 
			public int newNumber(int[] mega) {
				int number = -1;
				Random random = new Random();
				while (check(number, mega) == false){
					number = random.nextInt(60);
				}
				return number;
			}
		  %>
		<div style="margin: auto;">
			<h1>
				<%
					int[] mega = new int[6];

					for (int i=0; i<6; i++){
						mega[i] = newNumber(mega);
					}
					for (int i=0; i<6; i++){
						out.println(mega[i]); 
					}
				%>
			</h1>
		</div>

	</section>

</body>

</html>