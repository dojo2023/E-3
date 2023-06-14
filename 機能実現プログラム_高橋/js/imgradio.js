let dressradio = document.getElementsByName('dress');
let imgdress = document.getElementById('imgdress');
window.addEventListener( "DOMContentLoaded" , ()=> {
    dressradio.forEach(
        r => r.addEventListener("change" ,
            e => imgdress.src = "img/" + e.target.value + ".png"//console.log(e.target.value)
            )
    );
});

let hatradio = document.getElementsByName('hat');
let imghat = document.getElementById('imghat');
window.addEventListener( "DOMContentLoaded" , ()=> {
    hatradio.forEach(
        r => r.addEventListener("change" ,
            e => imghat.src = "img/" + e.target.value + ".png"//console.log(e.target.value)
            )
    );
});

let grassradio = document.getElementsByName('grass');
let imggrass = document.getElementById('imggrass');
window.addEventListener( "DOMContentLoaded" , ()=> {
    grassradio.forEach(
        r => r.addEventListener("change" ,
            e => imggrass.src = "img/" + e.target.value + ".png"//console.log(e.target.value)
            )
    );
});

let bgradio = document.getElementsByName('bg');
let imgbg = document.getElementById('imgbg');
window.addEventListener( "DOMContentLoaded" , ()=> {
    bgradio.forEach(
        r => r.addEventListener("change" ,
            e => imgbg.src = "img/" + e.target.value + ".png"//console.log(e.target.value)
            )
    );
});