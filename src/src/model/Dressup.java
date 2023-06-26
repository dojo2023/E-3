package model;
import java.io.Serializable;

public class Dressup implements Serializable {
	private String closet_img_id;
	private boolean last_closet;

	public Dressup(String closet_img_id, Boolean last_closet) {
		this.closet_img_id = closet_img_id;
		this.last_closet = last_closet;
	}

	public String getCloset_img_id() {
		return closet_img_id;
	}
	public void setCloset_img_id(String closet_img_id) {
		this.closet_img_id = closet_img_id;
	}

	public boolean getLast_closet() {
		return last_closet;
	}
	public void setLast_closet(boolean last_closet) {
		this.last_closet = last_closet;
	}
}
