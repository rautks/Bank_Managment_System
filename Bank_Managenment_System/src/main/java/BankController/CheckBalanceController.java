package BankController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bank_Dao.Bank_dao;
import Bank_bo.Bankbo;

/**
 * Servlet implementation class CheckBalanceController
 */
@WebServlet("/CheckBalanceController")
public class CheckBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBalanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");
			
			PrintWriter pw=response.getWriter();
			

			//String acc_no=request.getParameter("Acc_no");
			String pass=request.getParameter("Cpwd");
			

			Bankbo bb= new Bankbo();
			
			bb.setCPwd(pass);
			pw.print("<link rel=stylesheet type=text/css href=css/result.css>");

			 pw.print("<center>");
			    pw.print("<h2>Result_Page</h2>");
			    
			    pw.print("YOUR BALANCE is : ");
				
				pw.print(Bank_dao.checkbalance(bb));
				
			    
			    pw.print("</center>");
			
	}

}
