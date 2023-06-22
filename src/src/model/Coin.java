package model;
import java.io.Serializable;

public class Coin implements Serializable {
	private int coinnum;
	private boolean coinresult;
	private String event_name;

	public Coin(int coinnum, boolean coinresult, String event_name) {
		this.coinnum = coinnum;
		this.coinresult = coinresult;
		this.event_name = event_name;
	}

	public int getCoinnum() {
		return coinnum;
	}

	public void setCoinnum(int coinnum) {
		this.coinnum = coinnum;
	}

	public boolean getCoinresult() {
		return coinresult;
	}

	public void setCoinresule(boolean coinresult) {
		this.coinresult = coinresult;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
}