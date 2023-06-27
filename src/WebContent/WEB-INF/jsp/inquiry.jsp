<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ画面</title>
<link rel="stylesheet" href="css/inquiry.css">
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
	<form id="inquiry_form" method="POST" action="/Esan/InquiryServlet">
		<input type="text" name="user_name" placeholder="ユーザネーム" class="box"><br>
      	<input type="text" name="email" placeholder="メールアドレス" class="box"><br>
      	<textarea name="inquiry_content" placeholder="お問い合わせ内容" class="box" rows="5" cols="30"></textarea>
      	<p><c:out value="${result.message}" /></p>
      	<input type="submit" name="send_inquiry" value="送信"  class="submit"><br>
      	<a href="/Esan/Schedule_listServlet" id="login">戻る</a>
    </form>
    </div>
    <!-- メイン（ここまで） -->
<script>
let formObj = document.getElementById("inquiry_form");
let errorMessageObj = document.getElementById('error_message');
/* [送信]ボタンをクリックしたときの処理 */
formObj.onsubmit = function() {
  if(window.confirm('この内容でよろしいですか？')) {
    return true;
  }
  else{ // 「キャンセル」時の処理
    window.alert('キャンセルされました'); // 警告ダイアログを表示
    return false; // リセットを中止
  }
  errorMessageObj.textContent = null;
};
</script>
</body>
</html>