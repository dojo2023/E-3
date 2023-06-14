let settime = new Date(document.getElementById("settime").innerHTML);

function Time() {
    let time = new Date();
    let year = time.getFullYear();
    let month = time.getMonth() + 1;
    let date = time.getDate();
    let hour = time.getHours();
    let minutes  = time.getMinutes();
    let seconds  = time.getSeconds();
    let text = year + "/" + month.toString().padStart(2, "0") + "/" + date.toString().padStart(2, "0") + " " + hour.toString().padStart(2, "0") + ":" + minutes.toString().padStart(2, "0") + ":" + seconds.toString().padStart(2, "0");
    document.getElementById("nowtime").innerHTML = text;


    let nowtime = Date.now();
    let ms = settime.getTime() - nowtime;
    let timeLeftdate = Math.floor(ms / 1000 / 60 / 60 / 24);    //ok
    let timeLefthour = Math.floor(ms / 1000 / 60 / 60) % 24;    //ok
    let timeLeftminutes = Math.floor(ms / 1000 / 60) % 60;      //ok
    let timeLeftseconds = Math.floor(ms / 1000) % 60;           //ok
    let timeLefttext = timeLeftdate.toString().padStart(2, "0") + "日 " + timeLefthour.toString().padStart(2, "0") + ":" + timeLeftminutes.toString().padStart(2, "0") + ":" + timeLeftseconds.toString().padStart(2, "0");
    document.getElementById("timeleft").innerHTML = timeLefttext;
}
setInterval('Time()',1000);

function defTime() {
    let time = new Date();
    let year = time.getFullYear();
    let month = time.getMonth() + 1;
    let date = time.getDate();
    let hour = time.getHours();
    let minutes  = time.getMinutes();
    //let seconds  = time.getSeconds();

    let startdate = document.getElementById("startdate");
    startdate.setAttribute('value', year + "-" + month.toString().padStart(2, "0") + "-" + date.toString().padStart(2, "0"));

    let starttime = document.getElementById("starttime");
    starttime.setAttribute('value', hour.toString().padStart(2, "0") + ":" + minutes.toString().padStart(2, "0"));

    let enddate = document.getElementById("enddate");
    enddate.setAttribute('value', year + "-" + month.toString().padStart(2, "0") + "-" + date.toString().padStart(2, "0"));

    let endtime = document.getElementById("endtime");
    endtime.setAttribute('value', (hour + 1).toString().padStart(2, "0") + ":" + minutes.toString().padStart(2, "0"));
}

defTime();
