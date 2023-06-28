package model;
import java.io.Serializable;

public class Message implements Serializable {
	private String message_id;
	private int pet_id;
	private String message_content;

	public Message(String message_id, int pet_id, String message_content) {
		this.message_id = message_id;
		this.pet_id = pet_id;
		this.message_content = message_content;
	}

	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public int getPet_id() {
		return pet_id;
	}
	public void setPet_img_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
}
