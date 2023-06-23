package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Gacha;

public class GachaDAO{
	public Gacha selectgacha(String gacharesult){
		Connection conn = null;
		Gacha gachadata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_岩田/fcdb3", "sa", "");

			// SQL文を準備する
			String sql = "select pet_id,closet_img_id,closet_img_path,closet_name,closet_kind_id,rarity from gacha where closet_img_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, gacharesult);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
			    gachadata = new Gacha(
			    	rs.getInt("pet_id"),
			    	rs.getString("closet_img_id"),
			    	rs.getString("closet_img_path"),
			    	rs.getString("closet_name"),
			    	rs.getInt("closet_kind_id"),
			    	rs.getInt("rarity"));
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
			return gachadata;
	}

	//引数scheで指定されたレコードを登録し、成功ならtrueを返す
	public boolean insertcloset(Gacha gachadata, String user_name) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_成沢/fcdb5", "sa", "");

			//SQLの準備
			String sql = "insert into closet(user_name, closet_kind_id, closet_img_id) values(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQLの完成
			if(user_name != null && !user_name.equals("")) {
				pStmt.setString(1, user_name);
			}else {
				pStmt.setString(1,null);
			}
			if(gachadata.getCloset_kind_id() != 0) {
				pStmt.setInt(2, gachadata.getCloset_kind_id());
			}else {
				pStmt.setInt(2, 0);
			}
			if(gachadata.getCloset_img_id() != null && !gachadata.getCloset_img_id().equals("")) {
				pStmt.setString(3, gachadata.getCloset_img_id());
			}else {
				pStmt.setString(3,null);
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
}