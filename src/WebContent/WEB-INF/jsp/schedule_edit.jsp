<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール編集</title>
</head>
<body>
	<form method="POST" action="/Esan/Schedule_editServlet">
	<input type="text" id="user_name" value="${sche.user_name}" readonly><br>
    <input type="text" id="title" name="schedule_name" value="${sche.schedule_name}">
    <select id="color" name="color_id">
        <option value="色">色を選択してください</option>
    <c:choose>
        <c:when test="${sche.color_id == 1}">
        	<option value="赤" id="red" selected>赤</option>
        </c:when>
    </c:choose>
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
    <input type="date" name="start_date"><input type="time" name="start_time"> ～ <input type="date" name="finish_date"><input type="time" name="finish_time"><br>
    <textarea id="content" name="content" cols="30" rows="10" placeholder="内容"></textarea>
    <span id="error_message"></span><br>

    <input type="submit" id="regist_btn" value="編集を完了">
</form>
    <button onclick="location.href='/Esan/Schedule_listServlet'">編集せずに戻る</button>
</body>
</html>