let slen = document.getElementById("slength").textContent;

for(let k=0;k<slen;k++){
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

    for(let i=0; i<24;i++){
        for(let j=0; j<=5;j++){
            if(i<10){
                if(start_time == "0"+i+":"+j+"0"){
                    document.getElementById("0"+i+":"+j+"0" + "-" + k).innerHTML = `<input type="checkbox" value="completion"><span>`+start_time+`- `+finish_time+`</span><br><a href="#info`+k+`" class="modal-open">`+schedule_name+`</a>` + 
                    `<section id="info`+k+`" style="display:none">
                    <h2>`+schedule_name+ start_time+ "-"+ finish_time +`</h2>
                    <p>`+content+`</p>
                    <form method="POST" name="edit" action="/Esan/Schedule_editServlet">
                        <input type="submit" name="edit" value="編集">
                    </form>
                    <form method="POST" name="delete" action="/Esan/Schedule_listServlet">
                        <input type="submit" name="delete" value="削除">
                    </form>
                    </section>`
                    ;
                }
            }else{
                if(start_time == i+":"+j+"0"){
                    document.getElementById(i+":"+j+"0" + "-" + k).innerHTML = `<input type="checkbox" value="completion"><span>`+start_time+`- `+finish_time+`</span><br><a href="#info` +k+`" class="modal-open">`+schedule_name+`</a>`+
                    `<section id="info`+k+`" style="display:none">
                    <h2>`+schedule_name+ start_time+ "-"+ finish_time +`</h2>
                    <p>`+content+`</p>
                    <form method="POST" name="edit" action="/Esan/Schedule_editServlet">
                        <input type="submit" name="edit" value="編集">
                    </form>
                    <form method="POST" name="delete" action="/Esan/Schedule_listServlet">
                        <input type="submit" name="delete" value="削除">
                    </form>
                    </section>`
                    ;
                }
            }
        }
    }

    for(let i=0; i<24;i++){
        for(let j=0; j<=5;j++){
            if(i<10){
                let colorday = "0"+i+":"+j+"0"
                let colordate = new Date(start_date + " " + colorday);
                if(sdate <= colordate && fdate >= colordate){
                    document.getElementById("0"+i+":"+j+"0" + "-" + k).setAttribute("bgcolor",color_code);
                }
            }else{
                let colorday = i+":"+j+"0"
                let colordate = new Date(start_date + " " + colorday);
                if(sdate <= colordate && fdate >= colordate){
                    document.getElementById(i+":"+j+"0" + "-" + k).setAttribute("bgcolor",color_code);
                }
            }
        }
    }
}
