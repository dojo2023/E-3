<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ふれあい画面</title>
<link rel="stylesheet" href="/Esan/css/pet_home.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
<link rel="stylesheet" href="/Esan/css/modal_closet.css">
</head>
<body>
<div class="all">
<div class="main">
	<%@include file="/include/menu.jsp"%>

	<!-- きせかえ画像の数 -->
	<c:set var="closetlen" value="${fn:length(closetList)}"/>

	<!-- ペットの種類IDをHTML上に表示 -->
	<p id="pet_id" style="display:none">${userdata.pet_id}</p>

	<!-- ひとことメッセージ -->
	<c:set var="messagelen" value="${fn:length(messageList)}"/>
	<p id="messagelen" style="display:none">${messagelen}</p>

	<c:set var="i" value="0"/>
    <c:forEach var="e" items="${messageList}" >
    <div class="message_data" id="message_content${i}" style="display:none">${e.message_content}</div>
    <c:set var="i" value="${i+1}"/>
    </c:forEach>

	<!--背景-->
	<c:set var="bgjudge" value="false"/>
	<c:forEach var="e" items="${closetList}" >
		<c:if test='${e.closet_kind_id == 5 && e.last_closet == true}'>
			<img class="closet" src ="${e.closet_img_path}">
			<c:set var="bgjudge" value="true"/>
		</c:if>
	</c:forEach>
	<c:if test="${bgjudge == false}">
		<img src="img/bg.png">
	</c:if>

	<!-- ペットの名前 -->
	<h3 id="pet_name">${userdata.pet_name}</h3>

	<!--==============モーダルウィンドウきせかえ===============-->

	<section id="info">

	<h2>きせかえ</h2>
	<form method="POST" action="/Esan/Pet_homeServlet" id="closet_form">
		<div class = "box1">
			<div class = "grl">
				<table class="border">
				<c:set var="i" value="0"/>
				<c:forEach var="e" items="${closetList_1234}" >
					<tr>
						<td>
			               	<div class="radio_closet">
							<c:choose>
								<c:when test='${e.closet_kind_id == 1}'>
									<input id="hat_radio${i}" type="radio" value="${e.closet_img_id}" name="hatimg">
									<label for="hat_radio${i}"><img id="closet" src="${e.closet_img_path}"></label>
								</c:when>
								<c:when test='${e.closet_kind_id == 2}'>
									<input id="dress_radio${i}" type="radio" value="${e.closet_img_id}" name="dressimg">
									<label for="dress_radio${i}"><img id="closet" src="${e.closet_img_path}"></label>
								</c:when>
								<c:when test='${e.closet_kind_id == 3}'>
									<input id="shoes_radio${i}" type="radio" value="${e.closet_img_id}" name="shoesimg">
									<label for="shoes_radio${i}"><img id="closet" src="${e.closet_img_path}"></label>
								</c:when>
								<c:when test='${e.closet_kind_id == 4}'>
									<input id="accessory_radio${i}" type="radio" value="${e.closet_img_id}" name="accessoryimg">
									<label for="accessory_radio${i}"><img id="closet" src="${e.closet_img_path}"></label>
								</c:when>
							</c:choose>
							</div>
						</td>
					</tr>
					<c:set var="i" value="${i + 1}"/>
				</c:forEach>
				</table>
			</div>
			<div class="grl2">
		 		<table>
		 			<c:set var="i" value="0"/>
					<c:forEach var="e" items="${closetList_5}" >
						<tr>
		                	<td>
		                	<div class="radio_closet">
		                		<c:choose>
		                			<c:when test='${e.closet_kind_id == 5}'>
									<input id="bg_radio${i}" type="radio" value="${e.closet_img_id}" name="backgroundimg">
									<label for="bg_radio${i}"><img id="closet" src="${e.closet_img_path}"></label>
									</c:when>
								</c:choose>
							</div>
							</td>
						</tr>
						<c:set var="i" value="${i + 1}"/>
					</c:forEach>
				</table>
			</div>

	</div>
		<button type="submit" name="dress_up" value="決定" class="submit">決定</button><br>
	</form>
	</section>
