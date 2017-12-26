/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.webservice;

import fr.nina.dao.ClientJpaController;
import fr.nina.domaine.Client;
import fr.nina.service.ServiceClient;
import static fr.nina.service.ServiceClient.clientfromJSON;
import static fr.nina.service.ServiceConseiller.listerClientsConseiller;
import static fr.nina.util.Emf.getEmf;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adminl
 */
public class WebServiceModifierClient {
    
    @Path("conseiller")
public class WebServiceListerClients {

    @POST
    @Path("modifierclient")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String sendCliData(String clientJson) {
        String message="";
        EntityManagerFactory emf = getEmf();
        ClientJpaController daoC = new ClientJpaController(emf);
        
       
        
        
        try{        
       Client client;
       client = clientfromJSON(clientJson);
        daoC.edit(client);        
        message="Les informations du client on été mises à jour";
        }
        catch(Exception e){
            message = "Les informations du clients n'ont pas pu être mises à jour";
        }        
        return message;

    }

    }
}

