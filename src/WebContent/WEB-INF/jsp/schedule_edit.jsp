<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール編集</title>
</head>
<body>
	<form method="POST" action="/Esan/Schedule_editServlet">
	<input type="text" id="user_name" placeholder="ユーザ名"><br>
    <input type="text" id="title" placeholder="スケジュール名">
    <select id="color">
        <option value="色">色を選択してください</option>
        <option value="赤" id="red">赤</option>
        <option value="ピンク" id="pink">ピンク</option>
        <option value="黄色" id="yellow">黄色</option>
        <option value="オレンジ" id="orange">オレンジ</option>
        <option value="シアン" id="cyan">シアン</option>
        <option value="青" id="blue">青</option>
        <option value="緑" id="green">緑</option>
        <option value="マゼンタ" id="magenta">マゼンタ</option>
        <option value="紫" id="purple">紫</option>
        <option value="茶色" id="brown">茶色</option>
   </select><br>
    <input type="date"><input type="time"> ～ <input type="date"><input type="time"><br>
    <textarea id="content" cols="30" rows="10" placeholder="内容"></textarea>
    <p>(エラーメッセージをここに挿入)</p>

    <input type="button" id="back_btn" value="編集せずに戻る">
    <input type="submit" id="regist_btn" value="編集を完了">
</form>
</body>
</html>