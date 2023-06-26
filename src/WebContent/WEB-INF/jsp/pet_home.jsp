<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Esan/css/pet_home.css">
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/reset.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/css/9-6-1.css">
<link rel="stylesheet" href="/Esan/css/modal_closet.css">
</head>
<body>
<div class="all">
<%@include file="/include/menu.jsp"%>
<c:set var="closetlen" value="${fn:length(closetList)}"/>
<!--背景-->
<img src="img/bg.png">

<!-- モーダルウィンドウ -->

<!--==============レイアウトを制御する独自のCSSを読み込み===============-->

<section id="info">

<h2>きせかえ</h2>

<div class = "box1">
<div class = "grl">
            <table class="border">
            <c:forEach var="e" items="${closetList}" >
				<tr>
                	<td>
                	<div class="radio_closet">
                  		<c:choose>
                			<c:when test='${e.closet_kind_id == 1}'>
                				<input id="hat_radio" type="radio" value="1" name="image">
  								<label for="hat_radio"><img src="${e.closet_img_path}" width="100" height="100"></label>
           					</c:when>
							<c:when test='${e.closet_kind_id == 2}'>
                				<input id="dress_radio" type="radio" value="2" name="image">
  								<label for="dress_radio"><img src="${e.closet_img_path}" width="100" height="100"></label>
           					</c:when>
							<c:when test='${e.closet_kind_id == 3}'>
                				<input id="shoes_radio" type="radio" value="3" name="image">
  								<label for="shoes_radio"><img src="${e.closet_img_path}" width="100" height="100"></label>
           					</c:when>
							<c:when test='${e.closet_kind_id == 4}'>
                				<input id="accessory_radio" type="radio" value="4" name="image">
  								<label for="accesorry_radio"><img src="${e.closet_img_path}" width="100" height="100"></label>
           					</c:when>
						</c:choose>
					</div>
                  </td>
				</tr>
 			</c:forEach>
			</table>
</div>
<div class="grl2">
 		<table>
			<c:forEach var="e" items="${closetList}" >
				<tr>
                	<td>
                	<div class="radio_closet">
                		<c:choose>
                			<c:when test='${e.closet_kind_id == 5}'>
                				<input id="bg_radio" type="radio" value="5" name="image">
  								<label for="bg_radio"><img src="${e.closet_img_path}" width="100" height="100"></label>
           					</c:when>
						</c:choose>
					</div>
					</td>
				</tr>
			</c:forEach>
		</table>
</div>
</div>
<button type="submit" name="dress_up" value="決定" class="submit">決定</button><br>
</section>

<!-- ペットの名前 -->
<label id="pet_name">${userdata.pet_name}
</label>


<!--吹き出し-->


<div class="balloon">
  おはようございます！
  <br>今日も一日がんばろう！
</div>

<div class="box">
<c:forEach var="e" items="${petList}" >

<c:choose>
	<c:when test='${fn: contains(e.pet_img_id,"head")}'>
		<img src ="${e.pet_img_path}" class="abs">
	</c:when>
	<c:when test='${fn: contains(e.pet_img_id,"body")}'>
		<img src ="${e.pet_img_path}" class="abs">
	</c:when>
	<c:when test='${fn: contains(e.pet_img_id,"right_arm")}'>
		<img src ="${e.pet_img_path}" class="abs">
	</c:when>
	<c:when test='${fn: contains(e.pet_img_id,"left")}'>
		<img src ="${e.pet_img_path}" class="abs">
	</c:when>
	<c:when test='${fn: contains(e.pet_img_id,"legs")}'>
		<img src ="${e.pet_img_path}" class="abs">
	</c:when>
</c:choose>
</c:forEach>

<!-- きせかえ -->
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
</div>

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



<div class="box2">
<!--画面遷移ボタン-->
<div class = "btn1">
	<a href="/Esan/Schedule_listServlet">スケジュール管理</a>
</div>
 <!--コイン-->
<div class="coin">
	<img src="img/fc.png" width="150" height="150">
	<label>${userdata.coin_cnt}</label>
</div>
<!-- きせかえ遷移画像 -->
<div class="closet">
      <p><a href="#info" class="modal-open"><img src="img/closet.png"></a></p>
</div>
<div class = "btn2">
	<a href="/Esan/GachaServlet">ガチャ</a>
</div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/js/9-6-1.js"></script>
<script src="js/modal_closet.js"></script>
<script src="./js/message.js"></script>
</body>
</html>