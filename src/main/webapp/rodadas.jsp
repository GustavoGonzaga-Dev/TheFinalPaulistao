<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rodadas</title>
<link rel="stylesheet" href="Styles/rodadaStyles.css">
</head>
<body>
	<h1 align="center">Visualiza Rodadas</h1>
		<jsp:include page="menu.jsp"></jsp:include>	
    <p>Insira uma data e procure os jogos.</p>
	
	<div>
		<form action="jogo" method ="post">
			<input id="date" type="text">
	    	<input type="submit" value="Pesquisar" id="buscar_jogos" name="button"/>	
		</form>
	</div>
	
    <div>
        <table border = 1>
        	<tr>
            	<th>Primeiro time</th>
				<th>Gols do primeiro time</th>            	
                <th>&nbsp;</th>
                <th>Segundo time</th>
                <th>Gols do segundo time</th>
                <th>Data</th>
            </tr>
		<c:forEach var="jogo" items="${listaJogos }">       
            <tr>
                <td>${jogo.tA.NomeTime }</td>
            	<td>${jogo.GolsTimeA}</td>  
            	<td> X </td>              
                <td>${jogo.tB.NomeTime }</td> 
                <td>${jogo.GolsTimeB}</td>
                <td>${jogo.DataJogo}</td>
            </tr>
       	</c:forEach> 
		</table>
    </div>

</body>
</html>