
let imgNum = 101;
let end = 109;
while(imgNum <= end){
    $("#stylesheet").append(`
    input[type=radio][value="` + imgNum + `"]+label:before{
        background-image: url(/img/` + imgNum + `.png);
    }
    `);
    imgNum++;
    console.log(imgNum);
}