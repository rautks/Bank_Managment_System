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
 * Servlet implementation class DipositeController
 */
@WebServlet("/DipositeController")
public class DipositeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DipositeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		
		String damout=request.getParameter("damount");
		String Acc_no=request.getParameter("Acc_no");
		
		Operatiobo ob=new Operatiobo();
		ob.setDamount(damout);
		ob.setAcc_no(Acc_no);
		
		int status=Bank_dao.diposite(ob);
		if(status>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("CheckBalance.html");
			rd.forward(request, response);
		}
		else
		{
			pw.print("Some thing error...!");
		}
	}

}
