<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール登録</title>
<link rel="stylesheet" type="text/css" href="css/schedule_regist.css">
	<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<%@include file="/include/menu.jsp"%>
<img alt="ロゴ" src="img/logo.png">
<div class="container">
<form action="/Esan/Schedule_registServlet" method="POST" id="regist">
	<input type="text" id="user_name" value="${user_name}" placeholder="ユーザー名" readonly><br>
    <input type="text" id="title" name="schedule_name" placeholder="スケジュール名">
    <select id="color" name="color_id">
        <option value="">色を選択してください</option>
        <option value="1" id="red">赤</option>
        <option value="2" id="pink">ピンク</option>
        <option value="3" id="yellow">黄色</option>
        <option value="4" id="orange">オレンジ</option>
        <option value="5" id="cyan">シアン</option>
        <option value="6" id="blue">青</option>
        <option value="7" id="green">緑</option>
        <option value="8" id="magenta">マゼンタ</option>
        <option value="9" id="purple">紫</option>
        <option value="10" id="brown">茶色</option>
    </select><br>
    <div class="datetime">
	    <input type="date" name="start_date"><input type="time" name="start_time"> ～ <input type="date" name="finish_date"><input type="time" name="finish_time"><br>
    </div>
    <textarea id="content" name="content" cols="30" rows="10" placeholder="内容"></textarea><br>
    <span id="error_message" style="color:red"></span><br>


<div class="box1">
    <div class="button1">
        <input type="button" id="back_btn" value="登録せずに戻る" onclick="location.href='/Esan/Schedule_listServlet'">
	</div>
	<div class="button2">
		    <input type="submit" id="regist_btn" value="登録">
    </div>
</div>
</form>
    <script src="js/error_message_schedule.js"></script>
</div>
</div>
</body>
</html>