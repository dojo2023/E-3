package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Schedule;

public class Schedule_registDAO {

	//引数scheで指定されたレコードを登録し、成功ならtrueを返す
	public boolean insert(Schedule sche) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_成沢/fcdb5", "sa", "");

			//SQLの準備
			String sql = "insert into schedule(user_name,schedule_name,start_date,start_time,finish_date,finish_time,color_id,content) values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLの完成
			if(sche.getUser_name() != null && sche.getUser_name().equals("")) {
				pStmt.setString(1, sche.getUser_name());
			}else {
				pStmt.setString(1,null);
			}
			if(sche.getSchedule_name() != null && sche.getSchedule_name().equals("")) {
				pStmt.setString(2, sche.getSchedule_name());
			}else {
				pStmt.setString(2,null);
			}
			if(sche.getStart_date() != null && sche.getStart_date().equals("")) {
				pStmt.setString(3, sche.getStart_date());
			}else {
				pStmt.setString(3,null);
			}
			if(sche.getStart_time() != null && sche.getStart_time().equals("")) {
				pStmt.setString(4, sche.getStart_time());
			}else {
				pStmt.setString(4,null);
			}
			if(sche.getFinish_date() != null && sche.getFinish_date().equals("")) {
				pStmt.setNString(5, sche.getFinish_date());
			}else {
				pStmt.setString(5,null);
			}
			if(sche.getFinish_time() != null && sche.getFinish_time().equals("")) {
				pStmt.setString(6, sche.getFinish_time());
			}else {
				pStmt.setString(6,null);
			}
			if(sche.getColor_id() != 0) {
				pStmt.setInt(7, sche.getColor_id());
			}else {
				pStmt.setInt(7,0);
			}
			if(sche.getContent() != null && sche.getContent().equals("")) {
				pStmt.setString(8, sche.getContent());
			}else {
				pStmt.setString(8,null);
			}
			//SQL文を実行
			if(pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//DB切断
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//結果を返す
		return result;
	}

	public List<Schedule> select(Schedule regist) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
