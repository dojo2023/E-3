package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Closet;
import model.Pet;

public class Pet_homeDAO {


	public List<Pet> selectpet(){

		Connection conn = null;
		List<Pet> petList = new ArrayList<Pet>();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// SQL文を準備する
			String sql = "select  pet_img_id,pet_img_path from pet where pet_id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, 1);

			/*if (pet.getPet_id() != null) {
				pStmt.setString(1, pet.getPet_id());
				}else {
					pStmt.setInt(1, 1);
				}*/
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Pet petimg = new Pet(
	            rs.getString("pet_img_id"),
	            rs.getString("pet_img_path")
	            );
	            petList.add(petimg);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			petList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			petList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					petList = null;
				}
			}
		}

		// 結果を返す
		return petList;
	}



	public List<Closet> selectcloset(String user_name){

	Connection conn = null;
	List<Closet> closetList = new ArrayList<Closet>();


	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

		// SQL文を準備する
		String sql = "select closet.closet_img_id, closet.closet_kind_id, gacha.closet_path,closet.last_closet from closet inner join gacha on closet.closet_img_id = gacha.closet_img_id where user_name = ?";


		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, user_name);

		/*if (pet.getPet_id() != null) {
			pStmt.setString(1, pet.getPet_id());
			}else {
				pStmt.setInt(1, 1);
			}*/
		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
		    Closet closetimg = new Closet(

            rs.getString("closet_img_id"),
            rs.getInt("closet_kind_id"),
            rs.getString("closet_path"),
            rs.getBoolean("last_closet")

            );
            closetList.add(closetimg);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		closetList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		closetList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				closetList = null;
			}
		}
	}

	// 結果を返す
	return closetList;
}
}






