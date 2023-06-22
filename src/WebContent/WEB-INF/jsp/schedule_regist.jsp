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

    <div class="container">
        <header class="header">
          <!-- ハンバーガーメニュー部分 -->
          <div class="nav">
            <!-- ハンバーガーメニューの表示・非表示を切り替えるチェックボックス -->
            <input id="drawer_input" class="drawer_hidden" type="checkbox">
            <!-- ハンバーガーアイコン -->
            <label for="drawer_input" class="drawer_open"><span></span></label>
            <!-- メニュー -->
            <nav class="nav_content">
              <ul class="nav_list">
                <li class="nav_item"><a href="">スケジュールを見る</a></li>
                <li class="nav_item"><a href="">ペットの様子を見る</a></li>
                <li class="nav_item"><a href="">お問い合わせ</a></li>
                <li><button>ログアウト</button></li>
              </ul>
            </nav>
          </div>
        </header>
    </div>

<div class="container">
<form action="/Esan/Schedule_registServlet" method="POST" id="regist">
	<input type="text" id="user_name" value="${user_name}" placeholder="ユーザー名" readonly><br>
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
    <div class="datetime">
	    <input type="date" name="start_date"><input type="time" name="start_time"> ～ <input type="date" name="finish_date"><input type="time" name="finish_time"><br>
    </div>
    <textarea id="content" name="content" cols="30" rows="10" placeholder="内容"></textarea><br>
    <span id="error_message" style="color:red"></span><br>
    <div class="button">
	    <input type="submit" id="regist_btn" value="登録">
	</div>
</form>
	<div class="button">
            <input type="button" id="back_btn" value="登録せずに戻る" onclick="location.href='/Esan/Schedule_listServlet'">
    </div>

    <script src="js/error_message_schedule.js"></script>
</div>
</body>
</html>