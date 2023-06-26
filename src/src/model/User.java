package model;
import java.io.Serializable;

public class User implements Serializable {
	private String user_name;
	private String pet_name;
	private int pet_id;
	private int coin_cnt;

	public User(String user_name, String pet_name, int pet_id, int coin_cnt) {
		super();
		this.user_name = user_name;
		this.pet_name = pet_name;
		this.pet_id = pet_id;
		this.coin_cnt = coin_cnt;
	}

	public User() {
		super();
		this.user_name = "";
		this.pet_name = "";
		this.pet_id = 0;
		this.coin_cnt = 0;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public int getCoin_cnt() {
		return coin_cnt;
	}

	public void setCoin_cnt(int coin_cnt) {
		this.coin_cnt = coin_cnt;
	}
}