<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>新規登録画面</title>
	<link rel="stylesheet" href="css/signup.css">
</head>
<body>
<!-- <div class="wrapper"> -->
	<!-- ヘッダー（ここから） -->
	<h1 id="logo">
		<img src="img/logo.png" alt="ScheZoole">
	</h1>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<h2>新規登録</h2>
	<div>
	<form method="POST" action="/Esan/SignupServlet">
		<input type="text" name="user_name" placeholder="ユーザネーム"><br>
		<input type="password" name="password" placeholder="パスワード"><br>
      	<input type="text" name="email" placeholder="メールアドレス"><br>
      	<input type="text" name="pet_name" placeholder="ペットのお名前"><br>
      	<label>ペットを選択してください。<br>
      	※１度決めたペットの変更はできません<br>
      	</label>
		<input type="radio" name="pet_id" value=1 id="pet1_radio" checked><label for="pet1_radio"></label>
    	<input type="radio" name="pet_id" value=2 id="pet2_radio"><label for="pet2_radio"></label>
  	  	<input type="radio" name="pet_id" value=3 id="pet3_radio"><label for="pet3_radio"></label>
  	  	<input type="radio" name="pet_id" value=4 id="pet4_radio"><label for="pet4_radio"></label>
    	<input type="radio" name="pet_id" value=5 id="pet5_radio"><label for="pet5_radio"></label><br>
      	<input type="submit" name="signup_btn" value="新規登録"><br>
      	<p><c:out value="${result.message}" /></p>
      	<a href="/Esan/LoginServlet" id="login">ログイン画面へ</a>
    </form>
    	<a href="/Esan/InquiryServlet" id="inquiry">お問い合わせ</a>
    </div>
    <!-- メイン（ここまで） -->
</body>
</html>