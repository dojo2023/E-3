<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>スケジュール閲覧</title>
    <link rel="stylesheet" href="takahashi/schedule_list.css">
    <link rel="stylesheet" href="takahashi/calendar.css">
    <link rel="stylesheet" href="takahashi/drawer.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
    <link rel="stylesheet" href="takahashi/modal.css">
</head>

<body>
    <div class="overlay"></div>
    <nav class="nav">
        <div class="toggle">
        <span id="deleteconpo" class="toggler"></span>
        </div>
        <div class="logo">
        <a href="#">LOGO</a>
        </div>
        <ul class="linkList">
        <li><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Blog</a></li>
        <li><a href="#">Contact</a></li>
        </ul>
    </nav>
    <div class="cal">
        <!-- xxxx年xx月を表示 -->
        <h1 id="header"></h1>

        <!-- ボタンクリックで月移動 -->
        <div id="next-prev-button">
            <button id="prev" onclick="prev()">‹</button>
            <button id="next" onclick="next()">›</button>
        </div>

        <!-- カレンダー -->
        <div id="calendar"></div>
    </div>

    <!--  -->
    <div>
        <p>現在時刻 <span id="nowtime"></span></p>
    </div>

    <div>
        <img src="takahashi/kumamini.png"/>
        <div class="balloon1">
            <p>こんにちは。これは例です。</p>
          </div>
    </div>

    <div>
        <img src="takahashi/fcmini.png"/>30
    </div>

    <div>
        <form method="GET" name="regist" action="Schedule_listServlet">
            <input type="submit" name="regist" value="スケジュール登録">
        </form>
    </div>

    <div>
        <form method="POST" action="/Esan/Schedule_listServlet">
            <input type="submit" name="values" value="スケジュール表示">
        </form>
    </div>
    <c:forEach var="e" items="${scheduleList}" >
    <p>${e.user_name}${e.schedule_name}${e.start_date}${e.start_time}${e.finish_date}${e.finish_time}${e.color_id}${e.content}</p>
    </c:forEach>

    <div id="schedule">
        <table border>
        <c:forEach begin="0" end="5" step="1" var="i">
        	<tr>
            <td class="hourtime">00:${i}0</td>
            <td class="td1"></td>
            <td class="td2"></td>
            </tr>
        </c:forEach>
            <tr>
            <td class="hourtime">00:00</td>
            <td class="1" bgcolor="#ffff00"><input type="checkbox" value="completion"><span>00:00 - 00:30</span><br><a href="#info" class="modal-open">スケジュール名</a></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td class="10">10</td>
            <td class="1" bgcolor="#ffff00"></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td>20</td>
            <td class="1" bgcolor="#ffff00"></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td class="halftime">00:30</td>
            <td class="1" bgcolor="#ffff00"></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td>40</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td>50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            <tr>
            <td>01:00</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            </tr>
            </table>
    </div>
    <section id="info">
        <h2>スケジュール名 00:00 - 00:30</h2>
        <p>スケジュールの内容</p>
        <form method="POST" name="edit" action="#">
            <input type="submit" name="edit" value="編集">
        </form>
        <form method="POST" name="delete" action="#">
            <input type="submit" name="delete" value="削除">
        </form>

    </section>

<script src="takahashi/jquery-3.6.4.min.js"></script>
<script src="takahashi/calendar.js"></script>
<script src="takahashi/date.js"></script>
<script src="takahashi/drawer.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="takahashi/modal.js"></script>
</body>
</html>