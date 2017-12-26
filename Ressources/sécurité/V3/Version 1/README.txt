Lancer le script scriptformdb depuis la console sql

Avant de déployer, configurer le serveur TomCat dans le fichier tomcat-user en ajoutant en bas de page:

<role rolename="conseiller"/>
<user username="conseiller" password="conseiller" roles="conseiller"/>


Dans le fichier context.xml de tomcat-user rajouter:
<Resource name="jdbc/formation" auth="Container" type="javax.sql.DataSource"
	maxActive="100" maxIdle="30" username="khaled" password="khaled" driverClassName="oracle.jdbc.OracleDriver"
	url="jdbc:oracle:thin:@localhost:1521:XE"  />
	
	<Realm className="org.apache.catalina.realm.DataSourceRealm"
	dataSourceName="jdbc/formation" localDataSource="true" userTable="conseiller" userRoleTable="Role"  userNameCol="login"
	userCredCol="password" roleNameCol="role_type" />

Vous pouvez maintenant déployer le war sur Tomcat.

Tester l'url suivante:http://localhost:8081/ProxiBanquev2_KR_ApplicationDB/VoirCompteClient.jsp

Une page avec un formulaire devrait apparaitre. Rentrez Robinson et Bordes dans les champs demandés. 

Vous avez accès à la page souhaitée.

