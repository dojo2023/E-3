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
	<div class="main">
	<!-- メイン（ここから） -->
	<h2><span class="cloud">新</span><span class="cloud">規</span><span class="cloud">登</span><span class="cloud">録</span></h2>
	<form class="signup_form" method="POST" action="/Esan/SignupServlet">
		<table>
			<tr>
				<td>
					<input type="text" name="user_name" placeholder="ユーザネーム" class="box">
				</td>
				<td>
					<input type="text" name="pet_name" placeholder="ペットのお名前" class="box">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="password" placeholder="パスワード" class="box">
				</td>
				<td>
					<label>ペットを選択してください。</label><br>
					<label>※１度決めたペットの変更はできません</label><br>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="email" placeholder="メールアドレス" class="box">
				</td>
				<td>
					<div>
						<input type="radio" name="pet_id" value="1" id="pet1_radio" checked><label for="pet1_radio"></label>
					  	<input type="radio" name="pet_id" value="2" id="pet2_radio"><label for="pet2_radio"></label>
						<input type="radio" name="pet_id" value="3" id="pet3_radio"><label for="pet3_radio"></label>
						<input type="radio" name="pet_id" value="4" id="pet4_radio"><label for="pet4_radio"></label>
					  	<input type="radio" name="pet_id" value="5" id="pet5_radio"><label for="pet5_radio"></label>
				    </div>
				</td>
			</tr>
			<tr>
				<td>

				</td>
				<td>

				</td>
			</tr>
		</table>
		<p><c:out value="${result.message}" /></p>
      	<input type="submit" name="signup_btn" class="submit" value="新規登録"><br>
      	<a href="/Esan/LoginServlet" id="login">ログイン画面へ</a>
    </form>
    	<a href="/Esan/InquiryServlet" id="inquiry">お問い合わせ</a>
    </div>
    <!-- メイン（ここまで） -->
</body>
</html>