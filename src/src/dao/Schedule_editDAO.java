package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;

public class Schedule_editDAO {

	//一旦
	public List<Schedule> select(Schedule param){
		Connection conn = null;
		List<Schedule> scheList = new ArrayList<Schedule>();

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_成沢/fcdb5", "sa", "");

			//SQL準備
			String sql = "select * from schedule where schedule_id = ? order by schedule_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL完成
			if(param.getSchedule_id() != 0) {
				pStmt.setInt(1, param.getSchedule_id());
			}else {
				pStmt.setInt(1, 0);
			}
			if(param.getUser_name() != null) {
				pStmt.setString(2,"%"+ param.getUser_name() +"%");
			}else {
				pStmt.setString(2,"%");
			}
			if(param.getSchedule_name() != null) {
				pStmt.setString(3,"%"+ param.getSchedule_name() +"%");
			}else {
				pStmt.setString(3,"%");
			}
			if(param.getStart_date() != null) {
				pStmt.setString(4,"%"+ param.getStart_date() +"%");
			}else {
				pStmt.setString(4,"%");
			}
			if(param.getStart_time() != null) {
				pStmt.setString(5,"%"+ param.getStart_time() +"%");
			}else {
				pStmt.setString(5,"%");
			}
			if(param.getFinish_date() != null) {
				pStmt.setString(6,"%"+ param.getFinish_date() +"%");
			}else {
				pStmt.setString(6,"%");
			}
			if(param.getFinish_time() != null) {
				pStmt.setString(7,"%"+ param.getFinish_time() +"%");
			}else {
				pStmt.setString(7,"%");
			}
			if(param.getColor_id() != 0) {
				pStmt.setInt(8, param.getColor_id());
			}else {
				pStmt.setInt(8,0);
			}
			if(param.getContent() != null) {
				pStmt.setString(9,"%"+ param.getContent() +"%");
			}else {
				pStmt.setString(9,"%");
			}

			//実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Schedule sche = new Schedule(
						rs.getInt("schedule_id"),
						rs. getString("user_name"),
						rs.getString("schedule_name"),
						rs.getString("start_date"),
						rs.getString("start_time"),
						rs.getString("finish_date"),
						rs.getString("finish_time"),
						rs.getInt("color_id"),
						rs.getString("content")
						);
				scheList.add(sche);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			scheList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			scheList = null;
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					scheList = null;
				}
			}
		}
		return scheList;
	}


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
			String sql = "update schedule set schedule_name=?,start_date=?,start_time=?,finish_date=?,finish_time=?,color_id=?,content=? where user_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLの完成
			if(dule.getSchedule_name() != null && !dule.getSchedule_name().equals("")) {
				pStmt.setString(1, dule.getSchedule_name());
			}else {
				pStmt.setString(1,null);
			}
			if(dule.getStart_date() != null && !dule.getStart_date().equals("")) {
				pStmt.setString(2, dule.getStart_date());
			}else {
				pStmt.setString(2,null);
			}
			if(dule.getStart_time() != null && !dule.getStart_time().equals("")) {
				pStmt.setString(3, dule.getStart_time());
			}else {
				pStmt.setString(3,null);
			}
			if(dule.getFinish_date() != null && !dule.getFinish_date().equals("")) {
				pStmt.setString(4, dule.getFinish_date());
			}else {
				pStmt.setString(4,null);
			}
			if(dule.getFinish_time() != null && !dule.getFinish_time().equals("")) {
				pStmt.setString(5, dule.getFinish_time());
			}else {
				pStmt.setString(5,null);
			}
			if(dule.getColor_id() != 0) {
				pStmt.setInt(6, dule.getColor_id());
			}else {
				pStmt.setInt(6,0);
			}
			if(dule.getContent() != null && !dule.getContent().equals("")) {
				pStmt.setString(7, dule.getContent());
			}else {
				pStmt.setString(7,null);
			}
				pStmt.setString(8, dule.getUser_name());

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
