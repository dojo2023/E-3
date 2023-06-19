package model;
import java.io.Serializable;

public class Login implements Serializable {
	private String un;	// ID
	private String pw;	// PW

	public Login(String un, String pw) {
		this.un = un;
		this.pw = pw;
	}

	public Login() {
		this.un = "";
		this.pw = "";
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
