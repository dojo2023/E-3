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
			String sql = "select * from schedule;";
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

	//petテーブルから
}
