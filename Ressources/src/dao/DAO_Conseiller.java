package proxibanque_V2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import proxibanque_V2.metier.Conseiller;

public class DAO_Conseiller {
	
	
	/**
	 * Uses the id of an advisor to retrieve it from the database
	 * @param idconseiller id of the advisor to be fetched
	 * @return an object of type Conseiller. For performance reasons, the client list is not added to the object. Such method could be added in further version.
	 */
	public Conseiller getConseillerwId(String idconseiller) {
        Conseiller conseiller = new Conseiller();
        try {
            String r = "SELECT * from Conseiller WHERE userid = '" + idconseiller + "'";
            DAO_Connexion dao1 = new DAO_Connexion();
            Connection connection = dao1.seConnecter();
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery(r);

            if (res.next()) {
                
                conseiller.setPassword(res.getString(5));
                conseiller.setPrenom(res.getString(4));
                conseiller.setNom(res.getString(3));
                conseiller.setUserid(res.getString(2));
                conseiller.setIdConseiller(res.getInt(1));
                return conseiller;

            } else {
                System.out.println("Ce numéro ne correspond à aucun conseiller de la base");
            }
            
            dao1.seDeconnecter(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connexion à la base impossible");
        }
        return conseiller;

    }
	
	/**
	 * Checks if a client belongs to a given advisor based on their id.
	 * @param idconseiller id of the advisor
	 * @param idclient id of the client
	 * @return returns true if the advisor does manage this client, else, returns false.
	 */
	public boolean checkCliCons(int idconseiller, int idclient) {
       boolean valide = false;
        try {
            String r = "SELECT * from Client WHERE idconseiller ="+idconseiller+" and idclient="+idclient ;
            System.out.println(r);
            DAO_Connexion dao1 = new DAO_Connexion();
            Connection connection = dao1.seConnecter();
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery(r);
            if (res.next()) {
            	valide = true;
            }        
            
            dao1.seDeconnecter(connection);
            return valide;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connexion à la base impossible");
        }
        return valide;

    }

}
