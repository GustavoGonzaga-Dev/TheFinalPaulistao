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
			<input value="00-00-0000" id="text" type="text" name="DataJogo">
	    	<input type="submit" value="Pesquisar" id="buscar_jogos" name="button"/>	
		</form>
	</div>
	
    <div>
    	<c:if test="${not empty listaJogos}">
	        <table border = 1>
	        	<tr>
	            	<th>Primeiro time</th>
					<th>Gols do primeiro time</th>            	
	                <th>&nbsp;</th>
	                <th>Segundo time</th>
	                <th>Gols do segundo time</th>
	                <th>Data</th>
	            </tr>
				<c:forEach var="jg" items="${listaJogos}">       
		            <tr>
		                <td>${jg.tA}</td>
		            	<td>${jg.GolsTimeA}</td>  
		            	<td> X </td>              
		                <td>${jg.tB.NomeTime}</td> 
		                <td>${jg.GolsTImeB}</td>
		                <td>${jg.DataJogo}</td>
		            </tr>
		       	</c:forEach> 
			</table>
		</c:if>
    </div>

</body>
</html>