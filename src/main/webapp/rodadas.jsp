<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rodadas</title>
<link rel="stylesheet" href="Styles/rodadaStyles.css">
<style type="text/css">
body{
	display:flex;
	flex-direction:column;
	width:100%;
	min-height:100%;
}
.tituloPagina{
	position:static;
}
.menu{
	position:initial;
}

#modalExemplo:checked + .modal1{
	display:block;
}

.checkboxModal{
	display:none;
}

.modal1 {
	display:none;
	position:fixed;
	align-items:center;
	justify-content:center;
	width:100%;
	height:100%;
	background-color: rgba(0,0,0,0.5);
}

.modal1 .fecharModal{
	position: absolute;
	top: 20px;
	right:30px;
	color:white;
	font-size:40px;
}

.modal1 .fecharModal:hover{
	cursor: pointer;
	color:red;
}

.modal1 .conteudo{
	left:50%;
	top:50%;
	margin-left:-350px; 
	margin-top:-110px;
	position:relative;
	width: 50%;
	height:50%;
	background-color:white;
}
</style>
</head>
<body>
	<div class="tituloPagina">
		<h1 align="center">Visualiza Rodadas</h1>
	</div>

	<div class="menu"> 
		<jsp:include page="menu.jsp"></jsp:include>	
	</div>
		
    <p>Insira uma data e procure os jogos.</p>
	
	<div>
		<form action="jogo" method ="post"> 
			<input value="00-00-0000" id="text" type="text" name="DataJogo">
	    	<input type="submit" value="Pesquisar" id="buscar_jogos" name="button"/>	
		</form>
	</div>

    <div>
    
    	<c:if test="${not empty listaJogos }">
	        <table border = 1>
	        	<tr>
	                <th>Data</th>
	                <th>Codigo Jogo</th>
	            	<th>Primeiro time</th>
					<th>Gols do primeiro time</th>            	
	                <th>&nbsp;</th>
	                <th>Gols do segundo time</th>
	                <th>Segundo time</th>
	                <th>Resultado da Partida</th>
	                <th>Adicionar Resultado</th>
	            </tr>
	            
				<c:forEach items="${listaJogos }" var="jg">       
		        <tr>
		            <td>${jg.dataJogo}</td>
		            <td>${jg.codigoJogo}</td>
		            <td>${jg.tA}</td>
		          	<td>${jg.golsTimeA}</td>  
		          	<td> X </td>              
		            <td>${jg.golsTImeB}</td>
		            <td>${jg.tB}</td> 
		            <td>${jg.resultado}</td>
		            <td>
		            <form action="jogo" method ="post"> 
		            <input type="submit" value="Resultado" id="button" name="button">
		            </form>
		            <!--<label for="modalExemplo" class="AbrirModal">Abrir modal</label>-->
					</td>
		        </tr>
		       	</c:forEach> 
		       	
			</table>
		</c:if>
		
    </div>
	<br>

	
	<input type="checkbox" id="modalExemplo" class="checkboxModal">
	
	<div class="modal1">
		<label for="modalExemplo"
		class="fecharModal">X</label>
		<div class="conteudo" >
		<h4>Marque quem ganhou o Jogo</h4>
		<form action="jogo" method ="post">
			<select id=escolhas name = "escolhas">
				<option disabled>-- select an option --</option>
				<option value="vtimeA">Vitoria Time A</option>
				<option value="vtimeB">Vitoria Time B</option>
				<option value="empate">Empate</option>
			</select>
			
		</form>
		</div>
	</div>
</body>
</html>