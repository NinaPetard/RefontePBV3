<%@includefile = "header.jsp" %>
<%@includefile = "/navbar.jsp" %>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5">
				<div class="well">

					<form method="post" action="PrepareModif">
							<select class="form-control" id="clientmodif" name="clientmodif">
								<c:forEach var="client" items="${clients}">
									<option value="${client.idclient}">${client.idclient} - ${client.nom} ${client.prenom}</option>
								</c:forEach>
							</select> <br>
							<button type="submit" class="btn btn-default">Modifier ce client
								comptes</button>
						</form>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>
</body>
</html>