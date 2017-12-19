/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.nina.dao.ConseillerJpaController;
import fr.nina.domaine.Client;
import fr.nina.domaine.Conseiller;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nina et Robinson*
 */
/**
 * Codage de la classe ServiceConseiller Cette classe permet d'obtenir la liste
 * des clients par l'intermédiaire de l'id du conseiller identifié Cette liste
 * est recupérée sous forme d'un JSON qui sera recupéré par une application
 * Client et affichée.
 */
public class ServiceConseiller {

    public static String listerClientsConseiller(Long idcons) {

        List<Client> clients;
        EntityManagerFactory emf;
        String lcjson = "";
        //import
        emf = Persistence.createEntityManagerFactory("fr.nina_domaine_jar_1.0-SNAPSHOTPU");
        ConseillerJpaController cjc = new ConseillerJpaController(emf);

        Conseiller cons = cjc.findConseiller(idcons);
        clients = cons.getClientList();
         emf.close();

        lcjson = clientsConseillertoJSON(clients);
        return lcjson;
    }

    public static String clientsConseillertoJSON(List<Client> clients) {
        String lcjson = "pas de clients";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        lcjson = objectMapper.writeValueAsString(clients);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(ServiceConseiller.class.getName()).log(Level.SEVERE, null, ex);

        }
       
        return lcjson;

    }

}
