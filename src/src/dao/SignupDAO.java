package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Signup;

public class SignupDAO {
	public String insert(Signup signup) {
		Connection conn = null;
		String signupResult = "";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_高川/fcdb2", "sa", "");

			// SELECT文を準備する
			String selectsql = "select count(*) from user where user_name = ?";
			PreparedStatement selectpStmt = conn.prepareStatement(selectsql);
			selectpStmt.setString(1, signup.getUn());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = selectpStmt.executeQuery();

			// ユーザーネームが重複しているかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				return signupResult = "dup";
			}


			// insert文を準備する
			String sql = "insert into user(user_name, password, email, pet_name, pet_id) values(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			if (signup.getUn() != null && !signup.getUn().equals("")) {
				pStmt.setString(1, signup.getUn());
			}
			else {
				pStmt.setString(1, null);
			}
			if (signup.getPw() != null && !signup.getPw().equals("")) {
				pStmt.setString(2, signup.getPw());
			}
			else {
				pStmt.setString(2, null);
			}
			if (signup.getEm() != null && !signup.getEm().equals("")) {
				pStmt.setString(3, signup.getEm());
			}
			else {
				pStmt.setString(3, null);
			}
			if (signup.getPn() != null && !signup.getPn().equals("")) {
				pStmt.setString(4, signup.getPn());
			}
			else {
				pStmt.setString(4, null);
			}
			if (signup.getPi() != 0) {
				pStmt.setInt(5, signup.getPi());
			}
			else {
				pStmt.setInt(5, 0);
			}

			// 登録できたかをチェックする
			if (pStmt.executeUpdate() == 1) {
				signupResult = "true";
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			signupResult = "false";
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			signupResult = "false";
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					signupResult = "false";
				}
			}
		}

		// 結果を返す
		return signupResult;
	}
}
