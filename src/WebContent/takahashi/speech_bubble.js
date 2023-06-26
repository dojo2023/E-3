let message = document.getElementById("message");
let now = new Date;
let nyear = now.getFullYear();
let nmonth = now.getMonth();
let ndate = now.getDate();

let ms = new Date(nyear, nmonth, ndate, 4, 0, 0);
let me = new Date(nyear, nmonth, ndate, 11, 0, 0);
let hs = new Date(nyear, nmonth, ndate, 11, 1, 0);
let he = new Date(nyear, nmonth, ndate, 17, 0, 0);

function mTime() {
    let time = new Date();

    let hour = time.getHours();
    let minutes  = time.getMinutes();

    if(time > ms && time < me){
        message.innerHTML = "おはよう";
        console.log("おはようございます！");
    }else if(time > hs && time < he){
        message.innerHTML = "こんにちは！";
        console.log("こんにちは!");
    }else {
        message.innerHTML = "こんばんは！";
        console.log("こんばんは!");
    }
}

mTime();