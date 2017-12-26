package proxibanque_V2.authentification;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import proxibanque_V2.Service.Service_Client;

/**
 * Servlet implementation class ServletModif
 * 
 * Edit a clients info based on information given in a form
 */
@WebServlet("/ServletModif")
public class ServletModif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModif() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int idclient = Integer.parseInt(request.getParameter("idclient"));
		String replace = request.getParameter("replace");
		String info = request.getParameter("info");

		Service_Client service_client1 = new Service_Client();
		
		boolean valeur = service_client1.verifIdClient(idclient);
		
		RequestDispatcher dispatcher;
		
		if (valeur==true) {
			
			System.out.println(" Dans le cas true valeur = " + valeur);
		
		service_client1.changerInfoClient(info, replace, idclient);
		
		String s = "la mise à jour a été effectuée";
		
		request.setAttribute("message", s);
		
		dispatcher = request.getRequestDispatcher("ServletPrintClients");
		
		
		}else {
			
			System.out.println("Dans le cas false valeur = " + valeur);
			
			String s = "le client n'existe pas";
			
			request.setAttribute("message",s);
			
			dispatcher = request.getRequestDispatcher("Erreur.jsp");
			
		}

		dispatcher.forward(request, response);
	}

}
