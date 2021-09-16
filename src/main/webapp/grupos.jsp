<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Grupos</title>
</head>
<body bgcolor="BLACK">
	<div>
		<div style="background-color:WHITE; padding-left:30px;padding-right:30px">
			<h1 align="center">Gerar Grupos</h1>
			<br/>
				<jsp:include page="menu.jsp"></jsp:include>			
			<br/>	
		</div>
	</div>
	<div style="background-color:GREY; padding: 30px">
		<form action="Grupo" method="post">
		<input type="submit" value="Gerar Grupos" id="button" name="button" onclick="cadastro()" style="display: block; margin:auto; ">
		<script >function cadastro(){alert('Me apertaram aqui em!')}</script>
		</form>
	</div>	
</body>
</html>