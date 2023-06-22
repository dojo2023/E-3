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

    <form method="POST" action="/Esan/Schedule_listServlet" name="dateform">
        <input type="hidden" name="date" id="daysvalue">
        <input type="hidden" name="values" value="date">
    </form>

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
s
    <div>
        <p>現在時刻 <span id="nowtime"></span></p>
    </div>

    <div>
        <a href="/Esan/Pet_homeServlet"><img src="img/pet${userdata.pet_id}.png"/></a>
        <div class="balloon1">
            <p>${userdata.user_name}さん、おはよう。</p>
          </div>
    </div>

    <div>
    	<span id="coinplus" style="display:none">${coinplus1}</span>
        <img src="takahashi/fcmini.png"/>コイン枚数:${userdata.coin_cnt}
    </div>

    <div>
        <form method="GET" name="regist" action="/Esan/Schedule_registServlet">
            <input type="submit" name="regist" value="スケジュール登録">
        </form>
    </div>

    <div>
        <form method="POST" action="/Esan/Schedule_listServlet">
        	<input type="hidden" name="userid" value="ユーザ名">
            <input type="submit" name="values" value="スケジュール表示">
        </form>
    </div>

    <c:set var="i" value="0"/>
    <c:forEach var="e" items="${scheduleList}" >
    <div class="schedule_data" id="schedule_id${i}" style="display:none">${e.schedule_id}</div>
    <div class="schedule_data" id="user_name${i}" style="display:none">${e.user_name}</div>
    <div class="schedule_data" id="schedule_name${i}" style="display:none">${e.schedule_name}</div>
    <div class="schedule_data" id="start_date${i}" style="display:none">${e.start_date}</div>
    <div class="schedule_data" id="start_time${i}" style="display:none">${e.start_time}</div>
    <div class="schedule_data" id="finish_date${i}" style="display:none">${e.finish_date}</div>
    <div class="schedule_data" id="finish_time${i}" style="display:none">${e.finish_time}</div>
    <div class="schedule_data" id="color_code${i}" style="display:none">${e.color_code}</div>
    <div class="schedule_data" id="content${i}" style="display:none">${e.content}</div>
    <c:set var="i" value="${i+1}"/>
    </c:forEach>

    <div id="schedule">
    <c:set var="tdlength" value="${fn:length(scheduleList)}"/>
    <div id="slength">${tdlength}</div>

        <table border>
        <c:forEach begin="0" end="23" step="1" var="hour">
	        <c:forEach begin="0" end="5" step="1" var="minutes">

	        	<c:choose>
	        		<c:when test="${hour <= 9}"><c:set var="zero" value="0"/></c:when>
	        		<c:otherwise><c:set var="zero" value=""/></c:otherwise>
	        	</c:choose>
	        	<c:set var="time" value="${zero}${hour}:${minutes}0"/>
	        	<tr>

	        	<c:choose>
	        		<c:when test="${minutes == 0}"><td class="hourtime">${time}</td></c:when>
	        		<c:when test="${minutes == 3}"><td class="halftime">${time}</td></c:when>
	        		<c:otherwise><td class="hiddentime">${time}</td></c:otherwise>
	        	</c:choose>

	            <c:forEach begin="0" end="${tdlength}" step="1" var="tdnum">
	            	<td id="${zero}${hour}:${minutes}0-${tdnum}"></td>
	            </c:forEach>
	        </c:forEach>
        </c:forEach>
    	</table>
    </div>

<script src="takahashi/jquery-3.6.4.min.js"></script>
<script src="takahashi/calendar.js"></script>
<script src="takahashi/date.js"></script>
<script src="takahashi/drawer.js"></script>
<script src="takahashi/schedule_list.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="takahashi/modal.js"></script>
</body>
</html>