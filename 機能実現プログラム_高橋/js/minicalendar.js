const week = ["日", "月", "火", "水", "木", "金", "土"];
const today = new Date();
// 月末だとずれる可能性があるため、1日固定で取得
var showDate = new Date(today.getFullYear(), today.getMonth(), 1);

// 初期表示
window.onload = function () {
    showProcess(today, calendar);
};
// 前の月表示
function prev(){
    showDate.setMonth(showDate.getMonth() - 1);
    showProcess(showDate);
}

// 次の月表示
function next(){
    showDate.setMonth(showDate.getMonth() + 1);
    showProcess(showDate);
}

// カレンダー表示
function showProcess(date) {
    var year = date.getFullYear();
    var month = date.getMonth();
    document.querySelector('#miniheader').innerHTML = year + "年 " + (month + 1) + "月";

    var calendar = createProcess(year, month);
    document.querySelector('#minicalendar').innerHTML = calendar;
}

// カレンダー作成
function createProcess(year, month) {
    // 曜日
    var calendar = "<table><tr class='dayOfWeek'>";
    for (var i = 0; i < week.length; i++) {
        calendar += "<th>" + week[i] + "</th>";
    }
    calendar += "</tr>";

    var count = 0;
    var startDayOfWeek = new Date(year, month, 1).getDay();
    var endDate = new Date(year, month + 1, 0).getDate();
    var lastMonthEndDate = new Date(year, month, 0).getDate();
    var row = Math.ceil((startDayOfWeek + endDate) / week.length);

    // 1行ずつ設定
    for (var i = 0; i < row; i++) {
        calendar += "<tr>";
        // 1colum単位で設定
        for (var j = 0; j < week.length; j++) {
            if (i == 0 && j < startDayOfWeek) {
                // 1行目で1日まで先月の日付を設定
                calendar += "<td class='disabled'>" + (lastMonthEndDate - startDayOfWeek + j + 1) + "</td>";
            } else if (count >= endDate) {
                // 最終行で最終日以降、翌月の日付を設定
                count++;
                calendar += "<td class='disabled'>" + (count - endDate) + "</td>";
            } else {
                // 当月の日付を曜日に照らし合わせて設定
                count++;
                if(year == today.getFullYear()
                  && month == (today.getMonth())
                  && count == today.getDate()){
                    calendar += "<td class='today' id=days" + count + ">" + count + "</td>";
                } else {
                    calendar += "<td id=days" + count + ">" + count + "</td>";
                }
            }
        }
        calendar += "</tr>";
    }
    return calendar;
}

$(document).on('click', '#days' + 1, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 2, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 3, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 4, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 5, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 6, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 7, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 8, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 9, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 10, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 11, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 12, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 13, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 14, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 15, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 16, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 17, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 18, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 19, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 20, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 21, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 22, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 23, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 24, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 25, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 26, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 27, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 28, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 29, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 30, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});
$(document).on('click', '#days' + 31, function() {
    console.log(showDate.getFullYear() + "/" + (showDate.getMonth()+1) + "/" + this.textContent);
});