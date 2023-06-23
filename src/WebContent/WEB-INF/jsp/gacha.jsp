<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<p>${gachadata.closet_img_path}</p>

	<div class="content1">
	    <div class="container"><div class="item rotateY"><img src="/Esan/img/chicken.png"></div></div><br>
	    	<img src="/Esan/img/chicken_house.png" class="ouchi">

	    <div class="wrapper">
		    <form method="post" action="/Esan/GachaServlet">
		    	<input type="submit" id="gacha_btn" class="gacha_btn">
	    	</form>
		    <a href="#info" class="modal-open"><img src="img/gacha_btn.png"></a>
	    </div>
  	</div>

	<div class="content2">
		<table class="table2">
			<tr>
				<td><a href="/Esan/Pet_homeServlet">ふれあい画面</a></td>
				<td></td><td></td><td></td>
				<td><img src="img/fc.png" id="fc"></td><td id="coin_display">30枚</td>
				<td></td><td></td><td></td><td></td>
			</tr>
		</table>
	</div>

    <!--ここからガチャ結果画面-->
    <!--表示エリアのHTML。id 名にリンク先と同じ名前を指定します。※表示エリアはHTML の変更が可能なので、レイアウトを自由に変更できます。-->
	<section id="info">
	    <div class="modal">
	    <table>
	    <tr><th>レア度</th><td><img src="/Esan/img/rarity1.png"></td></tr>
	    </table>
	    <img src="${closet_path}" class="result"><br>
	    を手に入れた！<br>
	    <hr>
	    <a href="/Esan/GachaServlet">
	    <button type="button" id="ok_btn">OK</button>
	    </a>
	    </div>
    </section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!--自作のJS-->
<script src="/Esan/js/modal_gacha_result.js"></script>
<script src="/Esan/js/gacha.js"></script>
</body>
</html>