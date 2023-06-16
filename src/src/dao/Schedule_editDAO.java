package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Schedule;

public class Schedule_editDAO {
	//引数scheで指定されたレコードを編集し、成功ならtrueを返す
	public boolean update(Schedule dule) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_成沢/fcdb5", "sa", "");

			//SQLの準備
			String sql = "update schedule set schedule_name=?,start_date=?,start_time=?,finish_date=?,finish_time=?,color_id=?,content=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLの完成
			if(dule.getSchedule_name() != null && dule.getSchedule_name().equals("")) {
				pStmt.setString(1, dule.getSchedule_name());
			}else {
				pStmt.setString(1,null);
			}
			if(dule.getStart_date() != null && dule.getStart_date().equals("")) {
				pStmt.setString(2, dule.getStart_date());
			}else {
				pStmt.setString(2,null);
			}
			if(dule.getStart_time() != null && dule.getStart_time().equals("")) {
				pStmt.setString(3, dule.getStart_time());
			}else {
				pStmt.setString(3,null);
			}
			if(dule.getFinish_date() != null && dule.getFinish_date().equals("")) {
				pStmt.setNString(4, dule.getFinish_date());
			}else {
				pStmt.setString(4,null);
			}
			if(dule.getFinish_time() != null && dule.getFinish_time().equals("")) {
				pStmt.setString(5, dule.getFinish_time());
			}else {
				pStmt.setString(5,null);
			}
			if(dule.getColor_id() != 0) {
				pStmt.setInt(6, dule.getColor_id());
			}else {
				pStmt.setInt(6,0);
			}
			if(dule.getContent() != null && dule.getContent().equals("")) {
				pStmt.setString(7, dule.getContent());
			}else {
				pStmt.setString(7,null);
			}
			pStmt.setString(8, null);

			//SQL文の実行
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
}
