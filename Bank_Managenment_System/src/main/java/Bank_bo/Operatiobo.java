package Bank_bo;

public class Operatiobo
{
	private String damount;
	private String Acc_no;
	private String camount;
	public String getCamount() {
		return camount;
	}
	public void setCamount(String camount) {
		this.camount = camount;
	}
	public String getDamount() {
		return damount;
	}
	public void setDamount(String damount) {
		this.damount = damount;
	}
	public String getAcc_no() {
		return Acc_no;
	}
	public void setAcc_no(String acc_no) {
		Acc_no = acc_no;
	}
	public Operatiobo(String damount, String acc_no, String camount) {
		super();
		this.damount = damount;
		Acc_no = acc_no;
		this.camount = camount;
	}
	public Operatiobo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Operatiobo [damount=" + damount + ", Acc_no=" + Acc_no + ", camount=" + camount + "]";
	}
	
	
	
}
