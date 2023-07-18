package BankController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bank_Dao.Bank_dao;
import Bank_bo.Bankbo;

/**
 * Servlet implementation class SignController
 */
@WebServlet("/SignController")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String RequestDispacture = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String Acc_no=request.getParameter("Acc_no");
		String Cname=request.getParameter("Cname");
		String Ccity=request.getParameter("Ccity");
		String Accbalance=request.getParameter("Accbalance");
		String pwd=request.getParameter("pwd");
		
		Bankbo bb=new Bankbo();
		
		bb.setAcc_no(Acc_no);
		bb.setCname(Cname);
		bb.setCcity(Ccity);
		bb.setAccbalance(Accbalance);
		bb.setCPwd(pwd);
		
		int status=Bank_dao.insert(bb);
	
		if(status>0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("signin.html");
			rd.include(request, response);
		}
		 
	}

}
