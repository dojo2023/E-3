<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<div class="wrapper">
		<!-- メイン（ここから） -->
		<div class="log_pet">
		<ul>
			<li><img src="img/logo.png" id="logo"></li>
			<li><img src="img/pet1mini.png" id="log_pet1"></li>
			<li><img src="img/pet2.png" id="log_pet2"></li>
			<li><img src="img/pet3.png" id="log_pet3"></li>
			<li><img src="img/pet4.png" id="log_pet4"></li>
			<li><img src="img/pet5.png" id="log_pet5"></li>
		</ul>
		</div>
		<h2>ログイン</h2>
		<div class="main">
			<form id="login_form" class="form1" method="POST" action="/Esan/LoginServlet">
				<input type="text" name="user_name" placeholder="ユーザネーム"><br>
		      	<input type="password" name="password" placeholder="パスワード"><br>
		      	<p><c:out value="${result.message}" /></p>
		      	<input type="submit" name="LOGIN" value="ログイン" class="submit"><br>
		      	<span id="error_message"></span>
		      	<a href="/Esan/SignupServlet" id="signup">アカウント作成</a>
		    </form>
		    <a href="/Esan/InquiryServlet" id="inquiry">お問い合わせ</a>
		</div>
	    <!-- メイン（ここまで） -->
    </div>
<script>

'use strict';

const img = ["img/pet2.jpg", "foo.jpg", "bar.jpg"];

let count = -1;

picChange(); // 関数を実行

function picChange() {

  count++;

  // カウントが最大になれば配列を初期値に戻すため「0」を指定する
  if (count == img.length) count = 0;

  // 画像選択
  document.getElementById("pic").src = img[count];

  // 1秒ごとに実行
  setTimeout("picChange()", 1000);

}

</script>
</body>
</html>