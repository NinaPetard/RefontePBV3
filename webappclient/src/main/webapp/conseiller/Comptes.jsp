<%@includefile = "header.jsp" %>
<%@includefile = "/navbar.jsp" %>

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