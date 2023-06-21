package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;
import model.ScheduleUser;

public class Schedule_listDAO {

//==============================================================================================

	//スケジュールテーブルからスケジュールをすべて取得する
	public List<Schedule> selectall(){
		Connection conn = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "select schedule_id, user_name, schedule_name, start_date, start_time, finish_date, finish_time, color_code, content from schedule inner join schedule_color on schedule.color_id = schedule_color.color_id order by start_time";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Schedule list = new Schedule(
				rs.getInt("schedule_id"),
				rs.getString("user_name"),
				rs.getString("schedule_name"),
				rs.getString("start_date"),
				rs.getString("start_time"),
				rs.getString("finish_date"),
				rs.getString("finish_time"),
				rs.getString("color_code"),
				rs.getString("content"));
				scheduleList.add(list);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			scheduleList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			scheduleList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					scheduleList = null;
				}
			}
		}

		// 結果を返す
		return scheduleList;
	}

//==============================================================================================
	//スケジュールテーブルからカレンダーで選択した日付のスケジュールを取得,Get時に今日のスケジュールを取得
		public List<Schedule> selectdate(String date){
			Connection conn = null;
			List<Schedule> scheduleList = new ArrayList<Schedule>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

				// SQL文を準備する
				String sql = "select schedule_id, user_name, schedule_name, start_date, start_time, finish_date, finish_time, color_code, content from schedule inner join schedule_color on schedule.color_id = schedule_color.color_id where start_date = ? order by start_time";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, date);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					Schedule list = new Schedule(
					rs.getInt("schedule_id"),
					rs.getString("user_name"),
					rs.getString("schedule_name"),
					rs.getString("start_date"),
					rs.getString("start_time"),
					rs.getString("finish_date"),
					rs.getString("finish_time"),
					rs.getString("color_code"),
					rs.getString("content"));
					scheduleList.add(list);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				scheduleList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				scheduleList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						scheduleList = null;
					}
				}
			}

			// 結果を返す
			return scheduleList;
		}

//==============================================================================================
	//ユーザテーブルからユーザ情報を取得
	public ScheduleUser selectuser(String user_name){
		Connection conn = null;
		ScheduleUser userdata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "select user_name, pet_name, pet_id, done_cnt, last_login_date, login_days, coin_cnt from user where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				userdata = new ScheduleUser(
				rs.getString("user_name"),
				rs.getString("pet_name"),
				rs.getInt("pet_id"),
				rs.getInt("done_cnt"),
				rs.getString("last_login_date"),
				rs.getInt("login_days"),
				rs.getInt("coin_cnt"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			userdata = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			userdata = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					userdata = null;
				}
			}
		}

		// 結果を返す
		return userdata;
	}


//==============================================================================================

	//引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int schedule_id) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "delete from schedule where schedule_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, schedule_id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

//==============================================================================================

}
