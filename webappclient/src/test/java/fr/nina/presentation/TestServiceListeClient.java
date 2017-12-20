/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina
 */
public class TestServiceListeClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         ClientListeConseiller cls = new ClientListeConseiller();
            String responseService = cls.sendCliData("1");
                       
            ObjectMapper mapper = new ObjectMapper();            
        try {           
            ArrayList<fr.nina.domaineclient.Client> clients = mapper.readValue(responseService, mapper.getTypeFactory().constructCollectionType(ArrayList.class, fr.nina.domaineclient.Client.class));
        } catch (IOException ex) {
            Logger.getLogger(TestServiceListeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
