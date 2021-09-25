<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Grupos</title>
<link rel="stylesheet" href="Styles/grupoStyles.css">

</head>
<body>
	<div>
		<h1 >Grupos</h1>

		<jsp:include page="menu.jsp"></jsp:include>			
	</div>
	

	
	<div class= "Container">
		<div>
			<h2>TABELA DE GRUPOS</h2>
		</div>

		<div>
			<table border = 1>
				<tr >
					<th colspan="4">Grupo A</th>
				</tr>
				<tr>	
					<td>Corinthians</td>
					<td>Botafogo-SP</td>
					<td>Bragantino</td>
					<td>Ferroviária</td>
				</tr>
			</table>
		</div>
		
		<br>
		
		<div>
			<table border = 1>
				<tr>
					<th colspan="4">Grupo B</th>
				</tr>
				<tr>	
					<td>Santos</td>
					<td>Guarani</td>
					<td>Ituano</td>
					<td>Mirassol</td>
				</tr>
			</table>
		</div>

		<br>

		<div>
			<table border = 1>
				<tr>
					<th colspan="4">Grupo C</th>
				</tr>	
				<tr>
					<td>Palmeiras</td>
					<td>Novorizontino</td>
					<td>Oeste</td>
					<td>Ponte Preta</td>
				</tr>
			</table>
		</div>
	
		<br>
	
		<div>
			<table border = 1>
				<tr>
					<th colspan="4">Grupo D</th>
				</tr>
				<tr>	
					<td>São Paulo</td>
					<td>Red Bull Brasil</td>
					<td>São Bento</td>
					<td>São Caetano</td>
				</tr>
			</table>
		</div>
		
    </div>

</body>
</html>