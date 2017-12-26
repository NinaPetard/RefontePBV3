<%@includefile = "/header.jsp" %>

<html>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="well">
				<form method="post" action="Connexion">
					<div class="form-group">
						<label for="text">Login:</label> <input type="text"
							class="form-control" placeholder="login" name="loginuser">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" id="pwd" placeholder="mot de passe"
							name="mdpuser">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>



		<div class="col-sm-4"></div>
	</div>
	</div>


</body>
</html>
