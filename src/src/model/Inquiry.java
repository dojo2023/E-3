package model;
import java.io.Serializable;

public class Inquiry implements Serializable {
	//private int ii; //お問い合わせID
	private String un;	// ユーザーネーム
	private String em; //メールアドレス
	private String co; //お問い合わせ内容

	public Inquiry(String un, String em, String co) {
		//this.ii = ii;
		this.un = un;
		this.em = em;
		this.co = co;
	}

	public Inquiry() {
		//this.ii = 0;
		this.un = "";
		this.em = "";
		this.co = "";
	}
/*
	public int getIi() {
		return ii;
	}

	public void setIi(int ii) {
		this.ii = ii;
	}
*/

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getEm() {
		return em;
	}

	public void setEm(String em) {
		this.em = em;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}
}
