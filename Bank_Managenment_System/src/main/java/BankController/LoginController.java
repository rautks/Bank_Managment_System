package BankController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank_Dao.Bank_dao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String Acc_no=request.getParameter("acc_no");
		String pass=request.getParameter("pwd");
		
		
		
		if(Bank_dao.signin(Acc_no, pass))
		{
			RequestDispatcher rd=request.getRequestDispatcher("HomeController");
			rd.forward(request, response);
			pw.print("Zala login");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			pw.print("Barobrr check kr...");
		}
	}

}
