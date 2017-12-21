<%@includefile = "header.jsp" %>
<%@includefile = "/navbar.jsp" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>        
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                    <div class="well">
                        <p>Bienvenue sur votre espace personnel.<br> A droite, vous pouvez
                            consulter la liste des clients donc vous avez la charge. <br>
                            L'ensemble des actions possibles sont listées dans la barre des
                            tâches ci-dessus.</p>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="well">
                        <table class="table table-striped">
                            <tr>
                                <th>Identifiant</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Adresse</th>
                                <th>Telephone</th>
                            </tr>

                            <c:forEach var="client" items="${clients}">
                                <tr>
                                    <th> ${client.idclient} </th>
                                    <th>${client.nom}</th>
                                    <th>${client.prenom}</th>
                                    <th>${client.adresse} ${clients.codePostal} ${clients.ville}</th>
                                    <th>${client.telephone}</th>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>

                </div>
            </div>
        </div>

    </body>
</html>
