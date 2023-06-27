
//モーダル表示
$(".modal-open").modaal({
start_open:false, // ページロード時に表示するか
overlay_close:true,//モーダル背景クリック時に閉じるか
before_open:function(){// モーダルが開く前に行う動作
    $('html').css('overflow-y','hidden');/*縦スクロールバーを出さない*/
},
after_close:function(){// モーダルが閉じた後に行う動作
    $('html').css('overflow-y','scroll');/*縦スクロールバーを出す*/
}
});

let coinresult = document.getElementById("coinresult").textContent;
let btn = document.getElementById("coinbtn");

window.setTimeout(function(){
    if(coinresult == "true"){
        btn.click();
    }
},500);