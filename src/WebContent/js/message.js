const pettarget = document.getElementById('touch');
let messagetarget = document.getElementById("messagetarget");
let messagelen = document.getElementById("messagelen").textContent;

let message = "";
let mlist = [];

for(let i=0; i < messagelen; i++){
	message = document.getElementById('message_content'+i).textContent;
	mlist.push(message);
}
console.log(mlist);

pettarget.addEventListener('click', () =>{
	console.log("クリック");
    rand = Math.floor(Math.random() * messagelen - 1) + 1;
	messagetarget.innerHTML = mlist[rand];
});
