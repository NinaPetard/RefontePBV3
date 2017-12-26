/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxibanque_V2.dao;
/**
 * This class deals with generating ids for all databases. Currently, advisor, account, client and transfer are implemented.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import proxibanque_V2.dao.DAO_Connexion;

public class DAO_idGenerators {
    
    public int createidCli() {
        int idClient = 0;
        try {

            String r = "Select clientSEQ.nextval from dual";

            DAO_Connexion dao1 = new DAO_Connexion();
            Connection connection = dao1.seConnecter();
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery(r);
            if (res.next()) {
                idClient = res.getInt(1);
            }
            dao1.seDeconnecter(connection);
            return idClient;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idClient;
    }
    
    public int createidCons() {
        int idConseiller = 0;
        try {

            String r = "Select conseillersSEQ.nextval from dual";

            DAO_Connexion dao1 = new DAO_Connexion();
            Connection connection = dao1.seConnecter();
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery(r);
            if (res.next()) {
                idConseiller = res.getInt(1);
            }
            dao1.seDeconnecter(connection);
            return idConseiller;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idConseiller;
    }
    
        public int createidCompte() {
        int idCompte = 0;
        try {

            String r = "Select compteSEQ.nextval from dual";

            DAO_Connexion dao1 = new DAO_Connexion();
            Connection connection = dao1.seConnecter();
            Statement stat = connection.createStatement();
            ResultSet res = stat.executeQuery(r);
            if (res.next()) {
                idCompte = res.getInt(1);
            }
            dao1.seDeconnecter(connection);
            return idCompte;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCompte;
    }
        
        public int createidVirement() {
            int idVirement = 0;
            try {

                String r = "Select virementSEQ.nextval from dual";

                DAO_Connexion dao1 = new DAO_Connexion();
                Connection connection = dao1.seConnecter();
                Statement stat = connection.createStatement();
                ResultSet res = stat.executeQuery(r);
                if (res.next()) {
                    idVirement = res.getInt(1);
                }
                dao1.seDeconnecter(connection);
                return idVirement;
                
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            return idVirement;
        }
    
}
