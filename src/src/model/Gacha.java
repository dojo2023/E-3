package model;
import java.io.Serializable;

public class Gacha implements Serializable {
	private int pet_id;
	private String closet_img_id;
	private String closet_img_path;
	private String closet_name;
	private int closet_kind_id;
	private int rarity;

	public Gacha(int pet_id,String closet_img_id,String closet_img_path,String closet_name,int closet_kind_id,int rarity) {
		this.pet_id = pet_id;
		this.closet_img_id = closet_img_id;
		this.closet_img_path = closet_img_path;
		this.closet_name = closet_name;
		this.closet_kind_id = closet_kind_id;
		this.rarity = rarity;
	}
	public int getPet_id() {
		return pet_id;
	}
	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}
	public String getCloset_img_id() {
		return closet_img_id;
	}
	public void setCloset_img_id(String closet_img_id) {
		this.closet_img_id = closet_img_id;
	}
	public String getCloset_img_path() {
		return closet_img_path;
	}
	public void setCloset_img_path(String closet_img_path) {
		this.closet_img_path = closet_img_path;
	}
	public String getCloset_name() {
		return closet_name;
	}
	public void setCloset_name(String closet_name) {
		this.closet_name = closet_name;
	}
	public int getCloset_kind_id() {
		return closet_kind_id;
	}
	public void setCloset_kind_id(int closet_kind_id) {
		this.closet_kind_id = closet_kind_id;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
}
