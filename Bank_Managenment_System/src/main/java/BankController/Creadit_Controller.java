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
import Bank_bo.Operatiobo;

/**
 * Servlet implementation class Creadit_Controller
 */
@WebServlet("/Creadit_Controller")
public class Creadit_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Creadit_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
		String camount=request.getParameter("camount");
		String Acc_no=request.getParameter("Acc_no");
		
		Operatiobo ob=new Operatiobo();
		ob.setAcc_no(Acc_no);
		ob.setCamount(camount);
		
		int status=Bank_dao.creadit(ob);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("CheckBalance.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("Something went wrong.....!");
		}
		
		
	}

}
