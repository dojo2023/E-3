<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="tdlength" value="${fn:length(scheduleList)}"/>
<div id="slength">${tdlength}</div>
<c:set var="i" value="0"/>
<c:forEach var="e" items="${sessionscheduleList}" >
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

<c:set var="pet_id" value="${sessionuserdata.pet_id}"/>
<div id="pet_id" style="display:none">${pet_id}</div>