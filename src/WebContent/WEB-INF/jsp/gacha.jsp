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
  <div class="contents">
      <img src="/Esan/img/chicken.png" class="tori">
      <img src="/Esan/img/chicken_house.png" class="ouchi">
      <!--リンク元のHTMLリンク先は表示させたいエリアのid名を指定します。-->
      <a href="#info" class="modal-open">
          <button type="button" id="gacha_btn" class="botan">
          <img src="/Esan/img/gacha_btn.png"></button>
      </a>
  </div>
    <!--ここからガチャ結果画面-->
    <!--表示エリアのHTML。id 名にリンク先と同じ名前を指定します。※表示エリアはHTML の変更が可能なので、レイアウトを自由に変更できます。-->
    <section id="info">
    <div class="wrapper">
    <table>
    <tr><th>レア度</th><td><img src="/Esan/img/rarity1.png"></td></tr>
    </table>
    <img src="${closet_path}" class="result"><br>
    を手に入れた！<br>
    <hr>
    <button type="button" id="ok_btn">OK</button>
    </div>
    </section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!--自作のJS-->
<script src="/Esan/js/modal_gacha_result.js"></script>
<footer>
<div class="hureai">
<a href="/Esan/Pet_homeServlet">ふれあい画面</a>
</div>
<table>
<tr>
<th><img src="img/fc.png" id="fc"></th>
<td>30枚</td>
</tr>
</table>
</footer>
</body>
</html>