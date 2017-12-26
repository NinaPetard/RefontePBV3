package proxibanque_V2.authentification;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proxibanque_V2.Service.Affichages;
import proxibanque_V2.Service.Service_Conseiller;
import proxibanque_V2.metier.Client;
import proxibanque_V2.metier.Conseiller;

/**
 * Servlet implementation class ServletPrintClients
 * 
 * Prapres a list of information about all clients of the connected advisor.
 */
@WebServlet("/ServletPrintClients")
public class ServletPrintClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrintClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service_Conseiller sc = new Service_Conseiller();
		
		HttpSession session = request.getSession();		
			Conseiller conseiller = (Conseiller) session.getAttribute("conseiller");
		
			int idCons = conseiller.getIdConseiller();

			ArrayList<Client> clients = sc.demanderclients(idCons);			
			session.setAttribute("clients", clients);
			
			Affichages af = new Affichages();
			
			ArrayList<String> clientsT = af.tableauClients(clients);
			session.setAttribute("clientsT", clientsT);
			
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("Accueil_Conseiller.jsp");
			dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
