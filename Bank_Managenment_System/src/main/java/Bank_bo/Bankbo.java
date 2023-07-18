package Bank_bo;

public class Bankbo
{
	private String Acc_no;
	private String Cname;
	private String Ccity;
	private String Accbalance;
	private String Cpwd;
	public String getAcc_no() {
		return Acc_no;
	}
	public void setAcc_no(String acc_no) {
		Acc_no = acc_no;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCcity() {
		return Ccity;
	}
	public void setCcity(String ccity) {
		Ccity = ccity;
	}
	public String getAccbalance() {
		return Accbalance;
	}
	public void setAccbalance(String accbalance) {
		Accbalance = accbalance;
	}
	public String getCPwd() {
		return Cpwd;
	}
	public void setCPwd(String Cpwd) {
		this.Cpwd = Cpwd;
	}
	@Override
	public String toString() {
		return "Bankbo [Acc_no=" + Acc_no + ", Cname=" + Cname + ", Ccity=" + Ccity + ", Accbalance=" + Accbalance
				+ ", Cpwd=" + Cpwd + "]";
	}
	public Bankbo(String acc_no, String cname, String ccity, String accbalance, String cpwd) {
		super();
		Acc_no = acc_no;
		Cname = cname;
		Ccity = ccity;
		Accbalance = accbalance;
		Cpwd = cpwd;
	}
	public Bankbo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
