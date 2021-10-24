<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Grupos</title>
<link rel="stylesheet" href="Styles/grupoStyles.css">
<style type="text/css">
.container{
	display:flex;
	
}

.grupo{
	padding-left:100px;
	background-color:white;
	flex:1;
}

.btnPesquisar{
	padding:20px;
}

</style>
</head>
<body>
	<div>
		<h1 >Grupos</h1>

		<jsp:include page="menu.jsp"></jsp:include>			
	</div>
	
	<div class="btnPesquisar">
		<form action="CarregaGrupoServlet" method ="post"> 
	    	<input type="submit" value="Pesquisar" id="buscar_jogos" name="button"/>	
		</form>
	</div>
	
	<div align="center">
		<h2>TABELA DE GRUPOS</h2>
	</div>
	
	<div class= "container">

		<div class="grupo">
			<c:if test="${not empty gpA }">
				<table border = 1>
					<tr >
						<th>Grupo A</th>
					</tr>
				<c:forEach items="${gpA}" var="t1">
					<tr>	
						<td>${t1}</td>
					</tr>
				</c:forEach>	
				</table>
			</c:if>
		</div>
		
		
		
		<div class="grupo">
			<c:if test="${not empty gpB }">
				<table border = 1>
					<tr >
						<th>Grupo B</th>
					</tr>
				<c:forEach items="${gpB}" var="t2">
					<tr>	
						<td>${t2}</td>
					</tr>
				</c:forEach>	
				</table>
			</c:if>
		</div>

		

		<div class="grupo">
			<c:if test="${not empty gpC }">
				<table border = 1>
					<tr >
						<th>Grupo C</th>
					</tr>
				<c:forEach items="${gpC}" var="t3">
					<tr>	
						<td>${t3}</td>
					</tr>
				</c:forEach>	
				</table>
			</c:if>
		</div>
		
		
	
		<div class="grupo">
			<c:if test="${not empty gpD }">
				<table border = 1>
					<tr >
						<th>Grupo D</th>
					</tr>
				<c:forEach items="${gpD}" var="t4">
					<tr>	
						<td>${t4}</td>
					</tr>
				</c:forEach>	
				</table>
			</c:if>
		</div>
		
    </div>

</body>
</html>