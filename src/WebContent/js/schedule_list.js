let slen = document.getElementById("slength").textContent;
let senddate = document.getElementById("senddate").textContent;

for(let k=0;k<slen;k++){
    let schedule_id = document.getElementById("schedule_id" + k).textContent;
    let user_name = document.getElementById("user_name" + k).textContent;

    let schedule_name = document.getElementById("schedule_name" + k).textContent;

    let start_date = document.getElementById("start_date" + k).textContent;
    let start_time = document.getElementById("start_time" + k).textContent;
    let sdate = new Date(start_date + " " + start_time);

    let finish_date = document.getElementById("finish_date" + k).textContent;
    let finish_time = document.getElementById("finish_time" + k).textContent;
    let fdate = new Date(finish_date + " " + finish_time);

    let color_code = document.getElementById("color_code" + k).textContent;

    let content = document.getElementById("content" + k).textContent;

    let schedule_done = document.getElementById("schedule_done" + k).textContent;

    for(let i=0; i<24;i++){
        for(let j=0; j<=5;j++){
            if(i<10){
                for(let l=0; l<=9; l++){
                    if(start_time == "0"+i+":"+j+l){
                        document.getElementById("0"+i+":"+j+"0" + "-" + k).innerHTML = `
                        <form method="POST" action="/Esan/Schedule_listServlet" name="checkform">
                            <input type="hidden" name="schedule_id" value=`+schedule_id+`>
                            <input type="hidden" name="senddate" value=`+senddate+`>
                            <input type="submit" name="values" value="完了" id="`+schedule_done+`">
                        </form>
                        <span>`+start_time+`- `+finish_time+`</span><br>
                        <a href="#info`+k+`" class="modal-open">`+schedule_name+`</a>` +
                        `<section id="info`+k+`" style="display:none">
                        <h2 class="schedulename">`+schedule_name+`</h2>
                        <h3 class="scheduletime">`+start_time+ "-"+ finish_time+`<h3>
                        <p class="schedulecontent">`+content+`</p>
                        <div class="modalbtn">
                        <form method="POST" name="edit" action="/Esan/Schedule_editServlet">
                            <input type="hidden" name="schedule_id" value="`+schedule_id+`">
                            <input type="submit" name="edit" value="編集" class="editbtn">
                        </form>
                        <form method="POST" name="delete" action="/Esan/Schedule_listServlet">
                            <input type="hidden" name="schedule_id" value="`+schedule_id+`">
                            <input type="hidden" name="senddate" value=`+senddate+`>
                            <input type="submit" name="values" value="削除" class="deletebtn">
                        </form>
                        </div>
                        </section>`
                        ;
                    }
                }
            }else{
                for(let l=0; l<=9; l++){
                    if(start_time == i+":"+j+l){
                        document.getElementById(i+":"+j+"0" + "-" + k).innerHTML = `
                        <form method="POST" action="/Esan/Schedule_listServlet" name="checkform">
                            <input type="hidden" name="schedule_id" value=`+schedule_id+`>
                            <input type="hidden" name="senddate" value=`+senddate+`>
                            <input type="submit" name="values" value="完了" id="`+schedule_done+`">
                        </form>
                        <span>`+start_time+`- `+finish_time+`</span><br>
                        <a href="#info` +k+`" class="modal-open">`+schedule_name+`</a>`+
                        `<section id="info`+k+`" style="display:none">
                        <h2 class="schedulename">`+schedule_name+`</h2>
                        <h3 class="scheduletime">`+start_time+ "-"+ finish_time+`<h3>
                        <p class="schedulecontent">`+content+`</p>
                        <div class="modalbtn">
                        <form method="POST" name="edit" action="/Esan/Schedule_editServlet">
                            <input type="hidden" name="schedule_id" value="`+schedule_id+`">
                            <input type="submit" name="edit" value="編集" class="editbtn">
                        </form>
                        <form method="POST" name="delete" action="/Esan/Schedule_listServlet">
                            <input type="hidden" name="schedule_id" value="`+schedule_id+`">
                            <input type="hidden" name="senddate" value=`+senddate+`>
                            <input type="submit" name="values" value="削除" class="deletebtn">
                        </form>
                        </div>
                        </section>`
                        ;
                    }
                }
            }
        }
    }

    for(let i=0; i<24;i++){
        for(let j=0; j<=5;j++){
            if(i<10){
                let colorday = "0"+i+":"+j+"9";
                let colorfday = "0"+i+":"+j+"0";
                let colordate = new Date(start_date + " " + colorday);
                let colorfdate = new Date(start_date + " " + colorfday);
                if(sdate <= colordate && fdate >= colorfdate){
                    document.getElementById("0"+i+":"+j+"0" + "-" + k).setAttribute("bgcolor",color_code);
                }
            }else{
                let colorday = "0"+i+":"+j+"9";
                let colorfday = "0"+i+":"+j+"0";
                let colordate = new Date(start_date + " " + colorday);
                let colorfdate = new Date(start_date + " " + colorfday);
                if(sdate <= colordate && fdate >= colorfdate){
                    document.getElementById(i+":"+j+"0" + "-" + k).setAttribute("bgcolor",color_code);
                }
            }
        }
    }
}