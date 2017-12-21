<!DOCTYPE html>
<html>
<head>
<title>Accueil</title>
<link rel="stylesheet" href="Style/css/bootstrap.min.css">
<link rel="stylesheet" href="Style/css/Theme.css">
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="well">
				<form method="post" action="ServletAuth">
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