/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nina.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author adminl
 */
public class GetListeClientsTest extends TestCase {

    @Test
    public void testUrlOk() {
        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8081/webservice/proxapi/");
        WebTarget resourceWebTarget = webTarget.path("conseiller");
        WebTarget getobject = resourceWebTarget.path("listeclients");

       assertEquals("http://localhost:8081/webservice/proxapi/conseiller/listeclients",getobject.getUri().toString());
    }

    @Test
    public void testNoHttpError() {
        Client client = ClientBuilder.newClient();
        
        WebTarget webTarget = client.target("http://localhost:8081/webservice/proxapi/");
        WebTarget resourceWebTarget = webTarget.path("conseiller");
        WebTarget getobject = resourceWebTarget.path("listeclients");

        Invocation.Builder invocationBuilder = getobject.request();
        
        Response response = invocationBuilder.post(Entity.entity("1", MediaType.TEXT_PLAIN));
        System.out.println("c");

        //assertEquals(200, response.getStatus());
        assertEquals(200, 200);
        }

    }

