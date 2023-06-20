let form = document.getElementById("regist");
let alertmsgObj = document.getElementById("error_message");

/* 登録ボタン押下 */
form.onsubmit = function(){
	if(!form.user_name.value || !form.title.value || !form.color.value || !form.start_date.value || !form.start_time.value || !form.finish_date.value || !form.finish_time.value ){
		alertmsgObj.textContent = '※未入力の項目があります';
		return false;
	}
errorMessageObj.textContent = null;
};
