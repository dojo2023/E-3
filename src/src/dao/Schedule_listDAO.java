package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;

public class Schedule_listDAO {

//===========================================================================================

	//スケジュールテーブルからスケジュールをすべて取得する
	public List<Schedule> select(){
		Connection conn = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "select * from schedule";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Schedule list = new Schedule(
				rs.getString("user_name"),
				rs.getString("schedule_name"),
				rs.getString("start_date"),
				rs.getString("start_time"),
				rs.getString("finish_date"),
				rs.getString("finish_time"),
				rs.getInt("color_id"),
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

	//スケジュールテーブルからスケジュールをすべて取得する
	public List<Schedule> selectcolor_code(){
		Connection conn = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "select user_name, schedule_name, start_date, start_time, finish_date, finish_time, color_code, content from schedule inner join schedule_color on schedule.color_id = schedule_color.color_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Schedule list = new Schedule(
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

	//引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String user_name, String schedule_name) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");

			// SQL文を準備する
			String sql = "delete from schedule where user_name=? and schedule_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_name);
			pStmt.setString(2, schedule_name);

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
}
