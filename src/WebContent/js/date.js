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
}
setInterval('Time()',1000);