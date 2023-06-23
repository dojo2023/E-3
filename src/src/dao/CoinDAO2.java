package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Coin;

public class CoinDAO2 {

//==============================================================================================
	//ログイン時（1日1枚）、スケジュール登録時（1日1枚）、ペット画像クリック時（1日１枚）
	//スケジュール完了するとコイン1枚（9:00-11:59、12:00-14:59、15:00-18:00（それぞれ1回までもらえる））


	// コイン獲得 1枚
	public Coin coinplus1(String user_name, String event_id) {
		Connection conn = null;
		int coinnum = 1;

		//イベントの文字を表示させる
		String event_name = "";
		if(event_id.equals("login")) {
			event_name = "ログインボーナス！";
		}else if(event_id.equals("done")) {
			event_name = "スケジュール完了！";
		}else if(event_id.equals("regist")) {
			event_name = "スケジュール登録！";
		}

		boolean coinresult = false;
		Coin coindata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");
			// SQL文を準備する
			String sql = "update user set coin_cnt=coin_cnt + 1 where user_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user_name != null && !user_name.equals("")) {
				pStmt.setString(1, user_name);
			}
			else {
				pStmt.setString(1, null);
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				coinresult = true;
				coindata = new Coin(coinnum, coinresult, event_name);
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
		return coindata;
	}

//==============================================================================================
	//・スケジュール完了数（５０回ごとに「回数/１０」枚配布（１日３回まで））
	//・ログイン日数（５０日ごとに「日数/１０」枚配布）


	// コイン獲得 5枚
	public Coin coinplus5(String user_name) {//もう一つの引数でログイン化スケジュール完了かを判別
		Connection conn = null;
		int coinnum = 5;
		String event_name = "ログイン 50日達成！";
		String event_name2 = "スケジュール完了数 50回達成！";
		boolean coinresult = false;
		Coin coindata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");
			// SQL文を準備する
			String sql = "update user set coin_cnt=coin_cnt + 5 where user_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user_name != null && !user_name.equals("")) {
				pStmt.setString(1, user_name);
			}
			else {
				pStmt.setString(1, null);
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				coinresult = true;
				coindata = new Coin(coinnum, coinresult, event_name);
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
		return coindata;
	}

//==============================================================================================
	//・ユーザ登録後初回５０枚配布

	// コイン獲得 50枚
	public Coin coinplus50(String user_name) {
		Connection conn = null;
		int coinnum = 50;
		String event_name = "初回ボーナス！登録ありがとう！";
		boolean coinresult = false;
		Coin coindata = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");
			// SQL文を準備する
			String sql = "update user set coin_cnt=coin_cnt + 50 where user_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user_name != null && !user_name.equals("")) {
				pStmt.setString(1, user_name);
			}
			else {
				pStmt.setString(1, null);
			}


			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				coinresult = true;
				coindata = new Coin(coinnum, coinresult, event_name);
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
		return coindata;
	}

//==============================================================================================
	//ガチャを回したとき-10枚

	// コイン消費 -10枚
	public boolean coinminus10(String user_name) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");
			// SQL文を準備する
			String sql = "update user set coin_cnt=coin_cnt - 10 where user_name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (user_name != null && !user_name.equals("")) {
				pStmt.setString(1, user_name);
			}
			else {
				pStmt.setString(1, null);
			}


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
	//Userテーブルからコイン枚数だけ取得
	public int selectcoin(String user_name){
		Connection conn = null;
		int coin = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			//conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高橋/fcdb1", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");
			// SQL文を準備する
			String sql = "select coin_cnt from user where user_name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_name);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				coin = rs.getInt("coin_cnt");
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
		return coin;
	}
}
