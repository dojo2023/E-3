let pet_radio = document.getElementsByName('pet_id');
let img_pet = document.getElementById('img_pet');
window.addEventListener( "DOMContentLoaded" , ()=> {
    dressradio.forEach(
        r => r.addEventListener("change" ,
            e => img_pet.src = "img/pet" + e.target.value + ".png"//console.log(e.target.value)
            )
    );
});