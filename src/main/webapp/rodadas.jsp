<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rodadas</title>
<link rel="stylesheet" href="Styles/rodadaStyles.css">
<style>
	body {font-family: Arial, Helvetica, sans-serif;}
	
	/* The Modal (background) */
	.modal {
	  display: none; /* Hidden by default */
	  position: fixed; /* Stay in place */
	  z-index: 1; /* Sit on top */
	  padding-top: 100px; /* Location of the box */
	  left: 0;
	  top: 0;
	  width: 100%; /* Full width */
	  height: 100%; /* Full height */
	  overflow: auto; /* Enable scroll if needed */
	  background-color: rgb(0,0,0); /* Fallback color */
	  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content */
	.modal-content {
	  background-color: #fefefe;
	  margin: auto;
	  padding: 20px;
	  border: 1px solid #888;
	  width: 80%;
	}
	
	/* The Close Button */
	.close {
	  color: #aaaaaa;
	  float: right;
	  font-size: 28px;
	  font-weight: bold;
	}
	
	.close:hover,
	.close:focus {
	  color: #000;
	  text-decoration: none;
	  cursor: pointer;
	}
</style>
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
		<div id="myModal" class="modal">
		
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <p>Some text in the Modal..</p>
		    
		  </div>
				            		
		</div>
    <div>
    	<c:if test="${not empty listaJogos }">
	        <table border = 1>
	        	<tr>
	                <th>Data</th>
	            	<th>Primeiro time</th>
					<th>Gols do primeiro time</th>            	
	                <th>&nbsp;</th>
	                <th>Gols do segundo time</th>
	                <th>Segundo time</th>
	                <th>Adicionar Gols</th>
	            </tr>
				<c:forEach items="${listaJogos }" var="jg">       
		            <tr>
		                <td>${jg.dataJogo}</td>
		                <td>${jg.tA}</td>
		            	<td>${jg.golsTimeA}</td>  
		            	<td> X </td>              
		                <td>${jg.golsTImeB}</td>
		                <td>${jg.tB}</td> 
		                <td><button  id="myBtn" name = "gol">+</button></td>
		            </tr>
		            		<!-- The Modal -->
		<script>
		// Get the modal
		var modal = document.getElementById("myModal");
		
		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");
		
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		
		// When the user clicks the button, open the modal 
		btn.onclick = function() {
		  modal.style.display = "block";
		}
		
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		  modal.style.display = "none";
		}
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";
		  }
		}
		</script>
		       	</c:forEach> 
			</table>
		</c:if>
    </div>

</body>
</html>