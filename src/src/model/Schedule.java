package model;
import java.io.Serializable;

public class Schedule implements Serializable {
	private String user_name;
	private String schedule_name;
	private String start_date;
	private String start_time;
	private String finish_date;
	private String finish_time;
	private int color_id;
	private String content;

	public Schedule(String user_name, String schedule_name, String start_date, String start_time, String finish_date, String finish_time, int color_id, String content) {
		this.user_name = user_name;
		this.schedule_name = schedule_name;
		this.start_date = start_date;
		this.start_time = start_time;
		this.finish_date = finish_date;
		this.finish_time = finish_time;
		this.color_id = color_id;
		this.content = content;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}

	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(String finish_date) {
		this.finish_date = finish_date;
	}

	public String getFinish_time() {
		return finish_time;
	}
	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public int getColor_id() {
		return color_id;
	}
	public void setColor_id(int color_id) {
		this.color_id = color_id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
