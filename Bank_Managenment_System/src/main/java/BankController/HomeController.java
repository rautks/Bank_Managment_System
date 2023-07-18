package BankController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/update.css\">");
		pw.print("<center>");
		pw.print("<h1>HOME CONTROLLER</h1>");
		pw.print("<form action=CheckBalance.html>");

		pw.print("<input type='submit' name='name' value='check_Balance'><br><br>");
		pw.print("</form>");
        
		pw.print("<form action='diposite.html'>");
		pw.print("<input type='submit' value='Diposit'><br><br>");

		pw.print("</form>");
		
		pw.print("<form action='creadit.html'>");
		pw.print("<input type='submit' value='Creadit'><br><br>");

		pw.print("</form>");
		
		pw.print("<form action='LogoutController' method='post'>");
		pw.print("<input type='submit' value='Logout'>");
	   pw.print("</form>"); 
		pw.print("</center>");
	}

}
