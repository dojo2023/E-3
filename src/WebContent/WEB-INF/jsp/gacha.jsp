<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ガチャ</title>
<link rel="stylesheet" href="Esan/css/gacha.css">
</head>
<body>
    <div class="overlay"></div>
    <nav class="nav">
      <div class="toggle">
        <span id="deleteconpo" class="toggler"></span>
      </div>
      <ul class="linkList">
        <li><a href="/Esan/Schedule_listServlet">スケジュールを見る</a></li>
        <li><a href="/Esan/Pet_homeServlet">ペットの様子を見る</a></li>
        <li><a href="/Esan/LoginServlet"><button type="button" id="logout">ログアウト</button></a></li>
        <li><a href="/Esan/InquiryServlet">お問い合わせ</a></li>
      </ul>
    </nav>
    <script src="Esan/js/gacha.js"></script>
    <img src="/Esan/img/chicken.png">
    <img src="/Esan/img/chicken_house.png">
    <!--リンク元のHTMLリンク先は表示させたいエリアのid名を指定します。-->
    <p><a href="#info" class="modal-open"><img src="/Esan/WebContent/img/gacha_btn.png"></a></p>

    <!--ここからガチャ結果画面-->
    <!--表示エリアのHTML。id 名にリンク先と同じ名前を指定します。※表示エリアはHTML の変更が可能なので、レイアウトを自由に変更できます。-->
    <section id="info">
    <div id="rarity"></div>
    <br>
    <div id="closet_name"></div>を手に入れた！
    <br>
    <button type="button" id="ok_button"></button>
    </section>

<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<!--自作のJS-->
<script src="/Esan/js/modal_gacha_result.js"></script>
<script src="/Esan/js/menu.js"></script>
</body>
<footer>
<a href="/Esan/Pet_homeServlet">ふれあい画面</a>
<img src="/Esan/WebContent/img/fc.png">
<div id="coin_display"></div>
</footer>
</html>