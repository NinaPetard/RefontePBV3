package proxibanque_V2.authentification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proxibanque_V2.Service.Affichages;
import proxibanque_V2.metier.Client;


/**
 * Servlet implementation class ServletListeClientComptes
 * 
 * Prepares the list of client of the connected advisor.
 */
@WebServlet("/ServletListeClientComptes")
public class ServletListeClientComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeClientComptes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		 ArrayList<Client> clients = (ArrayList<Client>) session.getAttribute("clients");
			
			Affichages af = new Affichages();			
			HashMap<String, String> idnp = af.texteClients(clients);
System.out.println(idnp);
			session.setAttribute("inpClients", idnp);
			
			RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("Comptes.jsp");
			dispatcher.forward(request, response);	
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
