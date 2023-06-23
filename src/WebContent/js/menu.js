/**
 *
 */
 //ログアウト処理
let logout = document.getElementById("logout");
logout.onclick = function(){
	if(window.confirm("ログアウトしてもよろしいですか？")){
		//ログアウト処理
		console.log('ログアウト処理');
		/*sessionStorage.removeItem('user_name');*/
		location.href="/Esan/LoginServlet";

	}else{
		//ログアウトキャンセル処理
		console.log('ログアウトキャンセル処理');
	}
};