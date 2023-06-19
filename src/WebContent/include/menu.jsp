<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ハンバーガーメニュー</title>
<link rel="stylesheet" href="/Esan/menu.css">
</head>
<body>
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
            <li class="nav_item"><button>ログアウト</button></li>
            <li class="nav_item"><a href="">お問い合わせ</a></li>
          </ul>
        </nav>
      </div>
    </header>
 </body>
</html>