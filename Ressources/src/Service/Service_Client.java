package proxibanque_V2.Service;

import java.util.ArrayList;

import proxibanque_V2.dao.DAO_Client;
import proxibanque_V2.dao.DAO_idGenerators;
import proxibanque_V2.metier.Client;
import proxibanque_V2.metier.Conseiller;

public class Service_Client {
	
	/**
	 * Creates a client object, excepts for the accounts.
	 * @param idClient
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codepostal
	 * @param ville
	 * @param telephone
	 * @param idConseiller
	 * @return
	 */
	public Client creerClient(int idClient, String nom, String prenom, String adresse, 
            String codepostal, String ville, String telephone, int idConseiller) {
		
		Client client = new Client(nom, prenom, adresse, codepostal, ville, telephone, idConseiller);
		DAO_idGenerators idg = new DAO_idGenerators();
		
		client.setIdClient(idg.createidCli());
		
		return client;
	}
	
	/**
	 * Returns a list of the client of an advisor based on the advisor's id.
	 * @param conseiller
	 * @return
	 */
	
	public ArrayList<Client> retournerArrayListClient(Conseiller conseiller) {

		DAO_Client doa1 = new DAO_Client();

		ArrayList<Client> listeclient1 = new ArrayList<Client>();

		listeclient1 = doa1.getCliConseiller(conseiller.getIdConseiller());

		return listeclient1;

	}
	
	/**
	 * Transfers the information to be modified in the base to the DAO layer
	 * @param info
	 * @param replace
	 * @param idclient
	 */

	public void changerInfoClient(String info, String replace, int idclient) {

		DAO_Client dao1 = new DAO_Client();

		dao1.updateClientId(info, replace, idclient);

	}
	
	/**
	 * Checks if a client exists in the database
	 * Copy of DAO_Verification.authClient, should be fusionned in further versions
	 * @param idclient
	 * @return
	 */

	public boolean verifIdClient(int idclient) {

		DAO_Client dao1 = new DAO_Client();

		boolean valeur = dao1.checkClientwId(idclient);

		return valeur;

	}

}
