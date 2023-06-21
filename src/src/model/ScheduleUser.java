package model;
import java.io.Serializable;

public class ScheduleUser implements Serializable {
	private String user_name;
	private String password;
	private String email;
	private String pet_name;
	private int pet_id;
	private int done_cnt;
	private String last_login_date;
	private int login_days;
	private int coin_cnt;

	public ScheduleUser(String user_name, String password, String email, String pet_name, int pet_id, int done_cnt,
			String last_login_date, int login_days, int coin_cnt) {
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

	public ScheduleUser(String user_name, String pet_name, int pet_id, int done_cnt,
			String last_login_date, int login_days, int coin_cnt) {
		this.user_name = user_name;
		this.pet_name = pet_name;
		this.pet_id = pet_id;
		this.done_cnt = done_cnt;
		this.last_login_date = last_login_date;
		this.login_days = login_days;
		this.coin_cnt = coin_cnt;
	}

	public ScheduleUser() {
		super();
		this.user_name = "";
		this.password = "";
		this.email = "";
		this.pet_name = "";
		this.pet_id = 0;
		this.done_cnt = 0;
		this.last_login_date = "";
		this.login_days = 0;
		this.coin_cnt = 0;
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

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public int getDone_cnt() {
		return done_cnt;
	}

	public void setDone_cnt(int done_cnt) {
		this.done_cnt = done_cnt;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public int getLogin_days() {
		return login_days;
	}

	public void setLogin_days(int login_days) {
		this.login_days = login_days;
	}

	public int getCoin_cnt() {
		return coin_cnt;
	}

	public void setCoin_cnt(int coin_cnt) {
		this.coin_cnt = coin_cnt;
	}
}