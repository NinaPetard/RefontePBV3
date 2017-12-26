
package proxibanque_V2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proxibanque_V2.dao.DAO_Connexion;
import proxibanque_V2.metier.Client;


public class DAO_Client {

	// Create
	/**
	 * The method allows to add a client to the database.
	 * 
	 * @param client
	 *            Client object to be added into the database
	 */

	public void insertClient(Client client) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();

			PreparedStatement pstmt = connection.prepareStatement("Insert into Client values( ? ,? ,? ,?, ? ,?, ?,?)");

			pstmt.setInt(1, client.getIdClient());
			pstmt.setString(2, client.getNom());
			pstmt.setString(3, client.getPrenom());
			pstmt.setString(4, client.getAdresse());
			pstmt.setString(5, client.getCodepostal());
			pstmt.setString(6, client.getVille());
			pstmt.setString(7, client.getTelephone());
			pstmt.setInt(8, client.getIdConseiller());

			pstmt.execute();

			System.out.println("Le client a été ajouté à  la base.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Impossible d'ajouter le client à la base");
		}

	}

	// Update
	/**
	 * Updates an info about a client in the database based on a Client object
	 * 
	 * @param info
	 *            What information should be changed (possibles values are: nom,
	 *            prenom, adresse, codepostal, ville , telephone, idConseiller).
	 * @param replace
	 *            What should the info be replaced with.
	 * @param client
	 *            Client object on which the update has to be performed.
	 */
	public void updateClient(String info, String replace, Client client) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Update Client set " + info + " = '" + replace + "' WHERE idclient=" + client.getIdClient();

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);
			System.out.println("Le client " + client.getNom() + " " + client.getPrenom() + "a Ã©tÃ© mis Ã  jour.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La mise à  jour a échoué");
		}

	}

	/**
	 * Updates an info about a client in the database based on a client id.
	 * 
	 * @param info
	 *            What information should be changed (possibles values are: nom,
	 *            prenom, adresse, codepostal, ville , telephone, idConseiller).
	 * @param replace
	 *            What should the info be replaced with.
	 * @param client
	 *            Id of the client on which the update has to be performed.
	 */

	public void updateClientId(String info, String replace, int idclient) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Update Client set " + info + " = '" + replace + "' WHERE idclient=" + idclient;

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);
			System.out.println("Le client " + idclient + "a été mis à jour.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La mise à  jour a échoué");
		}

	}

	// Delete
	/**
	 * Deletes a client in the database based on a Client object
	 * 
	 * @param client
	 *            Client object which should be deleted in the database
	 */
	public void deleteClient(Client client) {
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Delete Commande WHERE idclient=" + client.getIdClient();

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);

			sql = "Delete Client WHERE idclient=" + client.getIdClient();

			stat = connection.createStatement();
			stat.executeUpdate(sql);

			System.out.println("Le client " + client.getNom() + " " + client.getPrenom() + "a Ã©tÃ© supprimÃ©.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La suppression a échoué");
		}
	}

	/**
	 * Deletes a client in the database based on the id of said client.
	 * 
	 * @param client
	 *            Id of the client to be deleted.
	 */
	public void deleteClientId(int idclient) {
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Delete Commande WHERE idclient=" + idclient;

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);

			sql = "Delete Client WHERE idclient=" + idclient;

			stat = connection.createStatement();
			stat.executeUpdate(sql);

			System.out.println("Le client " + idclient + "a été supprimé.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La suppression a échoué");
		}
	}

	// Read
	/**
	 * Creates and returns a list of all clients in the database
	 * 
	 * @return Information is returned as an ArrayList of object of type Client.
	 */
	public ArrayList<Client> getAllClients() {
		ArrayList<Client> allclients = new ArrayList<>();
		try {

			String r = "Select * from Client";
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);

			while (res.next()) {
				int idClient = res.getInt(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String adresse = res.getString(4);
				String codepostal = res.getString(5);
				String ville = res.getString(6);
				String telephone = res.getString(7);
				int idConseiller = res.getInt(8);
				Client client;
				client = new Client(idClient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller);
				allclients.add(client);

			}

			dao1.seDeconnecter(connection);
			return allclients;
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");
		}
		return allclients;
	}

	/**
	 * Creates and returns a list of all clients for a given customer advisor, based
	 * on the Id of said advisor.
	 * 
	 * @param idConseiller
	 *            Id of the advisor whose clients should be returned.
	 * @return An ArrayList of object of type Client.
	 */

	public ArrayList<Client> getCliConseiller(int idConseiller) {
		ArrayList<Client> cliConseiller = new ArrayList<>();
		try {
			String r = "Select * from Client where idConseiller =" + idConseiller;
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);

			while (res.next()) {
				int idClient = res.getInt("idclient");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				String adresse = res.getString("adresse");
				String codepostal = res.getString("codepostal");
				String ville = res.getString("ville");
				String telephone = res.getString("telephone");
				Client client;
				client = new Client(idClient, nom, prenom, adresse, codepostal, ville, telephone, idConseiller);
				cliConseiller.add(client);

			}

			dao1.seDeconnecter(connection);
			return cliConseiller;
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");

		}
		return cliConseiller;
	}

	/**
	 * Extract a client from the database based on the client's id.
	 * 
	 * @param idClient
	 *            Id of the client to be extracted from the database
	 * @return Object of type Client containing the info of the database.
	 */
	public Client getClientwId(int idClient) {
		Client client = new Client();
		try {
			String r = "SELECT * from Client WHERE idclient = " + idClient;
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);

			if (res.next()) {

				client.setIdClient(res.getInt(1));
				client.setNom(res.getString(2));
				client.setPrenom(res.getString(3));
				client.setAdresse(res.getString(4));
				client.setCodepostal(res.getString(5));
				client.setVille(res.getString(6));
				client.setTelephone(res.getString(7));
				client.setIdConseiller(res.getInt(8));

				return client;

			} else {
				System.out.println("Ce numéro ne correspond à aucun client de la base");

			}
			dao1.seDeconnecter(connection);
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");
		}
		return client;

	}

	public boolean checkClientwId(int idClient) {
		boolean valeur = false;
		DAO_Connexion dao1 = new DAO_Connexion();
		Connection connection = dao1.seConnecter();
		try {
			String r = "SELECT * from client WHERE idclient = " + idClient;

			Statement stat = connection.createStatement();

			ResultSet res = stat.executeQuery(r);

			boolean booleentest = res.next();

			if (booleentest == true) {
				valeur = true;
			}

			dao1.seDeconnecter(connection);
			return valeur;

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible dans la méthode checkClientwId");
		}
		dao1.seDeconnecter(connection);
		return valeur;

	}

}
