/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.nina.domaine.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina
 */
public class ServiceClient {

    public static Client clientfromJSON(String clientJson) {
        Client client = new Client();
        ObjectMapper mapper = new ObjectMapper();
        try {
            client = mapper.readValue(clientJson, mapper.constructType(Client.class));
        } catch (IOException ex) {
            Logger.getLogger(ServiceClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
   }

}
