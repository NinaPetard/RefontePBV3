/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxibanque_V2.Service;

import java.util.ArrayList;

import proxibanque_V2.dao.DAO_Client;
import proxibanque_V2.dao.DAO_Verifications;
import proxibanque_V2.metier.Client;

public class Service_Conseiller {
	
	/**
	 * Transfers the authentification demand from the servlet to the DAO
	 * @param login
	 * @param password
	 * @return
	 */
	
	public boolean demanderconnexion(String login , String password) {
		
		DAO_Verifications dao1 = new DAO_Verifications();		
		boolean valeur = dao1.authConseiller(login, password);
		
		return valeur;
		
	}
	/**
	 * Transfers the list of an advisor's clients from DAO to  frontend
	 * @param idconseiller
	 * @return
	 */
	
	
	public ArrayList<Client> demanderclients(int idconseiller){
		ArrayList<Client> clients = new ArrayList<Client>();
		
		DAO_Client daoc = new DAO_Client();
		clients = daoc.getCliConseiller(idconseiller);
		
		
		
		return clients;
	}
	
	
	
	
    
}
