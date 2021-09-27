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
		<form action="Gerar" method="post">
			<input type="submit" value="Gerar Grupos" id="button" name="button" onclick="cadastro()" >
			<script >function cadastroG(){alert('Os grupos foram gerados!')}</script>
			<a href="grupos.jsp"></a>
		</form>
	</div>	
		<br>
	<div class="jogos" >
		<form action="Gerar" method="post">
			<input type="submit" value="Gerar Jogos" id="button" name="button" onclick="cadastro()" >
			<script >function cadastroJ(){alert('Os Jogos foram gerados!')}</script>
		</form>
	</div>		

		
		
</body>
</html>