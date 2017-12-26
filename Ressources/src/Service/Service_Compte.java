package proxibanque_V2.Service;

import java.util.ArrayList;
import proxibanque_V2.dao.DAO_Compte;
import proxibanque_V2.metier.Compte;

public class Service_Compte {
	
	/**
	 * Tranfers the list of clients of an advisor from the DAO to the front end
	 * @param idclient
	 * @return
	 */
	
	
	public ArrayList<Compte> demanderclients(int idclient){
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		
		DAO_Compte daoc = new DAO_Compte();
		comptes = daoc.getCpteClient(idclient);		
		
		return comptes;
	}

}
