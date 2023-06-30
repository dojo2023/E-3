<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>スケジュール閲覧</title>
    <link rel="stylesheet" href="css/schedule_list.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link rel="stylesheet" href="takahashi/drawer.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/css/modaal.min.css">
    <link rel="stylesheet" href="css/modal_detail.css">
    <link rel="stylesheet" href= "css/balloon.css">
</head>

<body>
	<%@include file="/include/menu.jsp"%>
	<%@include file="/include/push.jsp"%>

	<!-- コインの追加処理 ログイン時、スケジュール完了時 -->
    <div style="display:none">
    	<span id="coinresult" style="display:none">${coinplus.coinresult}</span>
    	<a href="#coinplus" class="modal-open" id="coinbtn"></a>
    	<section id="coinplus">
    		<h2>${coinplus.event_name}</h2>
    		<p>ふっくらコインが${coinplus.coinnum}枚追加！</p>
    	</section>
    </div>

	<!-- カレンダーで選択した日付を送信 -->
    <form method="POST" action="/Esan/Schedule_listServlet" name="dateform">
        <input type="hidden" name="date" id="daysvalue">
        <input type="hidden" name="values" value="date">
    </form>

	<div id="flexparent">
    <div id="flexchild">
        <!-- カレンダー表示 -->
        <div id="flexcal">
            <div id="cal">
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
        </div>
    </div>

	<div id="flexchild1">
        <!-- 現在時刻を表示 -->
        <div id="flexnowdate">
            <p><span id="nowtime"></span></p>
        </div>

        <!-- ペットの表示とセリフの変更 -->
        <div id="flexpet">
            <a href="/Esan/Pet_homeServlet"><img src="imgpet${userdata.pet_id}/pet${userdata.pet_id}.png" style="width:200px" id="petimg"/></a>
            <div class="balloon1-left" id="balloon-p">
            	<p>${userdata.user_name}さん<br><span id="message"><br></span>
            		<span>${sessionresultmessage}</span>
            	</p>
          	</div>
    	</div>
    </div>

	<div id="flexchild2">
        <!-- コインの枚数表示 -->
        <div id="flexcoin">
            <img src="img/fc.png" style="width:100px" id="fcimg"/>
        	<span id="coinnum">${userdata.coin_cnt}</span>
    	</div>

		<!-- スケジュール登録遷移ボタン -->
        <div id="flexregist">
            <form method="GET" name="regist" action="/Esan/Schedule_registServlet" id="registform">
                <input type="submit" name="regist" value="スケジュール登録" id="registbtn">
            </form>
        </div>
    </div>
    </div>

	<!-- 全件表示　なくてもいい -->
    <!-- <div>
        <form method="POST" action="/Esan/Schedule_listServlet">
        	<input type="hidden" name="userid" value="ユーザ名">
            <input type="submit" name="values" value="スケジュール表示">
        </form>
    </div>
    -->

    <p id="schedate">${date}のスケジュール</p>

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
    <div class="schedule_data" id="schedule_done${i}" style="display:none">${e.schedule_done}</div>
    <c:set var="i" value="${i+1}"/>
    </c:forEach>
    <div class="schedule_data" id="senddate" style="display:none">${date}</div>

    <div id="schedule">
    <c:set var="tdlength" value="${fn:length(scheduleList)}"/>
    <div id="slength" style="display:none">${tdlength}</div>

	<c:if test="${tdlength != 0}">
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

	            <c:forEach begin="0" end="${tdlength-1}" step="1" var="tdnum">

		            <c:choose>
		        		<c:when test="${minutes == 0}"><td class="hourtime" id="${zero}${hour}:${minutes}0-${tdnum}"></td></c:when>
		        		<c:when test="${minutes == 3}"><td class="halftime" id="${zero}${hour}:${minutes}0-${tdnum}"></td></c:when>
		        		<c:otherwise><td class="hiddenborder" id="${zero}${hour}:${minutes}0-${tdnum}"></td></c:otherwise>
		        	</c:choose>
	            </c:forEach>
	            </tr>
	        </c:forEach>
        </c:forEach>
    	</table>
    </c:if>
    <c:if test="${tdlength == 0}">
    	<p id="nonesche">スケジュールが登録されていません！</p>
    </c:if>
    </div>

<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/calendar.js"></script>
<script src="js/date.js"></script>
<script src="takahashi/drawer.js"></script>
<script src="js/schedule_list.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Modaal/0.4.4/js/modaal.min.js"></script>
<script src="js/modal_detail.js"></script>
<script src="js/speech_bubble.js"></script>
<%@include file="/include/includeJS.jsp"%>
</body>
</html>