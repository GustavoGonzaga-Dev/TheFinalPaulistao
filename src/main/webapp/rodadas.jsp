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
    <p>Selecione uma data e procure os jogos que ocorrerão no respectivo período.</p>
	
	<div>
		<input id="date" type="date">
    	<input type="submit" value="Buscar jogos" id="buscar_jogos" name="button"/>	
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
            <tr>
                <td>Time A</td>
            	<td>Gols Time A</td>  
            	<td> X </td>              
                <td>Time B</td> 
                <td>Gols Time B</td>
                <td>Data do Jogo</td>
            </tr>
		</table>
    </div>

</body>
</html>