package proxibanque_V2.authentification;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proxibanque_V2.Service.Service_Conseiller;
import proxibanque_V2.dao.DAO_Conseiller;
import proxibanque_V2.metier.Conseiller;

/**
 * Checks if the person connecting is in the databse before giving access to the welcome page
 * @author adminl
 *
 */

@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAuth() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		
		String login = request.getParameter("loginuser");
		String pwd = request.getParameter("mdpuser");	
		
		
		Service_Conseiller sc = new Service_Conseiller();
		boolean identified = sc.demanderconnexion(login, pwd);
		
		HttpSession session = request.getSession();		
		
		RequestDispatcher dispatcher;
		
		if (identified) {
			DAO_Conseiller dc = new DAO_Conseiller();		
			Conseiller user = dc.getConseillerwId(login);			
			session.setAttribute("conseiller", user);
			dispatcher = request.getRequestDispatcher("ServletPrintClients");
			
			
		} else {
			request.setAttribute("error","Nom d'utilisateur ou mot de passe incorrect, veuillez réessayer.");
			dispatcher = request.getRequestDispatcher("Erreur.jsp");
			dispatcher.include(request, response);
		}
		dispatcher.forward(request, response);
		}		
		
	}


