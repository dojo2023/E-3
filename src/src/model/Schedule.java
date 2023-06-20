package model;
import java.io.Serializable;

public class Schedule implements Serializable {
	private int schedule_id;
	private String user_name;
	private String schedule_name;
	private String start_date;
	private String start_time;
	private String finish_date;
	private String finish_time;
	private int color_id;
	private String content;
	private String color_code;
	private String start_hour;
	private String finish_hour;

	public Schedule(int schedule_id, String user_name, String schedule_name, String start_date, String start_time, String finish_date, String finish_time, int color_id, String content) {
		this.schedule_id = schedule_id;
		this.user_name = user_name;
		this.schedule_name = schedule_name;
		this.start_date = start_date;
		this.start_time = start_time;
		this.finish_date = finish_date;
		this.finish_time = finish_time;
		this.color_id = color_id;
		this.content = content;
	}

	public Schedule(int schedule_id, String user_name, String schedule_name, String start_date, String start_time, String finish_date, String finish_time, String color_code, String content) {
		this.schedule_id = schedule_id;
		this.user_name = user_name;
		this.schedule_name = schedule_name;
		this.start_date = start_date;
		this.start_time = start_time;
		this.finish_date = finish_date;
		this.finish_time = finish_time;
		this.color_code = color_code;
		this.content = content;
	}

	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
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

	public String getColor_code() {
		return color_code;
	}
	public void setColor_code(String color_code) {
		this.color_code = color_code;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getStart_hour() {
		return start_hour;
	}
	public void setStart_hour(String start_hour) {
		this.start_hour = start_hour;
	}

	public String getFinish_hour() {
		return finish_hour;
	}
	public void setFinish_hour(String finish_hour) {
		this.finish_hour = finish_hour;
	}
}
