<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="./error_message_login.js"></script>
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
</body>
</html>