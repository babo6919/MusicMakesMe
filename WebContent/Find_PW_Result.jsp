<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="vo.MemberBean"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
<div align="center">
<table >
	<tr><td colspan=2 ><h1>비밀번호 찾기</h1></td></tr>	
	<tr>
		<td>비밀번호 : </td>
		<td>${find_PW.PW}</td>
	</tr> 
</table>
</div>
</body>
</html>