const target = document.getElementById('touch');
let judge = false;

target.addEventListener('mouseover', () =>{
  judge = true;
  console.log(judge);
});
target.addEventListener('mouseleave', () =>{
  judge = false;
  console.log(judge);
});

$(function () {
  var num = 0;
  var img = $(".arm img"); // 画像のクラス名
  var max = 1; // 画像枚数
  var speed = 90; // 画像切り替えスピード

  // パラパラアニメーション
  setInterval(function() {
    if(judge){
    // 画像形式を変更する場合は ↓の「.png」を変更してね！
    img.attr({src: 'img/6' + num + '.png'});
    // アニメーションを繰り返さない場合は ↓の一行を削除してね！
    if(num == max) {
      num = 0;
    }else{
      num++;
    }
  }
  }, speed);
});

