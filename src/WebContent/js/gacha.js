//にわとり回転
let result = document.getElementById("result").textContent;
let egg = document.getElementById("egg");
let rarity = document.getElementById("rarity").textContent;
let alert = document.getElementById("alert").textContent;

window.onload=function(){
console.log("ろーど");
document.getElementById("egg").style.visibility ="hidden";
 if(result== 'OK'){
 console.log("ok");
 const egg = document.getElementById("egg");

//レア度ごとにニワトリの回転スピードを変更
if(rarity==2){
 document.querySelector(`.rotate_chicken`).animate(
 [
 		{ transform: 'rotateY(0deg)' },
 		{ transform: 'rotateY(360deg)' }
 	],
 	{
 		duration: 150,
 		easing: 'linear',
 		iterations: 20
 	});
 }else if(rarity==3){
 document.querySelector(`.rotate_chicken`).animate(
 [
 		{ transform: 'rotateY(0deg)' },
 		{ transform: 'rotateY(360deg)' }
 	],
 	{
 		duration: 3000,
 		easing: 'linear',
 		iterations: 1
 	});
 }else{
  document.querySelector(`.rotate_chicken`).animate(
 [
 		{ transform: 'rotateY(0deg)' },
 		{ transform: 'rotateY(360deg)' }
 	],
 	{
 		duration: 380,
 		easing: 'linear',
 		iterations: 8
 	});
 }


    //たまご出現
 	window.setTimeout(function(){
 	if(rarity==1){
 	egg.setAttribute("src","/Esan/img/egg1.png");
 	}else if(rarity==2){
 	egg.setAttribute("src","/Esan/img/egg2.png");
 	}else if(rarity==3){
 	egg.setAttribute("src","/Esan/img/egg3.png");
 	}
 	}, 3000);

 	//たまご回転
 	if(rarity>=1&&rarity<=3){
 	window.setTimeout(function(){
 	egg.style.visibility ="visible";//たまご表示
 	document.querySelector(`.rotate_egg`).animate(
 [
 		{ transform: 'rotateX(320deg)' },
 		{ transform: 'rotateX(340deg)' }
 	],
 	{
 		duration: 700,
 		easing: 'linear',
 		iterations: 1
 	});
 	}, 3000);
 	}


 	}
 	}


 //モーダル内の星の数
if(rarity==1){
   star.setAttribute("src","/Esan/img/rarity1.png");
}else if(rarity==2){
   star.setAttribute("src","/Esan/img/rarity2.png");
}else if(rarity==3){
   star.setAttribute("src","/Esan/img/rarity3.png");
}
//モーダル内の割れた卵
if(rarity==1){
   broken_egg.setAttribute("src","/Esan/img/brokenegg1.png");
}else if(rarity==2){
   broken_egg.setAttribute("src","/Esan/img/brokenegg2.png");
}else if(rarity==3){
   broken_egg.setAttribute("src","/Esan/img/brokenegg3.png");
}
//アラート文
if(alert==1){
  window.alert("コインが足りません！ガチャを引くには10枚のコインが必要です。");
}