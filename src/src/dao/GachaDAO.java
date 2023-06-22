package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class GachaDAO{
	public List<Gacha> select(Gacha param){
       Connection conn = null;
       List<Gacha> gachaList = new ArrayList<Gacha>();

       try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/SQL_岩田/fcdb3", "sa", "");

			// SQL文を準備する
			String sql = "select pet_id,closet_img_id,closet_path,closet_name,closet_kind_id,rarity from gacha where closet_img_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
	}
}