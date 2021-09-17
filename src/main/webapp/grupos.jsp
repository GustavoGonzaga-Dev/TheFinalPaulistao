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
		<h1 >Gerar Grupos</h1>

		<jsp:include page="menu.jsp"></jsp:include>			

	
	<div class="grupo" >
		<form action="Grupo" method="post">
			<input type="submit" value="Gerar Grupos" id="button" name="button" onclick="cadastro()" >
			<script >function cadastro(){alert('Me apertaram aqui em!')}</script>
		</form>
	</div>	
	
	<div class= "Container">
		<div><h2>TABELA DE GRUPOS</h2></div>
		<div class="Tabela" >
			<table >
				<tr>
					<td class="GRUPO">GRUPO A</td>
					<td>São Paulo</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
				</tr>
			</table>
		</div>
		<div class="Tabela">
			<table >
				<tr>
					<td class="GRUPO">GRUPO B</td>
					<td>Corinthians</td>
					<td>6</td>
					<td>7</td>
					<td>8</td>
				</tr>
			</table>
		</div>
		<div class="Tabela">
			<table >
				<tr>
					<td class="GRUPO">GRUPO C</td>
					<td>Santos</td>
					<td>10</td>
					<td>11</td>
					<td>12</td>
				</tr>
			</table>
		</div>
		<div class="Tabela">
			<table >
				<tr>
					<td class="GRUPO">GRUPO D</td>
					<td>Palmeiras</td>
					<td>14</td>
					<td>15</td>
					<td>16</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>