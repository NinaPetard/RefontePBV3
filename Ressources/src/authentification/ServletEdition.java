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

import proxibanque_V2.Service.Service_Client;
import proxibanque_V2.metier.Client;
import proxibanque_V2.metier.Conseiller;

/**
 * Servlet implementation class ServletEdition
 * 
 * Edits a client with the info given in a previous form
 */
@WebServlet("/ServletEdition")
public class ServletEdition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEdition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		
		ArrayList<Client> listeclient1 = new ArrayList<Client>();
		
		Service_Client serviceclient1 = new Service_Client();
		
		HttpSession session = request.getSession();
		
		Conseiller conseiller =  (Conseiller) session.getAttribute("conseiller") ;
		
		listeclient1 = serviceclient1.retournerArrayListClient(conseiller);
		
		HttpSession sessionedition = request.getSession();
		
		sessionedition.setAttribute("client", listeclient1);
		
		RequestDispatcher dispatcher;
		
		dispatcher = request.getRequestDispatcher("ModifierClient.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

}
