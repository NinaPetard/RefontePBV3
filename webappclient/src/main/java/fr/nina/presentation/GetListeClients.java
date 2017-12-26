
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


@WebServlet(urlPatterns = "/GetListeClients")

public class GetListeClients extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            
            String login = request.getParameter("loginuser");
            ClientListeConseiller cls = new ClientListeConseiller();
            String responseService = cls.sendCliData(login);
            
            ObjectMapper mapper = new ObjectMapper();
            
        ArrayList<fr.nina.domaineclient.Client> clients = mapper.readValue(responseService, mapper.getTypeFactory().constructCollectionType(ArrayList.class, fr.nina.domaineclient.Client.class));           
            
            RequestDispatcher dispatcher;            
            HttpSession session = request.getSession();   
            session.setAttribute("json", responseService);
            session.setAttribute("clients", clients);
            
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