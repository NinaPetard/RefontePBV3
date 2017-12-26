package proxibanque_V2.authentification;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxibanque_V2.Service.Affichages;

/**
 * Servlet implementation class AfficherComptes
 * 
 * Prints the accounts of the client given in the form.
 */
@WebServlet("/AfficherComptes")
public class AfficherComptes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherComptes() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		String idclient = request.getParameter("client");
		int idclienti = Integer.parseInt(idclient);
		
		

		Affichages af = new Affichages();
		ArrayList<String> comptes = af.txtCpteCli(idclienti);
		
		request.setAttribute("comptes", comptes);

		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("Comptes.jsp");
		dispatcher.include(request, response);

	}

}
