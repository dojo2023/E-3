package model;
import java.io.Serializable;

public class Signup implements Serializable {
	private String un;	// ユーザーネーム
	private String pw;	// パスワード
	private String em; //メールアドレス
	private String pn; //ペット名
	private int pi; //ペットの種類

	public Signup(String un, String pw, String em, String pn, int pi) {
		this.un = un;
		this.pw = pw;
		this.em = em;
		this.pn = pn;
		this.pi = pi;
	}

	public Signup() {
		this.un = "";
		this.pw = "";
		this.em = "";
		this.pn = "";
		this.pi = 0;
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

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}
}
