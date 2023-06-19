<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ画面</title>
</head>
<body>
<!-- <div class="wrapper"> -->
	<!-- ヘッダー（ここから） -->
	<h1 id="logo">
		<img src="img/logo.png" alt="ScheZoole">
	</h1>
	<!-- ヘッダー（ここまで） -->
	<!-- メイン（ここから） -->
	<!-- メイン（ここから） -->
	<h2>お問い合わせ</h2>
	<div>
	<form method="POST" action="/Esan/InquiryServlet">
		<input type="text" name="user_name" placeholder="ユーザネーム"><br>
      	<input type="text" name="email" placeholder="メールアドレス"><br>
      	<input type="text" name="inquiry_content" placeholder="お問い合わせ内容"><br>
      	<input type="submit" name="send_inquiry" value="送信"><br>
      	<p><c:out value="${result.message}" /></p>
      	<a href="/Esan/LoginServlet" id="login">ログイン画面へ</a>
    </form>
    </div>
    <!-- メイン（ここまで） -->
</body>
</html>