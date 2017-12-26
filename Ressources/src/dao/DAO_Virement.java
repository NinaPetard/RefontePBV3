
package proxibanque_V2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import proxibanque_V2.metier.Virement;


public class DAO_Virement {
	
	
/**
 * Applies transfer modifications on the accounts in the database
 * @param comptedebit
 * @param comptecredit
 * @param montant
 * @return
 */
	public String faireVirement(int comptedebit, int comptecredit, double montant) {
		String txt = "";
		
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();

			String sd = "Update Compte set solde = solde - " + montant + " WHERE idcompte='" + comptedebit + "'";
			String sc = "Update Compte set solde = solde + " + montant + " WHERE idcompte='" + comptecredit + "'";

			Statement statd = connection.createStatement();
			statd.executeUpdate(sd);

			Statement statc = connection.createStatement();
			statc.executeUpdate(sc);
			
			
			
			dao1.seDeconnecter(connection);
			
			
			txt = "Le virement a bien été effectué";
			return txt;

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("La mise en oeuvre du virement dans la base a échoué");
		}

		
		return txt;
	}
	/**
	 * Saves the transfer in the database
	 * @param virement
	 */

	public void insertVirement(Virement virement) {
		try {
			DAO_Connexion dao1 = new DAO_Connexion();
			Connection connection = dao1.seConnecter();

			PreparedStatement pstmt = connection.prepareStatement("Insert into Virement values( ? ,? ,? ,?, ?)");

			pstmt.setInt(1, virement.getIdVirement());
			pstmt.setInt(2, virement.getCompteDebit().getIdCompte());
			pstmt.setInt(3, virement.getCompteCredit().getIdCompte());
			pstmt.setDouble(4, virement.getMontant());
			Date date = virement.getDate();
			java.sql.Date sqldate = new java.sql.Date(date.getTime());			
			pstmt.setDate(5, sqldate);
			pstmt.execute();
			
			dao1.seDeconnecter(connection);

		} catch (SQLException ex) {
			Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Impossible d'ajouter le virement à la base");
		}

	}

}
