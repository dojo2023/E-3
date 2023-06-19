package test;

import java.util.List;

import dao.Schedule_editDAO;
import model.Schedule;

public class editTest {
	public static void main(String[] args) {
		Schedule_editDAO dao = new Schedule_editDAO();


	//編集テスト
	System.out.println("---------- update()のテスト ----------");
	Schedule edit = new Schedule("成沢","おでかけ","2023-05-01","14:00:00","2023-05-01","18:30:00",3, "急ぐ");
	if(dao.update(edit)) {
		System.out.println("更新成功！");
		List<Schedule> sche3 = dao.select(edit);
		for(Schedule sche : sche3) {
			System.out.println("user_name:" +sche.getUser_name());
			System.out.println("schedule_name:" +sche.getSchedule_name());
			System.out.println("start_date:" +sche.getStart_date());
			System.out.println("start_time:" +sche.getStart_time());
			System.out.println("finish_date:" +sche.getFinish_date());
			System.out.println("finish_time:" +sche.getFinish_time());
			System.out.println("color_id" +sche.getColor_id());
			System.out.println("content:" +sche.getContent());
		}
	}else {
		System.out.println("更新失敗！");
	}
  }
}
