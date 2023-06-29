<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ガチャ</title>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
	<link rel="stylesheet" type="text/css" href="/Esan/css/modal_gacha_result.css">
	<link rel="stylesheet" type="text/css" href="/Esan/css/gacha.css">
</head>

<body>
<%@include file="/include/menu.jsp"%>
<%@include file="/include/push.jsp"%>
<p id="closet_img_path">${gachadata.closet_img_path}</p>
<p id="result">${result}</p>
<p id="rarity">${rarity}</p>
<p id="alert">${alert}</p>
	<div class="content1">
	    <div class="container"><div class="rotate_chicken"><img src="/Esan/img/chicken.png"></div></div><br>
	    	<img src="/Esan/img/chicken_house.png" class="ouchi">

	    <div class="wrapper">
		    <form method="post" action="/Esan/GachaServlet">
		    <input type="submit" id="gacha_btn" class="gacha_btn" value="ガチャをまわす">
		    </form>
	    </div>
	    <a href="#info" class="modal-open">
	    <div class="rotate_egg">
	    <img id="egg">
	    </div>
	    </a>
  	</div>

	<div class="content2">
				<div class="btn1">
				  <a href="/Esan/Pet_homeServlet" id="btn1">&lt;&nbsp;ふれあい画面</a>
				</div>
				<div class="coin">
		           <div class="coinImg"><img src="img/fc.png" width="100" height="100"></div>
		           <div class="coinCnt"><label id="coin">${userdata.coin_cnt}</label></div>
	            </div>
	</div>

    <!--ここからガチャ結果画面-->
    <!--表示エリアのHTML。id 名にリンク先と同じ名前を指定します。※表示エリアはHTML の変更が可能なので、レイアウトを自由に変更できます。-->
	<section id="info">
	    <div class="modal">
	    <table>
	    <tr><td><img id="broken_egg"></td><td>レア度</td><td><img id="star"></td></tr>
	    </table>
	    <img src="${gachadata.closet_img_path}" class="result" width="400" height="400"><br><br>
	    <h1>${gachadata.closet_name}を手に入れた！</h1><br>
	    <div class="ok_btn">
	    <a href="/Esan/GachaServlet" id="ok_btn">OK</a>
	    </div>
	    </div>
    </section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!--自作のJS-->
<script src="/Esan/js/modal_gacha_result.js"></script>
<script src="/Esan/js/gacha.js"></script>
<%@include file="/include/includeJS.jsp"%>
</body>
</html>