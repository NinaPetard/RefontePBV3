/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.webservice;

import fr.nina.service.ServiceConseiller;
import static fr.nina.service.ServiceConseiller.listerClientsConseiller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;


import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Nina et Robinson**/

/**
 * Codage de la classe servant à produire un JSON suite à la consommation d'un id conseiller.
 */

@Path("conseiller")
public class WebServiceListerClients{

    @POST
    @Path("/listeclients")
    @Consumes(MediaType.TEXT_PLAIN)    
    @Produces(MediaType.TEXT_PLAIN)    
    public String sendCliData(String userIdCons) {
        String clijson ;
        Long idcons = Long.parseLong(userIdCons, 10);
        
        clijson = listerClientsConseiller(idcons);
        return clijson;
    }

}
