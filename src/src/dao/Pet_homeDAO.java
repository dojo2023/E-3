package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Closet;
import model.Dressup;
import model.Message;
import model.Pet;
import model.User;

public class Pet_homeDAO {

//#--------------------------------------------------------------

	//ペットの種類からペットの画像を取得
	public List<Pet> selectpet(User userdata){

		Connection conn = null;
		List<Pet> petList = new ArrayList<Pet>();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// SQL文を準備する
			String sql = "select pet_img_id,pet_img_path from pet where pet_id = ?";


			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (userdata.getPet_id() != 0) {
				pStmt.setInt(1, userdata.getPet_id());
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

//#--------------------------------------------------------------
	//クローゼットにあるすべてのきせかえを取得
	public List<Closet> selectcloset(String user_name){

	Connection conn = null;
	List<Closet> closetList = new ArrayList<Closet>();


	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

		// SQL文を準備する
		String sql = "select closet.closet_img_id, closet.closet_kind_id, gacha.closet_img_path,closet.last_closet from closet inner join gacha on closet.closet_img_id = gacha.closet_img_id where user_name = ?";


		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, user_name);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
		    Closet closetimg = new Closet(

            rs.getString("closet_img_id"),
            rs.getInt("closet_kind_id"),
            rs.getString("closet_img_path"),
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


//#--------------------------------------------------------------
	//クローゼットにある依然来ていたきせかえを取得
	public List<Closet> selectlastcloset(String user_name){

	Connection conn = null;
	List<Closet> closetList = new ArrayList<Closet>();


	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

		// SQL文を準備する
		String sql = "select closet.closet_img_id, closet.closet_kind_id, gacha.closet_img_path,closet.last_closet from closet inner join gacha on closet.closet_img_id = gacha.closet_img_id where user_name = ? and last_closet = true";


		PreparedStatement pStmt = conn.prepareStatement(sql);
		pStmt.setString(1, user_name);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする
		while (rs.next()) {
		    Closet closetimg = new Closet(

            rs.getString("closet_img_id"),
            rs.getInt("closet_kind_id"),
            rs.getString("closet_img_path"),
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

//#--------------------------------------------------------------

	//ユーザテーブルからユーザ情報を取得
	public User selectuser(String user_name){
		Connection conn = null;
		User userdata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// SQL文を準備する
			String sql = "select user_name, pet_name, pet_id, coin_cnt from user where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				userdata = new User(
				rs.getString("user_name"),
				rs.getString("pet_name"),
				rs.getInt("pet_id"),
				rs.getInt("coin_cnt")
				);
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

//#--------------------------------------------------------------

	//ペットの種類からメッセージを取得
	public List<Message> selectmessage(User userdata){

		Connection conn = null;
		List<Message> messageList = new ArrayList<Message>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// SQL文を準備する
			String sql = "select message_id, pet_id, message_content from message where pet_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			if (userdata.getPet_id() != 0) {
				pStmt.setInt(1, userdata.getPet_id());
				}else {
					pStmt.setInt(1, 1);
				}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Message messageimg = new Message(
	            rs.getString("message_id"),
	            rs.getInt("pet_id"),
	            rs.getString("message_content")
	            );
	            messageList.add(messageimg);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			messageList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			messageList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					messageList = null;
				}
			}
		}

		// 結果を返す
		return messageList;
	}

//#--------------------------------------------------------------

	//クローゼットテーブルからきせかえ画像ID,最終きせかえ情報を取得
	public Dressup selectcl(String closet_img_id){
		Connection conn = null;
		Dressup closetdata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// SQL文を準備する
			String selectcl = "select last_closet from closet where closet_img_id = ?";
			PreparedStatement selectpStmt_cl = conn.prepareStatement(selectcl);

			//SQL文を完成させる
			if(closet_img_id != null) {
				selectpStmt_cl.setString(1, closet_img_id);
			}else {
				selectpStmt_cl.setString(1, null);
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = selectpStmt_cl.executeQuery();

			while (rs.next()) {
				closetdata = new Dressup(
				closet_img_id,
				rs.getBoolean("last_closet")
				);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			closetdata = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			closetdata = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					closetdata = null;
				}
			}
		}

		// 結果を返す
		return closetdata;
	}

//#--------------------------------------------------------------

	//きせかえた服を着ている服として登録
	public boolean updatetrue(String closet_img_id, String user_name) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			//SQLの準備
			String updatecl = "update closet set last_closet=true where closet_img_id=? and user_name= ?";
			PreparedStatement pStmt = conn.prepareStatement(updatecl);

			pStmt.setString(1, closet_img_id);
			pStmt.setString(2, user_name);

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

//#--------------------------------------------------------------

	//依然来ていた服をリセットするためにlast_closetをすべてfalse
	public boolean updatedeletelastcloset(String user_name) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバの読み込み
			Class.forName("org.h2.Driver");

			//DB接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			//SQLの準備
			String updatecl = "update closet set last_closet=false where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(updatecl);

			pStmt.setString(1, user_name);

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



