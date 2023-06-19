package test;

import java.util.List;

import dao.Schedule_registDAO;
import model.Schedule;

public class test {

	public static void main(String[] args) {
		Schedule_registDAO dao = new Schedule_registDAO();

		//selectのテスト
		System.out.println("---------- select()のテスト ----------");
		List<Schedule> sche1 = dao.select(new Schedule("ゆい","おでかけ","2023-05-01","14:00:00","2023-05-01","18:30:00",3, "急ぐ"));
		for(Schedule sche : sche1) {
			System.out.println("user_name:" +sche.getUser_name());
			System.out.println("schedule_name:" +sche.getSchedule_name());
			System.out.println("start_date:" + sche.getStart_date());
			System.out.println("start_time:" + sche.getStart_time());
			System.out.println("finish_date"+ sche.getFinish_date());
			System.out.println("finish_time" +sche.getFinish_time());
			System.out.println("color_id" + sche.getColor_id());
			System.out.println("content:" +sche.getContent());
			System.out.println();
		}

		//登録テスト
		System.out.println("---------- insert()のテスト ----------");
		Schedule regist = new Schedule("ゆい","おでかけ","2023-05-01","14:00:00","2023-05-01","18:30:00",3, "急ぐ");
		if(dao.insert(regist)) {
			System.out.println("登録成功！");
			List<Schedule> sche2 = dao.select(regist);
			for(Schedule sche : sche2) {
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
			System.out.println("登録失敗");
		}
	}
}
