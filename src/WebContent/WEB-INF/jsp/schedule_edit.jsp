<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <input type="text" id="title" placeholder="スケジュール名">
    <select id="color">
        <option value="色">色を選択してください</option>
        <option value="赤">赤</option>
        <option value="青">青</option>
        <option value="黄色">黄色</option>
        <option value="緑">緑</option>
        <option value="紫">紫</option>
        <option value="オレンジ">オレンジ</option>
        <option value="茶色">茶色</option>
        <option value="マゼンタ">マゼンタ</option>
        <option value="シアン">シアン</option>
        <option value="ピンク">ピンク</option>
    </select><br>
    <input type="date"><input type="time"> ～ <input type="date"><input type="time"><br>
    <textarea id="content" cols="30" rows="10" placeholder="内容"></textarea>
    <p>(エラーメッセージをここに挿入)</p>

    <input type="button" id="back_btn" value="登録せずに戻る">
    <input type="submit" id="regist_btn" value="登録">

</body>
</html>