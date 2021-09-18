<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1 >Gerar</h1>

		<jsp:include page="menu.jsp"></jsp:include>			
	</div>
			<br>
	<div class="grupo" >
		<form action="Grupo" method="post">
			<input type="submit" value="Gerar Grupos" id="button" name="button" onclick="cadastro()" >
			<script >function cadastro(){alert('Os grupos foram gerados!')}</script>
		</form>
	</div>	
		<br>
	<div class="jogos" >
		<form action="Jogos" method="post">
			<input type="submit" value="Gerar Jogos" id="button" name="button" onclick="cadastro()" >
			<script >function cadastro(){alert('Os Jogos foram gerados!')}</script>
		</form>
	</div>		
		<br>	
	<div class="rodada" >
		<form action="Rodada" method="post">
			<input type="submit" value="Gerar Rodadas" id="button" name="button" onclick="cadastro()" >
			<script >function cadastro(){alert('As rodadas foram geradas!')}</script>
		</form>
	</div>	
		
		
</body>
</html>