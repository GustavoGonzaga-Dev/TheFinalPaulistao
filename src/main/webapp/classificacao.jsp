<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classificação Geral</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

.tabela {
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -100px;
	margin-left: -350px;
}
</style>
</head>
<body>
	<div>
		<h1 align="center">Tabela de Classificação Geral</h1>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>

	<form action="ClassGeral" method="post">
		<div class="botao">
			<input type="submit" id="button" value="Atualizar Tabela">
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
	</form>
</body>
</html>