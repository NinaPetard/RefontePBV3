package proxibanque_V2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import proxibanque_V2.metier.Compte;
/**
 * This class deals with verificating if an element exists in the databases. They return true if it does, false otherwise.
 * @author adminl
 * @version In further version, these methods should be transferred to the proper DAOs.
 *
 */
public class DAO_Verifications {
	/**
	 * Checks if the couple login/password corresponds to an advisor.
	 * @param login
	 * @param pwd
	 * @return
	 */

	public boolean authConseiller(String login, String pwd) {
        boolean identify = false;
        String r = "Select * from Conseiller where userid= '" + login + "' and password='" + pwd + "'";
        PreparedStatement pstmt;
        DAO_Connexion dao1 = new DAO_Connexion();
        Connection connection = dao1.seConnecter();

        try {
            pstmt = connection.prepareStatement(r);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	identify = true;
            }
            dao1.seDeconnecter(connection);
            return identify;
        } catch (SQLException ex) {
            System.out.println("Erreur en interrogeant la base");
            Logger.getLogger(DAO_Verifications.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identify;
        
    }
    /**
     * Checks if an account exists based on its id
     * @param idcompte
     * @return 
     */
    public boolean authCompte(int idcompte) {
        boolean identify = false;
        String r = "Select * from Compte where idcompte = " + idcompte;
        PreparedStatement pstmt;
        
        DAO_Connexion dao1 = new DAO_Connexion();
        Connection connection = dao1.seConnecter();

        try {
            pstmt = connection.prepareStatement(r);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	identify = true;
            }
            
            dao1.seDeconnecter(connection);
            return identify;
            
        } catch (SQLException ex) {
            System.out.println("Erreur en interrogeant la base");
            Logger.getLogger(DAO_Verifications.class.getName()).log(Level.SEVERE, null, ex);
        }
        return identify;
    }
     
 
     

}
