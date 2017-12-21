<%@includefile = "header.jsp" %>
<%@includefile = "/navbar.jsp" %>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<div class="well">
					<form method="post" action="ServletVirement">

						<label for="number">Identifiant du compte à débiter:</label> <input
							type="number" class="form-control" name="comptedebit"> <label
							for="number">Identifiant du compte à créditer:</label> <input
							type="number" class="form-control" name="comptecredit"> <label
							for="number">Montant du virement:</label> <input type="number"
							class="form-control" name="montant"> <br>
						<button type="submit" class="btn btn-default">Effectuer</button>
					</form>
				</div>
			</div>



			
			

					<c:if test="${message!=null}">
					<div class="col-sm-6">
					<div class="well">
						<p> ${message}</p>
						</div>
						</div>
					</c:if>
				

			
</body>
</html>