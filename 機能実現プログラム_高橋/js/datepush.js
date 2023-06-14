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

    /*
    if(/[0-9][0-9]/.test(timeLeftseconds)){
        Push.create("プッシュ通知", //プッシュ通知のタイトル
        {
        body: "プッシュ通知のテストです。", //プッシュ通知の内容
        icon: "img/1.png",
        timeout: 8000, //プッシュ通知を表示する時間
        onClick: function () { //プッシュ通知をクリックしたときのイベント
        window.focus(); //プッシュ通知をしたWebサイトを開く
        this.close(); //プッシュ通知を閉じる
        }
        });
    }
    */

    if(timeLeftminutes == 10 && timeLeftseconds == 0){
        Push.create("プッシュ通知", //プッシュ通知のタイトル
        {
        body: "プッシュ通知のテストです。", //プッシュ通知の内容
        icon: "img/1.png",
        timeout: 8000, //プッシュ通知を表示する時間
        onClick: function () { //プッシュ通知をクリックしたときのイベント
        window.focus(); //プッシュ通知をしたWebサイトを開く
        this.close(); //プッシュ通知を閉じる
        }
        });
    }
}

setInterval('Time()',1000);