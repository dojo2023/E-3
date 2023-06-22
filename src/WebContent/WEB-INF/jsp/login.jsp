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
			<li><img src="img/pet1.png" id="log_pet1"></li>
			<li><img src="img/pet2.png" id="log_pet2"></li>
			<li><img src="img/pet3.png" id="log_pet3"></li>
			<li><img src="img/pet4.png" id="log_pet4"></li>
			<li><img src="img/pet5.png" id="log_pet5"></li>
		</ul>
		</div>
		<h2><span class="cloud">ロ</span><span class="cloud">グ</span><span class="cloud">イ</span><span class="cloud">ン</span></h2>
		<div class="main">
			<form id="login_form" class="form1" method="POST" action="/Esan/LoginServlet">
				<input type="text" name="user_name" placeholder="ユーザネーム" class="box"><br>
		      	<input type="password" name="password" placeholder="パスワード" class="box"><br>
		      	<p><c:out value="${result.message}" /></p>
		      	<button type="submit" name="LOGIN" value="ログイン" class="submit">ログイン</button><br>
		      	<span id="error_message"></span>
		      	<a href="/Esan/SignupServlet" id="signup">アカウント作成</a>
		    </form>
		    <a href="/Esan/InquiryServlet" id="inquiry">お問い合わせ</a>
		</div>
	    <!-- メイン（ここまで） -->
    </div>
</body>
</html>