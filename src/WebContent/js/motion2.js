
/*[1]クリック時に実行する関数*/
function clickListener (e) {
  /*クリックした要素のIDを表示*/
  alert( e.target.getAttribute("id") + "をクリックしました" )
}
/*[2]IMG要素をすべてセレクト*/
document.querySelectorAll("img").forEach((imgElm) => {
  /*[3]要素のクリックイベントにイベントリスナーをひもづける*/
  imgElm.addEventListener('click', clickListener);
})