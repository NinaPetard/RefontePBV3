/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.presentation;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:WebServiceListerClients
 * [conseiller]<br>
 * USAGE:
 * <pre>
 *        ListeClientsConseiller client = new ListeClientsConseiller();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Nina
 */
public class ClientListeConseiller {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8081/service/proxapi";

    public ClientListeConseiller() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("conseiller");
    }

    public String sendMessage() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("listeclients");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String sendCliData(String idConseiller) throws ClientErrorException {
        return webTarget.path("listeclients").request(MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(idConseiller, MediaType.TEXT_PLAIN), String.class);
    }

    public void close() {
        client.close();
    }
    
}
