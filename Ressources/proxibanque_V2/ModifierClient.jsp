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
			<li class="active"><a href="ServletEdition">Modifier client</a></li>
			<li><a href="ServletListeClientComptes">Voir comptes client</a></li>
			<li ><a href="Virement.jsp">Faire un virement</a></li>
		</ul>
		<div class="navbar-header navbar-right"></div>
	</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5">
				<div class="well">

					<form class="form" method="post" action="ServletModif">
						<p>
							Quel est l'id du client que vous souhaitez modifier? <input type="number" name="idclient">
						<p>Quelle information souhaitez vous modifier?</p>

						<div class="radio">
							<label><input type="radio" name="info" value="nom">Nom</label>
							<label><input type="radio" name="info" value="prenom">Prenom</label>
							<label><input type="radio" name="info" value="adresse">Adresse</label>
							<label><input type="radio" name="info" value="codepostal">Codepostal</label>
							<label><input type="radio" name="info" value="telephone">Téléphone</label>
						</div>
						<p>Quelle est la nouvelle valeur pour cette information?</p>
						<input type="text" class="form-control" name="replace">

						<button type="submit" class="btn btn-default">Mettre à jour</button>
						
							
					</form>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>
</body>
</html>