<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スケジュール編集</title>
<link rel="stylesheet" href="css/schedule_edit.css">
</head>
<body>
<%@include file="/include/menu.jsp"%>
<p>${resultmessage}</p>
<div class="container">
	<form method="POST" action="/Esan/Schedule_editServlet" id="regist">
	<input type="hidden" name="schedule_id" value="${sche.schedule_id}">
	<input type="text" id="user_name" value="${user_name}" placeholder="ユーザー名" readonly><br>
    <input type="text" id="title" name="schedule_name" value="${sche.schedule_name}" placeholder="スケジュール名">
    <select id="color" name="color_id">
        <option value="色">色を選択してください</option>
    <c:choose>
        <c:when test="${sche.color_id == 1}">
            <option value="">色を選択してください</option>
        	<option value="1" id="red" selected>赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow">黄色</option>
	        <option value="4" id="orange">オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue">青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>

        </c:when>
		<c:when test="${sche.color_id == 2}">
	        <option value="">色を選択してください</option>
			<option value="1" id="red">赤</option>
	        <option value="2" id="pink" selected>ピンク</option>
	        <option value="3" id="yellow">黄色</option>
	        <option value="4" id="orange">オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue">青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 3}">
	        <option value="">色を選択してください</option>
        	<option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange">オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue">青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>

        </c:when>
        <c:when test="${sche.color_id == 4}">
        	<option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue">青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 5}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan" selected>シアン</option>
	        <option value="6" id="blue">青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 6}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue" selected>青</option>
	        <option value="7" id="green">緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 7}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue" selected>青</option>
	        <option value="7" id="green" selected>緑</option>
	        <option value="8" id="magenta">マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 8}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue" selected>青</option>
	        <option value="7" id="green" selected>緑</option>
	        <option value="8" id="magenta" selected>マゼンタ</option>
	        <option value="9" id="purple">紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 9}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue" selected>青</option>
	        <option value="7" id="green" selected>緑</option>
	        <option value="8" id="magenta" selected>マゼンタ</option>
	        <option value="9" id="purple" selected>紫</option>
	        <option value="10" id="brown">茶色</option>
        </c:when>
        <c:when test="${sche.color_id == 10}">
            <option value="">色を選択してください</option>
            <option value="1" id="red">赤</option>
	        <option value="2" id="pink">ピンク</option>
	        <option value="3" id="yellow" selected>黄色</option>
	        <option value="4" id="orange" selected>オレンジ</option>
	        <option value="5" id="cyan">シアン</option>
	        <option value="6" id="blue" selected>青</option>
	        <option value="7" id="green" selected>緑</option>
	        <option value="8" id="magenta" selected>マゼンタ</option>
	        <option value="9" id="purple" selected>紫</option>
	        <option value="10" id="brown" selected>茶色</option>
        </c:when>
	</c:choose>
   </select><br>
    <div class="datetime">
	    <input type="date" name="start_date" value="${sche.start_date}"><input type="time" name="start_time" value="${sche.start_time}"> ～ <input type="date" name="finish_date" value="${sche.finish_date}"><input type="time" name="finish_time" value="${sche.finish_time}"><br>
	</div>
    <textarea id="content" name="content" cols="30" rows="10" placeholder="内容">${sche.content}</textarea><br>
    <span id="error_message" style="color:red"></span><br>
<div class="box1">
    <div class="button1">
    	<input type="button" id="back_btn" onclick="location.href='/Esan/Schedule_listServlet'" value="編集せずに戻る">
	</div>
	<div class="button2">
		<input type="submit" id="regist_btn" name="edit" value="編集を完了">
	</div>
</div>
    <script src="js/error_message_schedule.js"></script>
</form>
</div>
</body>
</html>