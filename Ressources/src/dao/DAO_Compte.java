package proxibanque_V2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proxibanque_V2.metier.Client;
import proxibanque_V2.dao.DAO_Connexion;
import proxibanque_V2.metier.Compte;

public class DAO_Compte {

	// Create
	/**
	 * Insert a Compte object in the database
	 * 
	 * @param compte
	 *            Compte object to be added to the database
	 */
	public void insertCompte(Compte compte) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();

			PreparedStatement pstmt = connection.prepareStatement("Insert into Compte values( ? ,? ,? ,?, ? ,?)");

			pstmt.setInt(1, compte.getIdCompte());
			pstmt.setDouble(2, compte.getSolde());
			pstmt.setInt(3, compte.getClient().getIdClient());
			pstmt.setString(4, compte.getType());
			pstmt.setDouble(5, compte.getDecouvert());
			pstmt.setDouble(6, compte.getInteret());

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
	 * Updates a given account in the database, based on a Compte Java object.
	 * 
	 * @param info
	 *            Information of the account to be updated. It can be either
	 *            "idClient", "interet", "decouvert". For safety reason, modifying
	 *            the account balance cannot be updated by this programm. For
	 *            database stability reasons, the account id cannot be updated by
	 *            this program.
	 * @param replace
	 *            what should the new value be.
	 * @param compte
	 *            Account to update.
	 */
	public void updateCompte(String info, String replace, Compte compte) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Update Compte set " + info + " = '" + replace + "' WHERE idcompte=" + compte.getIdCompte();

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);
			System.out.println("Le compte " + compte.getIdCompte() + "a été mis à jour.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La mise à  jour a échoué");
		}

	}

	/**
	 * Updates a given account in the database, based on the id of an account.
	 * 
	 * @param info
	 *            Information of the account to be updated. It can be either
	 *            "idClient", "interet", "decouvert". For safety reason, modifying
	 *            the account balance cannot be updated by this programm. For
	 *            database stability reasons, the account id cannot be updated by
	 *            this program.
	 * @param replace
	 *            what should the new value be.
	 * @param idCompte
	 *            Id of the account to update.
	 */
	public void updateCompte(String info, String replace, String idCompte) {

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Update Compte set " + info + " = '" + replace + "' WHERE idcompte=" + idCompte;

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);
			System.out.println("Le compte " + idCompte + "a été mis à jour.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La mise à  jour a échoué");
		}

	}

	// Delete
	/**
	 * Deletes a given account based on a Compte java object.
	 * 
	 * @param compte
	 *            Compte object of the account to be deleted
	 */

	public void deleteCompte(Compte compte) {
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Delete Compte WHERE idcompte='" + compte.getIdCompte() + "'";

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);

			System.out.println("Le compte " + compte.getIdCompte() + " a été supprimé.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La suppression a échoué");
		}
	}

	/**
	 * Deletes a given account based on its id.
	 * 
	 * @param idCompte
	 *            Id of the account to be deleted.
	 */
	public void deleteCompteId(int idCompte) {
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			String sql = "Delete Commande WHERE idclient=" + idCompte;

			Statement stat = connection.createStatement();
			stat.executeUpdate(sql);

			sql = "Delete Client WHERE idclient=" + idCompte;

			stat = connection.createStatement();
			stat.executeUpdate(sql);

			System.out.println("Le client " + idCompte + "a été supprimé.");
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La suppression a échoué");
		}
	}

	// Read

	/**
	 * Gets all the accounts of a given client.
	 * 
	 * @param idClient
	 *            Id of the client whose accounts shall be retrieved.
	 * @return Returns an ArrayListe of Compte objects, one for each of the client's
	 *         account.
	 */
	public ArrayList<Compte> getCpteClient(int idClient) {
		ArrayList<Compte> cptClient = new ArrayList<>();
		String r = "Select * from Compte where idClient =" + idClient;
		DAO_Connexion dao1 = new DAO_Connexion();
		Connection connection = dao1.seConnecter();
		
		try {
			
			
			
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);
			
			while (res.next()) {
				
				int idCompte = res.getInt("idcompte");
				Double solde = res.getDouble("solde");
				String type = res.getString("typec");
				Double interet = res.getDouble("interet");
				Double decouvert = res.getDouble("decouvert");
				Compte compte;
				compte = new Compte(idCompte, solde, type, interet, decouvert);
				cptClient.add(compte);
				
			}

			dao1.seDeconnecter(connection);
			return cptClient;
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");

		}
		return cptClient;
	}

	/**
	 * Gets an Account from the database based on its Id
	 * 
	 * @param idCompte
	 *            Id of the account to be retrieved from the database
	 * @return Returns a Compte object.
	 */

	public Compte getComptewId(int idCompte) {
		String r = "SELECT * from Compte WHERE idCompte = " + idCompte;

		Compte compte = new Compte();

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);

			if (res.next()) {

				Double solde = res.getDouble("solde");
				DAO_Client dc = new DAO_Client();
				Client client = dc.getClientwId(res.getInt("idclient"));
				String type = res.getString("typec");
				Double interet = res.getDouble("interet");
				Double decouvert = res.getDouble("decouvert");
				compte = new Compte(idCompte, solde, client, type, interet, decouvert);
				return compte;

			} else {
				compte.setIdCompte(0);
			}
			dao1.seDeconnecter(connection);
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");
		}
		return compte;

	}
	
	/**
	 * Gets the id of the client who owns the given account.
	 * @param idCompte Id of the account to look for
	 * @return returns the id of the client or 0 if the client was not found.
	 */
	
	public int getidCliwCpt(int idCompte) {
		String r = "SELECT * from Compte WHERE idCompte = " + idCompte;
		System.out.println(r);
		Compte compte = new Compte();
		int idclient = 0; 

		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery(r);

			if (res.next()) {				
			idclient = res.getInt("idclient");
			}
			dao1.seDeconnecter(connection);
		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Connexion à la base impossible");
		}
		return idclient;

	}
	

}
