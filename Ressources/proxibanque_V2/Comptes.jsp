<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil Conseiller</title>
<link rel="stylesheet" href="Style/css/bootstrap.min.css">
<link rel="stylesheet" href="Style/js/bootstrap.min.js">
<link rel="stylesheet" href="Style/css/Theme.css">
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
	<a class="navbar-brand" href="Accueil_Conseiller.jsp"><proxi>Proxibanque</proxi></a>
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-nav">
			<li ><a href="ServletPrintClients">Mon espace</a></li>
			<li><a href="ModifierClient.jsp">Modifier client</a></li>
			<li class="active"><a href="ServletListeClientComptes">Voir comptes client</a></li>
			<li ><a href="Virement.jsp">Faire un virement</a></li>
		</ul>
		<div class="navbar-header navbar-right"></div>
	</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<div class="well">
					choix du client

					<div class="form-group">
						<form method="post" action="AfficherComptes">
							<select class="form-control" id="client" name="client">
								<c:forEach var="type" items="${inpClients}">
									<option value="${type.key}">${type.value}</option>
								</c:forEach>
							</select> <br>
							<button type="submit" class="btn btn-default">Voir
								comptes</button>
						</form>
					</div>
				</div>
			</div>
	
	
	<div class="col-sm-6">
		
		<c:if test="${comptes!=null}">		
		<div class="well"><h1>Compte(s) de la personne</h1>	
			<c:forEach var="type" items="${comptes}">
  						${type} <br> <br>
							</c:forEach>

		</c:if>
		</div>
</div>
	</div>
		</div>
</body>
</html>