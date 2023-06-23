<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	<p>insert into gacha(pet_id, closet_img_id, closet_img_path, closet_name, closet_kind_id, rarity) values (</p>
	<form method="POST" action="/Esan/InsertServlet">
		<p>ペットの種類ID 1,2,3,4,5</p>
		<input type="text" name="pet_id">
		<input type="text" name="closet_img_id">
		<input type="text" name="closet_img_path">
		<input type="text" name="closet_name">
		<input type="text" name="closet_kind_id">
		<input type="text" name="rarity">
		<input type="submit" value="送信">
	</form>

</body>
</html>