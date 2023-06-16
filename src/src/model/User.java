package model;
import java.io.Serializable;

public class User implements Serializable {
	private String user_name;
	private String password;
	private String email;
	private String pet_name;
	private String pet_id;
	private String done_cnt;
	private String last_login_date;
	private String login_days;
	private String coin_cnt;

	public User(String user_name, String password, String email, String pet_name, String pet_id, String done_cnt,
			String last_login_date, String login_days, String coin_cnt) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.pet_name = pet_name;
		this.pet_id = pet_id;
		this.done_cnt = done_cnt;
		this.last_login_date = last_login_date;
		this.login_days = login_days;
		this.coin_cnt = coin_cnt;
	}

	public User() {
		super();
		this.user_name = "";
		this.password = "";
		this.email = "";
		this.pet_name = "";
		this.pet_id = "";
		this.done_cnt = "";
		this.last_login_date = "";
		this.login_days = "";
		this.coin_cnt = "";
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	public String getPet_id() {
		return pet_id;
	}

	public void setPet_id(String pet_id) {
		this.pet_id = pet_id;
	}

	public String getDone_cnt() {
		return done_cnt;
	}

	public void setDone_cnt(String done_cnt) {
		this.done_cnt = done_cnt;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getLogin_days() {
		return login_days;
	}

	public void setLogin_days(String login_days) {
		this.login_days = login_days;
	}

	public String getCoin_cnt() {
		return coin_cnt;
	}

	public void setCoin_cnt(String coin_cnt) {
		this.coin_cnt = coin_cnt;
	}
}