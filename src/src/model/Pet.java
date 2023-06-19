package model;
import java.io.Serializable;

public class Pet implements Serializable {
	private String pet_img_id;
	private String pet_img_path;

	public Pet(String pet_img_id, String pet_img_path) {
		this.pet_img_id = pet_img_id;
		this.pet_img_path = pet_img_path;
	}

	public String getPet_img_id() {
		return pet_img_id;
	}
	public void setPet_img_id(String pet_img_id) {
		this.pet_img_id = pet_img_id;
	}

	public String getPet_img_path() {
		return pet_img_path;
	}
	public void setPet_img_path(String pet_img_path) {
		this.pet_img_path = pet_img_path;
	}
}
