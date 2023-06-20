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
        <input type="hidden" name="date" value="" id="daysvalue">
    </form>
    <p>日にちを返す:${date}</p>

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
        <img src="img/pet${pet}mini.png"/>
        <div class="balloon1">
            <p>${id} さん、おはよう。</p>
          </div>
    </div>

    <div>
        <img src="takahashi/fcmini.png"/>コイン枚数:${coin}
    </div>

    <div>
        <form method="GET" name="regist" action="Schedule_listServlet">
            <input type="submit" name="regist" value="スケジュール登録">
        </form>
    </div>

    <div>
        <form method="POST" action="/Esan/Schedule_listServlet">
        	<input type="hidden" name="userid" value="ユーザ名">
            <input type="submit" name="values" value="スケジュール表示">
        </form>
    </div>
    <c:forEach var="e" items="${scheduleList}" >
    <p>${e.user_name} ${e.schedule_name} ${e.start_date} ${e.start_time} ${e.finish_date} ${e.finish_time} ${e.color_code} ${e.content}</p>
    </c:forEach>
    <p>${scheduleList[1].user_name}</p>
    <p>${fn:length(scheduleList)}</p>

    <div id="schedule">
    <c:set var="count" value="0" />
    <c:set var="colorcount" value="0" />
    <c:set var="tdlength" value="${fn:length(scheduleList)}"/>
    <c:set var="tdcount" value="0" />
    <c:set var="manytd" value="<td></td>"/>
    <c:set var="judge" value="false"/>

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

	        	<c:if test="${time == scheduleList[tdcount + 1].start_time}">
			    	<c:set var="tdcount" value="${tdcount + 1}" />
			    	<c:set var="colorcount" value="${colorcount + 1}" />
			    </c:if>

			    <c:if test="${tdcount == 0}">
					<c:choose>
	            	<c:when test="${(hour >= scheduleList[colorcount].start_hour && hour < scheduleList[colorcount].finish_hour) || (hour == scheduleList[colorcount].finish_hour && minutes == 0)}">
	            		<td class="td${colorcount}" bgcolor="${scheduleList[colorcount].color_code}">
	            	</c:when>
	            	<c:otherwise>
	            		<td class="td${colorcount}">
	            	</c:otherwise>
	            	</c:choose>
				</c:if>

				<c:if test="${tdcount != 0}">
						<c:forEach begin="0" end="${tdcount-1}" step="1" var="tdnum">
		            		<c:choose>
			            	<c:when test="${(hour >= scheduleList[tdnum].start_hour && hour < scheduleList[tdnum].finish_hour) || (hour == scheduleList[tdnum].finish_hour && minutes == 0)}">
			            		<td class="td${tdnum}" bgcolor="${scheduleList[tdnum].color_code}">
			            	</c:when>
			            	<c:otherwise>
			            		<td class="td${tdnum}">
			            	</c:otherwise>
			            	</c:choose>
	            		</c:forEach>
						<c:choose>
		            	<c:when test="${(hour >= scheduleList[colorcount].start_hour && hour < scheduleList[colorcount].finish_hour) || (hour == scheduleList[colorcount].finish_hour && minutes == 0)}">
		            		<td class="td${colorcount}" bgcolor="${scheduleList[colorcount].color_code}">
		            	</c:when>
		            	<c:otherwise>
		            		<td class="td${colorcount}">
		            	</c:otherwise>
		            	</c:choose>
				</c:if>

	            <c:if test="${time == scheduleList[count].start_time}">
            		${scheduleList[count].start_time} - ${scheduleList[count].finish_time}<br>
            		<a href="#info${count}" class="modal-open">${scheduleList[count].schedule_name}</a>

            		<!-- モーダルウィンドウ内 -->
            		<section id="info${count}" style="display:none">
				        <h2>${scheduleList[count].schedule_name} ${scheduleList[count].start_time} - ${scheduleList[count].finish_time}</h2>
				        <p>${scheduleList[count].content}</p>
				        <form method="POST" name="edit" action="/Esan/Schedule_editServlet">
				            <input type="submit" name="edit" value="編集">
				        </form>
				        <form method="POST" name="delete" action="/Esan/Schedule_listServlet">
				            <input type="submit" name="delete" value="削除">
				        </form>
				    </section>

				    <c:set var="count" value="${count + 1}" />
            	</c:if>
			    </td>

	        </c:forEach>
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