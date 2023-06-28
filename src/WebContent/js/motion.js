const target = document.getElementById('touch');
let judge = false;
let pet_id = document.getElementById("pet_id").textContent;
let rand = 0;

target.addEventListener('mouseover', () =>{
    judge = true;
    rand = Math.floor(Math.random() * 3) + 1;
});
target.addEventListener('mouseleave', () =>{
    judge = false;
});

$(function () {
    var num = 0;
    var head = $("#head"); // 画像のクラス名
    var right = $("#right"); // 画像のクラス名
    var left = $("#left"); // 画像のクラス名
    var max = 2; // 画像枚数
    var speed = 200; // 画像切り替えスピード

    // パラパラアニメーション
    setInterval(function() {
        if(judge){
            // 画像形式を変更する場合は ↓の「.png」を変更してね！
            if(rand == 1){
                head.attr({src: 'imgpet'+pet_id+'/head'+num+'.png'});
            }else if(rand == 2){
                right.attr({src: 'imgpet'+pet_id+'/right'+num+'.png'});
            }else if(rand == 3){
                left.attr({src: 'imgpet'+pet_id+'/left'+num+'.png'});
            }
                // アニメーションを繰り返さない場合は ↓の一行を削除してね！
            if(num == max) {
                num = 0;
            }else{
                num++;
            }
        }else{
            head.attr({src: 'imgpet'+pet_id+'/head0.png'});
            right.attr({src: 'imgpet'+pet_id+'/right0.png'});
            left.attr({src: 'imgpet'+pet_id+'/left0.png'});
        }
    }, speed);
});

