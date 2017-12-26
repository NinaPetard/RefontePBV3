
package proxibanque_V2.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Class dedicated to connecting and disconnecting from a given database.
 * @author adminl
 *
 */

public class DAO_Connexion { 
     private static final String pilote = "oracle.jdbc.OracleDriver";
     private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
     private static final String user = "joinelnina";
     private static final String password = "toto";
             
/**
 * Opens a connection to the database
 * @return return a Connection which can be used by various methods to access information in the database
 */
    public Connection seConnecter() {
       
        Connection cnx = null;        
        try {
            
            Class.forName(pilote);
            
            cnx = DriverManager.getConnection(url,
                    user, password);               

        } catch (ClassNotFoundException| SQLException ex) {
            System.out.println("Problème de connexion");
            Logger.getLogger(DAO_Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
         return cnx;
        
    }
    /**
     * Closes a connection to the database.
     * @param cnx Connection to be closed.
     */
    
   public void seDeconnecter(Connection cnx) {
        try {
            cnx.close();
    
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    

    
    }
   
  
    

