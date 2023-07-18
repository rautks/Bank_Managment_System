package Bank_Dao;

import java.sql.*;


import com.mysql.cj.xdevapi.AddStatement;

import Bank_bo.Bankbo;
import Bank_bo.Operatiobo;

public class Bank_dao
{
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bankmanagenment";
			String uname="root";
			String upass="root";
			
			con=DriverManager.getConnection(url,uname,upass);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return con;
	}
	public static String checkbalance(Bankbo bb)
	{
		String status=null;
		
		Connection con=Bank_dao.getConnection();
		try
		{
			String sql="select Accbalance from signin where Cpwd=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, bb.getCPwd());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				status=rs.getString(1);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return status;
	}
	
	public static boolean signin(String Acc_no, String Cpwd)
	{
		boolean status=false;
		
		Connection con=Bank_dao.getConnection();
		try
		{
			String sql="select * from signin where Acc_no=? and Cpwd=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, Acc_no);
			ps.setString(2, Cpwd);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	public static int insert(Bankbo bb)
	{
		int status=0;
			Connection con=Bank_dao.getConnection();
			try
			{
				String sql="insert into signin(Acc_no,Cname,Ccity,Accbalance,Cpwd) values(?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, bb.getAcc_no());
				ps.setString(2, bb.getCname());
				ps.setString(3, bb.getCcity());
				ps.setString(4, bb.getAccbalance());
				ps.setString(5, bb.getCPwd());
				
				status=ps.executeUpdate();
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		return status;
	}
	public static int diposite(Operatiobo ob)
	{
		int status=0;
		
		Connection con=Bank_dao.getConnection();
		try
		{
			
			
			String acc_no=ob.getAcc_no();
			String q="select Accbalance from signin where Acc_no=";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q+acc_no);
			int d_amo=Integer.parseInt(ob.getDamount());
			int av_bal=0,dip=0;
			
			while(rs.next())
			{
					av_bal=Integer.parseInt(rs.getString(1));
				
				dip=av_bal-d_amo;
			}
			
			String av_ba=String.valueOf(dip);
			
			String sql="update signin set Accbalance=? where Acc_no=?";
			
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, av_ba);
				ps.setString(2, ob.getAcc_no());
				
				status=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	public static int creadit(Operatiobo ob)
	{
		int status=0;
		Connection con=Bank_dao.getConnection();
		try
		{
		
			String Acc_no=ob.getAcc_no();
			String q="Select Accbalance from signin where Acc_no=";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q+Acc_no);
			int camount=Integer.parseInt(ob.getCamount());
			int av_bal=0;
			int creadit=0;
			while(rs.next())
			{
				av_bal=Integer.parseInt(rs.getString(1));
				creadit=av_bal+camount;
				
			}
			String ucreadit=String.valueOf(creadit);
			String sql="update signin set Accbalance=? where Acc_no=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, ucreadit);
			ps.setString(2, Acc_no);
			
			status=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return status;
	}
}
