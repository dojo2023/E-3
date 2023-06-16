<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<!-- <div class="wrapper"> -->
	<!-- ヘッダー（ここから） -->
	<h1 id="logo">
		<img src="img/logo.png" alt="ScheZoole">
	</h1>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<h2>ログイン</h2>
	<div class="main">
	<form class="form1" method="POST" action="/Esan/LoginServlet">
		<input type="text" name="user_name" placeholder="ユーザネーム"><br>
      	<input type="password" name="password" placeholder="パスワード"><br>
      	<input type="submit" name="LOGIN" value="ログイン" class="submit"><br>
      	<a href="/Esan/SignupServlet" id="signup">アカウント作成</a>
    </form>
    	<a href="/Esan/InquiryServlet" id="inquiry">お問い合わせ</a>
    </div>
    <!-- メイン（ここまで） -->
</body>
</html>