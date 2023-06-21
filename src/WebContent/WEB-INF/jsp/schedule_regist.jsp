<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール登録</title>
<!-- <link rel="stylesheet" href="/Esan/menu.css"> -->
</head>
<body>
<form action="/Esan/Schedule_registServlet" method="POST" id="regist">
	<input type="text" id="user_name" value="${user_name}" readonly><br>
    <input type="text" id="title" name="schedule_name" placeholder="スケジュール名">
    <select id="color" name="color_id">
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
    <input type="date" name="start_date"><input type="time" name="start_time"> ～ <input type="date" name="finish_date"><input type="time" name="finish_time"><br>
    <textarea id="content" name="content" cols="30" rows="10" placeholder="内容"></textarea><br>
    <span id="error_message"></span><br>

    <input type="submit" id="regist_btn" value="登録">
</form>
    <button onclick="location.href='/Esan/Schedule_listServlet'">登録せずに戻る</button>

    <script src="js/error_message_schedule.js"></script>
</body>
</html>