<div class="nonScroll"></div>
	<!--吹き出し-->
	<div class="balloon">
		<span id="messagetarget">クリックでメッセージが変わるよ</span>
	</div>

	<!-- ペットの画像 -->
	<div class="box" id="touch">
	<c:choose>
		<c:when test="${userdata.pet_id == 1}"><!-- くまちゃん -->
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"head")}'>
					<img src ="${e.pet_img_path}" class="abs" id="head">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"body")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"right")}'>
					<img src ="${e.pet_img_path}" class="abs" id="right">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"left")}'>
					<img src ="${e.pet_img_path}" class="abs" id="left">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"legs")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>


			<!-- ペットのきせかえ画像 -->
			<c:forEach var="e" items="${closetList}" >
			<c:choose>
				<c:when test='${e.closet_kind_id == 1 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 2 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 3 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 4 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
			</c:choose>
			</c:forEach>
		</c:when>

		<c:when test="${userdata.pet_id == 2}"><!-- トリケラトプス -->
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"body")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"legs")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"right")}'>
					<img src ="${e.pet_img_path}" class="abs" id="right">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"left")}'>
					<img src ="${e.pet_img_path}" class="abs" id="left">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"head")}'>
					<img src ="${e.pet_img_path}" class="abs" id="head">
				</c:if>
			</c:forEach>


			<!-- ペットのきせかえ画像 -->
			<c:forEach var="e" items="${closetList}" >
			<c:choose>
				<c:when test='${e.closet_kind_id == 1 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 2 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 3 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 4 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
			</c:choose>
			</c:forEach>
		</c:when>

		<c:when test="${userdata.pet_id == 3}"><!-- いぬ -->
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"head")}'>
					<img src ="${e.pet_img_path}" class="abs" id="head">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"body")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"right")}'>
					<img src ="${e.pet_img_path}" class="abs" id="right">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"left")}'>
					<img src ="${e.pet_img_path}" class="abs" id="left">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"legs")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>


			<!-- ペットのきせかえ画像 -->
			<c:forEach var="e" items="${closetList}" >
			<c:choose>
				<c:when test='${e.closet_kind_id == 1 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 2 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 3 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 4 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
			</c:choose>
			</c:forEach>
		</c:when>

		<c:when test="${userdata.pet_id == 4}"><!-- なまけもの -->
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"head")}'>
					<img src ="${e.pet_img_path}" class="abs" id="head">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"left")}'>
					<img src ="${e.pet_img_path}" class="abs" id="left">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"legs")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"body")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"right")}'>
					<img src ="${e.pet_img_path}" class="abs" id="right">
				</c:if>
			</c:forEach>


			<!-- ペットのきせかえ画像 -->
			<c:forEach var="e" items="${closetList}" >
			<c:choose>
				<c:when test='${e.closet_kind_id == 1 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 2 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 3 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 4 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
			</c:choose>
			</c:forEach>
		</c:when>

		<c:when test="${userdata.pet_id == 5}"><!-- りす -->
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"left")}'>
					<img src ="${e.pet_img_path}" class="abs" id="left">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"body")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"legs")}'>
					<img src ="${e.pet_img_path}" class="abs">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"right")}'>
					<img src ="${e.pet_img_path}" class="abs" id="right">
				</c:if>
			</c:forEach>
			<c:forEach var="e" items="${petList}" >
				<c:if test='${fn: contains(e.pet_img_id,"head")}'>
					<img src ="${e.pet_img_path}" class="abs" id="head">
				</c:if>
			</c:forEach>


			<!-- ペットのきせかえ画像 -->
			<c:forEach var="e" items="${closetList}" >
			<c:choose>
				<c:when test='${e.closet_kind_id == 1 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 2 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 3 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
				<c:when test='${e.closet_kind_id == 4 && e.last_closet == true}'>
					<img src ="${e.closet_img_path}" class="abs">
				</c:when>
			</c:choose>
			</c:forEach>
		</c:when>
	</c:choose>
	</div>

	<!-- モーション
	<div class="pet mot4">
		<img class="image" src="imgpet4/head.png" />
		<img class="image" src="imgmotion4/face1.png" />
		<img class="image" src="imgmotion4/face2.png" />
	</div>

	</div>
	-->

	<!--ペット画像
	<img src="imgpet1/head.png">
	<img src="imgpet1/body.png">
	<img src="imgpet1/right_arm.png">
	<img src="imgpet1/left_arm.png">
	<img src="imgpet1/legs.png">
	-->

	<!--きせかえ画像
	<img src="imgcloset1/hat1.png">
	<img src="imgcloset1/dress1.png">
	<img src="imgcloset1/shoes1.png">
	<img src="imgcloset1/accessory1.png">
	-->
	</div>


	<div class="box2">
	<!--画面遷移ボタン-->
	<div class = "btn1">
		<a href="/Esan/Schedule_listServlet" id="btn1">&lt;&nbsp;スケジュール管理</a>
	</div>
	 <!--コイン-->
	<div class="coin">
		<div class="coinImg"><img src="img/fc.png" width="100" height="100"></div>
		<div class="coinCnt"><label id="coin">${userdata.coin_cnt}</label></div>
	</div>
	<!-- きせかえ遷移画像 -->
	<div class="closet">
	      <a href="#info" class="modal-open"><img src="img/closet.png" width="80" height="80"></a>
	</div>
	<div class = "btn2">
		<a href="/Esan/GachaServlet" id="btn2">ガチャを引く&nbsp;&gt;</a>
	</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/js/9-6-1.js"></script>
<script src="js/modal_closet.js"></script>
<script src="js/motion.js"></script>
<script src="js/message.js"></script>
</body>
</html>