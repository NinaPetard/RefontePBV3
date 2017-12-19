/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gtm.dao.ConseillerJpaController;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Nina et Robinson**/

/**
 * Codage de la classe Service_Conseiller
 * Cette classe permet d'obtenir la liste des clients par l'intermédiaire de l'id du conseiller identifié
 * Cette liste est recupérée sous forme d'un JSON qui sera recupéré par une application Client et affichée.
 */
public class Service_Conseiller {

    public static String listerClientsConseiller(Long idcons) {

        List<Client> clients;
        EntityManagerFactory emf;
        String lcjson = "";
        //import
        emf = Persistence.createEntityManagerFactory("fr.gtm_domaine_jar_1.0-SNAPSHOTPU");
        ConseillerJpaController cjc = new ConseillerJpaController(emf);

        Conseiller cons = cjc.findConseiller(idcons);
        clients = cons.getClientList();

        //json-isation
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            lcjson = objectMapper.writeValueAsString(clients);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Service_Conseiller.class.getName()).log(Level.SEVERE, null, ex);

        }
        emf.close();
        return lcjson;

    }

}
