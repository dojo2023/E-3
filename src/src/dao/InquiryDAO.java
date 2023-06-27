package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Inquiry;

public class InquiryDAO {
	public String insertIq(Inquiry inquiry) {
		Connection conn = null;
		String signupResult = "";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_fcdb/fcdb", "sa", "");

			// insert文を準備する
			String sql = "insert into inquiry(user_name, email, inquiry_content) values(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			/*if (inquiry.getIi() != 0) {
				pStmt.setInt(1, inquiry.getIi());
			}
			else {
				pStmt.setInt(1, 0);
			}*/
			if (inquiry.getUn() != null && !inquiry.getUn().equals("")) {
				pStmt.setString(1, inquiry.getUn());
			}
			else {
				pStmt.setString(1, null);
			}
			if (inquiry.getEm() != null && !inquiry.getEm().equals("")) {
				pStmt.setString(2, inquiry.getEm());
			}
			else {
				pStmt.setString(2, null);
			}
			if (inquiry.getCo() != null && !inquiry.getCo().equals("")) {
				pStmt.setString(3, inquiry.getCo());
			}
			else {
				pStmt.setString(3, null);
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

