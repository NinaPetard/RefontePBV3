package proxibanque_V2.authentification;

/**
 * Performs a money transfer based on a form filled by the advisor
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proxibanque_V2.Service.Service_Virement;
import proxibanque_V2.dao.DAO_Virement;
import proxibanque_V2.metier.Conseiller;



@WebServlet("/ServletVirement")
public class ServletVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletVirement() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		request.setAttribute("message",null);
		int comptedebit = Integer.parseInt(request.getParameter("comptedebit"));
		int comptecredit = Integer.parseInt(request.getParameter("comptecredit"));
		Double montant = Double.parseDouble(request.getParameter("montant"));
		
		HttpSession session = request.getSession();	
		
		Conseiller conseiller = (Conseiller) session.getAttribute("conseiller");

		System.out.println(comptedebit);
		System.out.println(comptecredit);
		Service_Virement sv = new Service_Virement();
		String etat = "";
		etat = sv.checkerVirement(comptedebit, comptecredit, montant, conseiller);

		


		if (etat.equals("")) {
			DAO_Virement daoV = new DAO_Virement();
			etat = daoV.faireVirement(comptedebit, comptecredit, montant);
			session.setAttribute("message", etat);
			dispatcher = request.getRequestDispatcher("Virement.jsp");
			
		} 
		else{ 
			System.out.println("ETAT:" + etat);
			request.setAttribute("message", etat);
			dispatcher = request.getRequestDispatcher("Virement.jsp");
			
		}
		
		dispatcher.forward(request, response);

		doGet(request, response);
	}

}
