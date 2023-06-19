let formObj = document.getElementById("login_form");
let errorMessageObj = document.getElementById('error_message');

/* [実行]ボタンをクリックしたときの処理 */
formObj.onsubmit = function() {
 	if (!formObj.user_name.value) {
    	errorMessageObj.textContent = '※未入力の項目があります！';
    	return false;
  	}
};
errorMessageObj.textContent = null;