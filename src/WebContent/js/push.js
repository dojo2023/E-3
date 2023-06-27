let slen = document.getElementById("slength").textContent;
let pet_id = document.getElementById("pet_id").textContent;

function GoPush(){
for(let k=0;k<slen;k++){
    let schedule_name = document.getElementById("schedule_name" + k).textContent;
    let content = document.getElementById("content" + k).textContent;

    let settime = new Date(document.getElementById("finish_date" + k).textContent + " " + document.getElementById("finish_time" + k).textContent);
    console.log(settime);

    let tenunix = settime - 600000;
    let tenminus = new Date(tenunix);
    console.log(tenminus.toLocaleString('ja-JP'));

    let nowtime = new Date();
    console.log(nowtime.toLocaleString('ja-JP'));

    if(nowtime.toLocaleString('ja-JP') === tenminus.toLocaleString('ja-JP')){
        console.log("一致");
        Push.create(schedule_name, //プッシュ通知のタイトル
        {
        body: content, //プッシュ通知の内容
        icon: `imgpet`+pet_id+`/pet`+pet_id+`.png`,
        timeout: 8000, //プッシュ通知を表示する時間
        onClick: function () { //プッシュ通知をクリックしたときのイベント
        window.focus(); //プッシュ通知をしたWebサイトを開く
        this.close(); //プッシュ通知を閉じる
        }
        });
    }
}
}

setInterval('GoPush()',1000);
