$(function() {
    var num = 0;
    var img = $(".kuma img"); // 画像のクラス名
    var max = 4; // 画像枚数
    var speed = 90; // 画像切り替えスピード
  
    // パラパラアニメーション
    setInterval(function() {
      num++
      // 画像形式を変更する場合は ↓の「.png」を変更してね！
      img.attr({src: 'img/' + num + '.png'});
      // アニメーションを繰り返さない場合は ↓の一行を削除してね！
      if(num == max) {num = 0;}
    }, speed);
  });