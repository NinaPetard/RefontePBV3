<%@includefile = "header.jsp" %>
<%@includefile = "/navbar.jsp" %>


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