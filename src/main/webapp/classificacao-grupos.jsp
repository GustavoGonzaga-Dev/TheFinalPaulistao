<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabelas de Classificação por Grupos</title>
</head>
<body>
	<div>
		<h1 align="center">Tabela de Classificação Geral</h1>
		<jsp:include page="menu.jsp"></jsp:include>			
	</div>

	<div class="tabela">
		<table border="1">
			<tr>
				<th>Time</th>
				<th>Quantidade de Jogos</th>		
				<th>Vitorias</th>	
				<th>Empates</th>
				<th>Derrotas</th>
				<th>Gols Marcados</th>		
				<th>Gols Sofridos</th>	
				<th>Saldo Gols</th>
				<th>Pontos</th>
			</tr>
			<tr>	
				<td></td>
				<td></td>	
				<td></td>			
				<td></td>
				<td></td>	
				<td></td>	
				<td></td>
				<td></td>	
				<td></td>			
			</tr>
		</table>
	</div>	
</body>
</html>