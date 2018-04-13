<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="css/Join&Login.css">
</head>
<body>
	<form action="LoginAction.me" method="post">
		<h2>로그인</h2>
		<input type="text" name="ID" placeholder="아이디">
		<input type="password" name="PW" placeholder="비밀번호">
		<button class="btn-login">로그인</button>
	</form>
	<a href="./LoginMain.jsp?page=Find_ID"><button class="btn-Change">아이디 찾기</button></a>
	<a href="./LoginMain.jsp?page=Find_PW"><button class="btn-Change">비밀번호 찾기</button></a>
</body>
</html>