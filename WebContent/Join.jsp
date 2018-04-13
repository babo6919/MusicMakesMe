<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Join</title>
	<link rel="stylesheet" type="text/css" href="css/Join&Login.css">
</head>
<body>

<h2>회원가입</h2>
	<form action="JoinAction.me" method="post">
		<input type="text" name="ID" placeholder="아이디">
		<input type="password" name="PW" placeholder="비밀번호">
		<input type="password" name="PW_CHECK" placeholder="비밀번호 확인">
		<input type="text" name="NAME" placeholder="이름">
		<input type="text" name="EMAIL" placeholder="이메일">
		<input type="text" name="ADDR" placeholder="주소"> 
		<input type="submit"
			value="회원가입"
			style="width: 365px; height: 35px; padding: 5px; border-radius: 3px; border: 0; font-size: 18px;">
	</form>	

</body>
</html>