package model;

import java.io.Serializable;

public class Login_user implements Serializable {
	private String un;	// ログイン時のユーザーネーム

	public Login_user() {
		this(null);
	}

	public Login_user(String un) {
		this.un = un;
	}

	public String getUn() {
		return un;
	}

	public void setUsername(String un) {
		this.un = un;
	}
}
