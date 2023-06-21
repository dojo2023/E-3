package model;
import java.io.Serializable;

public class Closet implements Serializable {
	private int closet_img_id;
	private int closet_kind_id;
	private String closet_img_path;

	public Closet(int closet_img_id, int closet_kind_id, String closet_img_path) {
		this.closet_img_id = closet_img_id;
		this.closet_kind_id = closet_kind_id;
		this.closet_img_path = closet_img_path;
	}

	public int getCloset_img_id() {
		return closet_img_id;
	}
	public void setCloset_img_id(int closet_img_id) {
		this.closet_img_id = closet_img_id;
	}


	public int getCloset_kind_id() {
		return closet_kind_id;
	}
	public void setCloset_kind_id(int closet_kind_id) {
		this.closet_kind_id = closet_kind_id;
	}

	public String getCloset_img_path() {
		return closet_img_path;
	}
	public void setCloset_img_path(String closet_img_path) {
		this.closet_img_path = closet_img_path;
	}
}
