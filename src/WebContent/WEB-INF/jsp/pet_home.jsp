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
</head>
<body>
<!--背景-->
<img src="img/bg.png">
<!--コイン-->
<class="coin">
<img src="img/fc.png" width="150" height="150">
<!-- モーダルウィンドウ -->
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>9-6-1 ページを開くと、背景が暗くなりテキストを表示</title>
<meta name="description"  content="書籍「動くWebデザインアイディア帳」のサンプルサイトです">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!--==============レイアウトを制御する独自のCSSを読み込み===============-->
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/reset.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
<link rel="stylesheet" type="text/css" href="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/css/9-6-1.css">
</head>
<body>
<main>
    <section>

      <p><a href="#info" class="modal-open"><img src="img/closet.png"></a></p>

    <section id="info">
    <h2>Sale情報</h2>
    <p>11月1日～12月31日まで年末セールを開催！</p>
    </section>

  <!--/main--></main>


<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/9-6-1/js/9-6-1.js"></script>
</body>
</html>

<!--吹き出し-->
<link rel="stylesheet" href="/Esan/css/pet_home.css">
<script src="./js/message.js"></script>
<div class="balloon">
  おはようございます！
  <br>今日も一日がんばろう！
</div>


<c:forEach var="e" items="${petList}" >
<p>${e.pet_img_id} ${e.pet_img_path}</p>
<c:choose>
	<c:when test='${fn: contains(e.pet_img_id,"head")}'>
		<img src ="${e.pet_img_path}">
	</c:when>
</c:choose>
</c:forEach>


<!--ペット画像-->
<img src="imgpet1/head.png">
<img src="imgpet1/body.png">
<img src="imgpet1/right_arm.png">
<img src="imgpet1/left_arm.png">
<img src="imgpet1/legs.png">
<!--画面遷移ボタン-->

 <a href="./schedule_list.jsp">スケジュール管理</a>
<a href="./gacha.jsp">ガチャ</a>


</head>
</body>
</html>