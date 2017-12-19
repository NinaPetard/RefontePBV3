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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebServlet(urlPatterns = {"/GetListeClients"})

public class GetListeClients extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String login = request.getParameter("loginuser");
            System.out.println(login);
            Client client = ClientBuilder.newClient();

            WebTarget webTarget = client.target("http://localhost:8081/webservice/proxapi/");
            WebTarget resourceWebTarget = webTarget.path("conseiller");
            WebTarget getobject = resourceWebTarget.path("listeclients");

            System.out.println(getobject.getUri());
            Invocation.Builder invocationBuilder = getobject.request();

            //Appel de la méthode post : envoi de l'objet objetAEnvoyer, et on déclare que c'est un json.
            Response responseb = invocationBuilder.post(Entity.entity(login, MediaType.TEXT_PLAIN));
            System.out.println("c");

            if (responseb.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + responseb.getStatus());
            }
            String responseText = invocationBuilder.post(Entity.entity(login, MediaType.TEXT_PLAIN), String.class);
            
            
            ObjectMapper mapper = new ObjectMapper();
            
        ArrayList<fr.nina.domaineclient.Client> clients = mapper.readValue(responseText, mapper.getTypeFactory().constructCollectionType(ArrayList.class, fr.nina.domaineclient.Client.class));           
            
            RequestDispatcher dispatcher;            
            HttpSession maSession = request.getSession();   
            maSession.setAttribute("json", responseText);
            maSession.setAttribute("clients", clients);
            dispatcher = request.getRequestDispatcher("conseiller/AccueilConseiller.jsp");
            dispatcher.forward(request, response);

        } catch (IOException ex) {
            Logger.getLogger(GetListeClients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}