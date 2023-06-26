//にわとり回転
let result = document.getElementById("result").textContent;
let egg = document.getElementById("egg");
window.onload=function(){
console.log("ろーど");
 if(result== 'OK'){
 console.log("ok");
 document.querySelector(`.rotateY`).animate(
 [
 		{ transform: 'rotateY(0deg)' },
 		{ transform: 'rotateY(360deg)' }
 	],
 	{
 		duration: 300,
 		easing: 'linear',
 		iterations: 10
 	});
 	egg.setAttribute("img","img/egg1.png");
 	}
 	}