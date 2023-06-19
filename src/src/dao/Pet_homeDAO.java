package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pet;

public class Pet_homeDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Pet_home> select(Pet_home param) {
		Connection conn = null;
		List<Pet_home> cardList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_飯泉/fcdb4", "sa", "");

			// SQL文を準備する
			String sql = "select * from Pet_home WHERE pet_img_id LIKE ? AND pet_id LIKE ? AND pet_img_path LIKE ? ORDER BY pet_img_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getpet_img_id() != null) {
				pStmt.setString(1, "%" + param.getpet_img_id() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getpet_img_id() != null) {
				pStmt.setString(2, "%" + param.get() +pet_img_id "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getAddress() != null) {
				pStmt.setString(3, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc card = new Bc(
				rs.getString("NUMBER"),
				rs.getString("COMPANY"),
				rs.getString("DEPARTMENT"),
				rs.getString("POSITION"),
				rs.getString("NAME"),
				rs.getString("ZIPCODE"),
				rs.getString("ADDRESS"),
				rs.getString("PHONE"),
				rs.getString("FAX"),
				rs.getString("EMAIL"),
				rs.getString("REMARKS")

				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	public List<Pet> selectpet(Pet pet){

		Connection conn = null;
		List<Pet> petList = new ArrayList<Pet>();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_飯泉/fcdb4", "sa", "");

			// SQL文を準備する
			String sql = "select  pet_img_id,pet_img_path from pet where pet_id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (pet.getPet_id.getNumber() != null) {
				pStmt.setInt(1, pet.getPet_id())
				}else {
					pStmt.setInt(1, 1);
				}
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
}






