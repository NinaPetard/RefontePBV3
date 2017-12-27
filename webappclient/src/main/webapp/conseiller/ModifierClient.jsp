<%@includefile = "header.jsp" %>
<%@includefile = "navbar.jsp" %>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4">
				<div class="well">

					<form method="post" action="PrepareModif">
							<select class="form-control" id="clientmodif" name="clientmodif">
								<c:forEach var="client" items="${clients}">
									<option value="${client.idclient}">${client.idclient} - ${client.nom} ${client.prenom}</option>
								</c:forEach>
							</select> <br>
							<button type="submit" class="btn btn-default">Modifier ce client</button>
						</form>
					
				</div>
                          
			</div>
                    <div class="col-sm-5">
                        <div class="well">
                            <form method="post" action="ModifierClient">
                                <label for="nom">Nom:</label>
      <input type="text" class="form-control" id="nom" placeholder="Petard" name="nom">
       <label for="prenom">Prenom:</label>
      <input type="text" class="form-control" id="prenom" placeholder="Nina" name="prenom">
       <label for="email">Adresse:</label>
      <input type="text" class="form-control" id="nom" placeholder="Petard" name="nom">
       <label for="email">Code Postal:</label>
      <input type="text" class="form-control" id="nom" placeholder="Petard" name="nom">
       <label for="email">Ville:</label>
      <input type="text" class="form-control" id="nom" placeholder="Petard" name="nom">
       <label for="email">Telephone:</label>
      <input type="text" class="form-control" id="nom" placeholder="Petard" name="nom">
                                
                           
                            </form>
                        </div>
                    </div>
		</div>
</body>
</html>